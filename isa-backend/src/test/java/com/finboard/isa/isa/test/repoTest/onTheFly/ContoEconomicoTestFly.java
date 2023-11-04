package com.finboard.isa.isa.test.repoTest.onTheFly;

import com.finboard.isa.isa.model.Azienda;
import com.finboard.isa.isa.model.ContoEconomico;
import com.finboard.isa.isa.repo.AziendaRepository;
import com.finboard.isa.isa.repo.ContoEconomicoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ContoEconomicoTestFly {
    @Autowired
    ContoEconomicoRepository cer;
    @Autowired
    AziendaRepository ar;

    @Test
    public void insertAziendaAndContoEconomico(){
        //arrange
        List<ContoEconomico> savedCE = new ArrayList<>();

        Azienda a = new Azienda();
        a.setIndirizzo("via volante 13");
        a.setDipendenti(240940);
        a.setCodice_ateco(13453);
        a.setNome("fly company");
        a.setSettore("areonautica");


        //act
        this.ar.save(a);
        Optional<Azienda> prova = this.ar.findByNome(a.getNome());
        a = prova.get();

        for(int i = 0; i < 3; i++){
            ContoEconomico ce = new ContoEconomico();
            ce.setId(a.getId() + Long.parseLong("" + i));
            ce.setIdAzienda(a);
            LocalDate myObj = LocalDate.now().minusYears(i); // Create a date object
            Date data = Date.valueOf(myObj); // Create a date object
            ce.setStilatura(data);
            ce.setValoreProduzione(110243520/123*(i+1)*(i+1)*(i+1));
            ce.setValoreAggiunto(110243520/123*(i+1)*(i+1));
            ce.setMargineOperativoLordo(110243520/123*(i+1));
            ce.setRedditoOperativo(110243520/123);
            ce.setRedditoCorrente(110243520/155);
            ce.setRedditoAnteImposte(110243520/(155+1)+(i+1));
            ce.setRedditoNetto(110243520/(155+4+i));
            savedCE.add(this.cer.save(ce));
        }
        List<ContoEconomico> proveCE = (List<ContoEconomico>) this.cer.findAll();

        //assert
        Assertions.assertThat(prova.get()).isNotNull();
        Assertions.assertThat(proveCE.size()).isEqualTo(savedCE.size());
        Assertions.assertThat(proveCE.get(0).getRedditoAnteImposte()).isLessThan(proveCE.get(1).getRedditoAnteImposte());
        Assertions.assertThat(proveCE.get(1).getRedditoNetto()).isLessThan(proveCE.get(0).getRedditoNetto());
        Assertions.assertThat(proveCE.get(0).getRedditoOperativo()).isEqualTo(proveCE.get(1).getRedditoOperativo());

    }
}
