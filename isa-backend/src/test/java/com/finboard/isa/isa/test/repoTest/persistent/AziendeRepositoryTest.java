package com.finboard.isa.isa.test.repoTest.persistent;

import com.finboard.isa.isa.model.Azienda;
import com.finboard.isa.isa.repo.AziendaRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class AziendeRepositoryTest {
    @Autowired
    AziendaRepository ar;

    @Test
    @Order(1)
    public void testAddNew(){
        for(int i = 0; i < 4; i++) {
            Azienda a = new Azienda();
            a.setCodice_ateco((i+1)*1093);
            a.setDipendenti((i+1)*(i*2)*193);
            String temp = "aziendaDiProva"+i;
            a.setNome(temp);
            a.setIndirizzo("via saragat 1"+i);
            if(i%2 == 0){
                a.setSettore("defaultSettore");
            }else{
                a.setSettore("informatica");
            }
            Azienda saved = this.ar.save(a);
            Assertions.assertThat(saved).isNotNull();
            Assertions.assertThat(saved.getId()).isGreaterThan(0);
            Azienda aa = new Azienda();
            aa.setCodice_ateco((i+19)*1095);
            aa.setDipendenti((i*3+12)*33);
            temp = "aziendaDiProva22"+i;
            aa.setNome(temp);
            aa.setIndirizzo("via saragat 12"+i);
            if(i%2 == 0){
                aa.setSettore("defaultSettore");
            }else{
                aa.setSettore("informatica");
            }
            Azienda savedd = this.ar.save(aa);
            Assertions.assertThat(savedd).isNotNull();
            Assertions.assertThat(savedd.getId()).isGreaterThan(0);
        }
    }


    @Test
    @Order(2)
    public void testUpdate(){
            String nome = "aziendaDiProva220";
            Optional<Azienda> oa = this.ar.findByNome(nome);
            Azienda toModify = oa.get();
            toModify.setIndirizzo("Via nuova strada a viabilita' Modificata");
            this.ar.save(toModify);
            Azienda returned = this.ar.findByNome(nome).get();
            Assertions.assertThat(returned.getIndirizzo()).isEqualTo("Via nuova strada a viabilita' Modificata");
    }

    @Test
    @Order(3)
    public void testGet(){
        String nome = "aziendaDiProva2";
        Optional<Azienda> oa = this.ar.findByNome(nome);
        Assertions.assertThat(oa).isPresent();
        System.out.println(oa.get().toString());
    }

    @Test
    @Order(4)
    public void testListAll(){
        List<Azienda> as = (List<Azienda>)this.ar.findAll();
        Assertions.assertThat(as.size()).isGreaterThan(0);
    }



}
