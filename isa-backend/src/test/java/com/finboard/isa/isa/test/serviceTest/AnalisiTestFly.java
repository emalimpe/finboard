package com.finboard.isa.isa.test.serviceTest;

import com.finboard.isa.isa.model.Analisi;
import com.finboard.isa.isa.model.Azienda;
import com.finboard.isa.isa.model.ContoEconomico;
import com.finboard.isa.isa.model.StatoPatrimoniale;
import com.finboard.isa.isa.repo.AziendaRepository;
import com.finboard.isa.isa.repo.ContoEconomicoRepository;
import com.finboard.isa.isa.repo.StatoPatrimonialeRepository;
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
public class AnalisiTestFly {
    @Autowired
    AziendaRepository ar;
    @Autowired
    ContoEconomicoRepository cer;
    @Autowired
    StatoPatrimonialeRepository spr;

    @Test
    public void insertAllThenCalculate(){
        //arrange
        Azienda a = new Azienda();
        a.setId(10L);
        a.setIndirizzo("via volante 13");
        a.setDipendenti(240940);
        a.setCodice_ateco(13453);
        a.setNome("fly company");
        a.setSettore("areonautica");
        List<ContoEconomico> savedCE = new ArrayList<>();
        List<StatoPatrimoniale> savedSP = new ArrayList<>();



        //act
        this.ar.save(a);
        Optional<Azienda> prova = this.ar.findByNome(a.getNome());

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

        Analisi analisi = new Analisi(a);
        analisi.setSp(proveSP.get(0));
        analisi.setCe(proveCE.get(0));
        System.out.println(analisi.toString());



        //assert
        Assertions.assertThat(proveSP.size()).isEqualTo(savedSP.size());
        Assertions.assertThat(proveCE.size()).isEqualTo(savedCE.size());
        System.out.println(analisi.getAnalisi());
        Assertions.assertThat(analisi.getAnalisi()).isNotNull();
        Assertions.assertThat(analisi.getAnalisi().get("tesoreria")).isNotNull();
        Assertions.assertThat(analisi.getAnalisi().get("rigiditaRotazioni")).isNotNull();
        Assertions.assertThat(analisi.getAnalisi().get("struttura")).isNotNull();
        Assertions.assertThat(analisi.getAnalisi().get("solidita")).isNotNull();
        Assertions.assertThat(analisi.getAnalisi().get("APPROFONDIMENTI")).isNotNull();

    }
}
