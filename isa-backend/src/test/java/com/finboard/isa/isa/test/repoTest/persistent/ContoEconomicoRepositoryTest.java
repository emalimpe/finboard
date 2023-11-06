package com.finboard.isa.isa.test.repoTest.persistent;
import java.util.Random;
import com.finboard.isa.isa.model.Azienda;
import com.finboard.isa.isa.model.ContoEconomico;
import com.finboard.isa.isa.repo.AziendaRepository;
import com.finboard.isa.isa.repo.ContoEconomicoRepository;
import com.finboard.isa.isa.service.AziendaService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ContoEconomicoRepositoryTest {

    Random rand = new Random();
    @Autowired
    ContoEconomicoRepository cer;
    @Autowired
    AziendaRepository ar;

    @Test
    @Order(1)
    public void testAddNew(){
        List<Azienda> aziende = ar.findAll();
        for(Azienda a: aziende){
            for(int i = 0; i < 3; i++){
                int seed = rand.nextInt(10000,10000000);
                int j = 0;
                ContoEconomico ce = new ContoEconomico();
                ce.setIdAzienda(a);
                LocalDate myObj = LocalDate.now().minusYears(i); // Create a date object
                Date data = Date.valueOf(myObj); // Create a date object
                ce.setStilatura(data);
                ce.setValoreProduzione(1+(i+1)*(++j + a.getId())+seed);
                ce.setValoreAggiunto(1+(i+1)*(++j + a.getId())+seed);
                ce.setMargineOperativoLordo(1+(i+1)*(++j + a.getId())+seed);
                seed = rand.nextInt(10000,10000000);
                ce.setRedditoOperativo(1+(i+1)*(++j + a.getId())+seed);
                ce.setRedditoCorrente(1+(i+1)*(++j + a.getId())+seed);
                seed = rand.nextInt(10000,10000000);
                ce.setRedditoAnteImposte(1+(i+1)*(++j + a.getId())+seed);
                ce.setRedditoNetto(1+(i+1)*(++j + a.getId())+seed);
                ContoEconomico saved = this.cer.save(ce);
                Assertions.assertThat(saved).isNotNull();
                Assertions.assertThat(saved.getId()).isGreaterThan(0);
            }
        }
    }

    @Test
    @Order(2)
    public void testUpdate(){
        Long id = 54L;//necessario osservare l'id dal DB perche' generato automaticamente al momento dell'inserimento
        Optional<ContoEconomico> oce = this.cer.findById(id);
        ContoEconomico toModify = oce.get();
        float vecchioRedditoOperativo = toModify.getRedditoOperativo();
        toModify.setRedditoOperativo(vecchioRedditoOperativo-1);
        this.cer.save(toModify);
        ContoEconomico returned = this.cer.findById(id).get();
        Assertions.assertThat(returned.getRedditoOperativo()).isEqualTo(vecchioRedditoOperativo - 1);
        //Assertions.assertThat(returned.getRedditoAnteImposte()).isGreaterThan(0);
    }

    @Test
    @Order(3)
    public void testGet(){
        Long id = 52L;//necessario osservare l'id dal DB perche' generato automaticamente al momento dell'inserimento
        Optional<ContoEconomico> oa = this.cer.findById(id);
        Assertions.assertThat(oa).isPresent();
        System.out.println(oa.get().toString());
        Long id2 = 22004L;//probabilmente non presente... stesse considerazioni per accertamento
        Optional<ContoEconomico> oa2 = this.cer.findById(id2);
        Assertions.assertThat(oa2).isNotPresent();
    }

    @Test
    @Order(4)
    public void testListAll(){
        List<ContoEconomico> ces = (List<ContoEconomico>)this.cer.findAll();
        Assertions.assertThat(ces.size()).isGreaterThan(0);
        for(ContoEconomico ce: ces){
            System.out.println(ce.toString());
        }
    }

    @Test
    @Order(5)
    public void testDel(){ //non eseguito
        Long id = 52L;//necessario osservare l'id dal DB perche' generato automaticamente al momento dell'inserimento
        this.cer.deleteById(id);
        Optional<ContoEconomico> oce = this.cer.findById(id);
        Assertions.assertThat(oce).isNotPresent();
    }

}
