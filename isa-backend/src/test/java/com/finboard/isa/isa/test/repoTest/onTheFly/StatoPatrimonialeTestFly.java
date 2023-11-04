package com.finboard.isa.isa.test.repoTest.onTheFly;

import com.finboard.isa.isa.model.Azienda;
import com.finboard.isa.isa.model.ContoEconomico;
import com.finboard.isa.isa.model.StatoPatrimoniale;
import com.finboard.isa.isa.repo.AziendaRepository;
import com.finboard.isa.isa.repo.ContoEconomicoRepository;
import com.finboard.isa.isa.repo.StatoPatrimonialeRepository;
import com.finboard.isa.isa.service.StatoPatrimonialeService;
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
public class StatoPatrimonialeTestFly {

    @Autowired
    StatoPatrimonialeRepository spr;
    @Autowired
    AziendaRepository ar;

    @Test
    public void insertAziendaAndStatoPatrimoniale(){
        //arrange
        List<StatoPatrimoniale> savedSP = new ArrayList<>();

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
            StatoPatrimoniale sp = new StatoPatrimoniale();
            LocalDate myObj = LocalDate.now().minusYears(i); // Create a date object
            Date data = Date.valueOf(myObj); // Create a date object
            sp.setStilatura(data);

            sp.setIdAzienda(a);
            sp.setImmobilizzazioniImmateriali((i+1)*13084*a.getId());
            sp.setImmobilizzazioniFinanziarie((i+19)*(i+11)*(i+11)*a.getId());
            sp.setImmobilizzazioniMateriali((i+1)*13084*a.getId()*(i+11)*a.getId());
            sp.setRimanenzeMagazzino((a.getId()+i)*(a.getId()+i));
            sp.setLiquiditaDifferite((i+1)*13084);
            sp.setLiquiditaImmediate(a.getId()*a.getId()*a.getId()*(i+1)*(i+1)*(i+1));
            sp.setCapitaleSociale(110243520/123*(i+1)*(i+1)*(i+1));
            sp.setRiservaLegale(110243520/123);
            sp.setRiservaStraordinaria(110243520/123);
            sp.setRiservaPartecipazioni(110243520/1323*(i+1));
            sp.setTfrConsolidato(110243520/123);
            sp.setTfrCorrente(3102430/143);
            sp.setDebitiBancheConsolidati(1102433550/11);
            sp.setDebitiBancheCorrenti(11024352/(12*i+1));
            sp.setDebitiFornitoriConsolidati((i+1)*13084*a.getId());
            sp.setDebitiFornitoriCorrenti((i+14)*13084);
            sp.setDebitiTributariConsolidati(104229);
            sp.setDebitiTributariCorrenti(20402);
            sp.setDebitiTitoliAzionari(2482242);
            sp.setDebitiAzionisti(244239*(i+11));
            savedSP.add(this.spr.save(sp));
        }
        List<StatoPatrimoniale> proveSP = (List<StatoPatrimoniale>) this.spr.findAll();

        //assert
        Assertions.assertThat(prova.get()).isNotNull();
        Assertions.assertThat(proveSP.size()).isEqualTo(savedSP.size());
        Assertions.assertThat(proveSP.get(0).getDebitiAzionisti()).isLessThan(proveSP.get(1).getDebitiAzionisti());
        Assertions.assertThat(proveSP.get(1).getDebitiBancheCorrenti()).isLessThan(proveSP.get(0).getDebitiBancheCorrenti());
        Assertions.assertThat(proveSP.get(0).getDebitiTitoliAzionari()).isEqualTo(proveSP.get(1).getDebitiTitoliAzionari());
    }
}
