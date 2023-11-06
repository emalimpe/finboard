package com.finboard.isa.isa.test.repoTest.persistent;
import java.util.Random;

import com.finboard.isa.isa.model.Azienda;
import com.finboard.isa.isa.model.ContoEconomico;
import com.finboard.isa.isa.model.StatoPatrimoniale;
import com.finboard.isa.isa.repo.AziendaRepository;
import com.finboard.isa.isa.repo.StatoPatrimonialeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class StatoPatrimonialeRepositoryTest {

    Random rand = new Random();
    @Autowired
    StatoPatrimonialeRepository spr;
    @Autowired
    AziendaRepository ar;

    @Test
    @Order(1)
    public void testAddNew(){
        List<Azienda> aziende = this.ar.findAll();
        for(Azienda a: aziende){
            for(int i = 0; i < 3; i++){
                int seed = rand.nextInt(10000,10000000);
                StatoPatrimoniale sp = new StatoPatrimoniale();
                int j = 0;
                LocalDate myObj = LocalDate.now().minusYears(i); // Create a date object
                Date data = Date.valueOf(myObj); // Create a date object
                sp.setStilatura(data);
                sp.setIdAzienda(a);
                sp.setImmobilizzazioniImmateriali(1+(i+1)*(++j + a.getId())+seed);
                sp.setImmobilizzazioniFinanziarie(1+(i+1)*(++j + a.getId())+seed);
                seed = rand.nextInt(10000,10000000);
                sp.setImmobilizzazioniMateriali(1+(i+1)*(++j + a.getId())+seed);
                sp.setRimanenzeMagazzino(1+(i+1)*(++j + a.getId())+seed);
                sp.setLiquiditaDifferite(1+(i+1)*(++j + a.getId())+seed);
                sp.setLiquiditaImmediate(1+(i+1)*(++j + a.getId())+seed);
                seed = rand.nextInt(10000,10000000);
                sp.setCapitaleSociale(1+(i+1)*(++j + a.getId())+seed);
                sp.setRiservaLegale(1+(i+1)*(++j + a.getId())+seed);
                sp.setRiservaStraordinaria(1+(i+1)*(++j + a.getId())+seed);
                sp.setRiservaPartecipazioni(1+(i+1)*(++j + a.getId())+seed);
                seed = rand.nextInt(10000,10000000);
                sp.setTfrConsolidato(1+(i+1)*(++j + a.getId())+seed);
                sp.setTfrCorrente(1+(i+1)*(++j + a.getId())+seed);
                sp.setDebitiBancheConsolidati(1+(i+1)*(++j + a.getId())+seed);
                sp.setDebitiBancheCorrenti(1+(i+1)*(++j + a.getId())+seed);
                sp.setDebitiFornitoriConsolidati(1+(i+1)*(++j + a.getId())+seed);
                seed = rand.nextInt(10000,10000000);
                sp.setDebitiFornitoriCorrenti(1+(i+1)*(++j + a.getId())+seed);
                sp.setDebitiTributariConsolidati(1+(i+1)*(++j + a.getId())+seed);
                sp.setDebitiTributariCorrenti(1+(i+1)*(++j + a.getId())+seed);
                sp.setDebitiTitoliAzionari(1+(i+1)*(++j + a.getId())+seed);
                seed = rand.nextInt(10000,10000000);
                sp.setDebitiAzionisti(1+(i+1)*(++j + a.getId())+seed);
                StatoPatrimoniale saved = this.spr.save(sp);
                Assertions.assertThat(saved).isNotNull();
                Assertions.assertThat(saved.getId()).isGreaterThan(0);
            }
        }
    }

    @Test
    @Order(2)
    public void testUpdate(){
        Long id = 52L;//necessario osservare l'id dal DB perche' generato automaticamente al momento dell'inserimento
        Optional<StatoPatrimoniale> oce = this.spr.findById(id);
        StatoPatrimoniale toModify = oce.get();
        toModify.setDebitiAzionisti(0);
        this.spr.save(toModify);
        StatoPatrimoniale returned = this.spr.findById(id).get();
        Assertions.assertThat(returned.getDebitiAzionisti()).isEqualTo(0);
        //Assertions.assertThat(returned.getAttivo()).isGreaterThan(0);
    }

    @Test
    @Order(3)
    public void testGet(){
        Long id = 54L;//necessario osservare l'id dal DB perche' generato automaticamente al momento dell'inserimento
        Optional<StatoPatrimoniale> osp = this.spr.findById(id);
        Assertions.assertThat(osp).isPresent();
        System.out.println(osp.get().toString());
        Long id2 = 1004L;
        Optional<StatoPatrimoniale> osp2 = this.spr.findById(id2);
        Assertions.assertThat(osp2).isNotPresent();
    }

    @Test
    @Order(4)
    public void testListAll(){
        List<StatoPatrimoniale> sps = (List<StatoPatrimoniale>)this.spr.findAll();

        sps.stream().forEach(s -> System.out.println(s.toString()));

        Assertions.assertThat(sps.size()).isGreaterThan(0);
    }

    @Test
    @Order(5)
    public void testDel(){//non eseguito
        Long id = 54L;//necessario osservare l'id dal DB perche' generato automaticamente al momento dell'inserimento
        this.spr.deleteById(id);
        Optional<StatoPatrimoniale> oce = this.spr.findById(id);
        Assertions.assertThat(oce).isNotPresent();
    }
}
