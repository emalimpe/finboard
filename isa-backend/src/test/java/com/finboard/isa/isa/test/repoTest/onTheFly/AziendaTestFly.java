package com.finboard.isa.isa.test.repoTest.onTheFly;

import com.finboard.isa.isa.model.Azienda;
import com.finboard.isa.isa.repo.AziendaRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class AziendaTestFly {

    @Autowired
    AziendaRepository ar;

    @Test
    public void insertAzienda(){
        //arrange
        Azienda a = new Azienda();
        a.setId(10L);
        a.setIndirizzo("via volante 13");
        a.setDipendenti(240940);
        a.setCodice_ateco(13453);
        a.setNome("fly company");
        a.setSettore("areonautica");

        //act
        this.ar.save(a);
        Optional<Azienda> prova = this.ar.findByNome(a.getNome());

        //assert
        Assertions.assertThat(prova.get()).isNotNull();
    }

    @Test
    public void insertAndRemoveAzienda(){
        //arrange
        String nomeTest = "fly company";
        Azienda a = new Azienda();
        a.setId(10L);
        a.setIndirizzo("via volante 13");
        a.setDipendenti(240940);
        a.setCodice_ateco(13453);
        a.setNome(nomeTest);
        a.setSettore("areonautica");

        //act
        this.ar.save(a);
        Optional<Azienda> prova = this.ar.findByNome(a.getNome());
        this.ar.delete(a);
        Optional<Azienda> assente = this.ar.findByNome(a.getNome());

        //assert
        Assertions.assertThat(prova.get().getNome()).isEqualTo(nomeTest);
        Assertions.assertThat(assente.isEmpty());
    }



}
