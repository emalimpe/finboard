package com.finboard.isa.isa.service;

import com.finboard.isa.isa.model.Analisi;
import com.finboard.isa.isa.model.Azienda;
import com.finboard.isa.isa.model.ContoEconomico;
import com.finboard.isa.isa.model.StatoPatrimoniale;
import com.finboard.isa.isa.repo.ContoEconomicoRepository;
import com.finboard.isa.isa.repo.StatoPatrimonialeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

/**
 * service which interfaces the repository layer
 * and provides services to the AnalisiController class
 */
@Service
public class AnalisiService {
    @Autowired
    AziendaService as;
    @Autowired
    ContoEconomicoService ces;
    @Autowired
    StatoPatrimonialeService sps;


    /** function to create an analisi instance related to
     * a specific azienda instance/record and a specific year
     * (both azienda's name and year need to be specified in the url
     * of the controller)
     */
    /* funzione per il recupero di un'unica analisi in relazione
     * ad una specifica azienda e specifico anno (entrambi specificati
     * nell'url)
     */
    public Analisi getAnalisiAnnoAzienda(String a, String anno){
        List<StatoPatrimoniale> sp = this.sps.findAllStatiPatrimoniali();
        List<ContoEconomico> ce = this.ces.findContiEconomici();
        Azienda azienda = this.as.findAziendaByNome(a);

        StatoPatrimoniale toUseSP = null;
        ContoEconomico toUseCE = null;
        Analisi toRet = new Analisi(azienda);

        String year;
        for(StatoPatrimoniale curr : sp){
            if(curr.getIdAzienda().equals(azienda)){
                //toRet.setProvaAnnoSP(new SimpleDateFormat("yyyy").format(curr.getStilatura()).equals(anno));
                year = new SimpleDateFormat("yyyy").format(curr.getStilatura());
                if(year.equals(anno)) {
                    toRet.setSp(curr);
                    break;
                }
            }
        }
        for(ContoEconomico curr : ce){
            if(curr.getIdAzienda().equals(azienda)){
                //toRet.setProvaAnnoCE(new SimpleDateFormat("yyyy").format(curr.getStilatura()).equals(anno));
                year = new SimpleDateFormat("yyyy").format(curr.getStilatura());
                if(year.equals(anno)){
                    toRet.setCe(curr);
                    break;
                }
            }
        }
        return  toRet;
    }

    /**
     * function to create all the analisis (almost 10)
     * related to a specific azienda record, whose name
     * is specified in the url passed to the controller
     * */
    /* funzione per il recupero di tutte le analisi (max 10) di un'azienda
    *  specificata nell'URL
    */
    public List<Analisi> getAnalisiAzienda(String a){
        Azienda az = this.as.findAziendaByNome(a);
        List<ContoEconomico> lce = this.ces.contiEconomiciDieciAnni(a);
        List<StatoPatrimoniale> lsp = this.sps.statiPatrimonialiDieciAnni(a);
        List<Analisi> la = new ArrayList<>();
        for(StatoPatrimoniale sp: lsp){
            for(ContoEconomico ce: lce){
                if(!(ce.getStilatura().getYear() == sp.getStilatura().getYear())) {
                    continue;
                }
                Analisi toAdd = new Analisi(az);
                toAdd.setCe(ce);
                toAdd.setSp(sp);
                la.add(toAdd);
                break;
            }
        }
        return la;
    }

    /**
     * function to create the analysis related to all the aziendas
     * which belong to the same sector (settore field in the Azienda class)
     * of the azienda's nome URL specified and related to a specific year
     * */
    /*
    * funzione per il recupero di tutte le analisi di quelle aziende appartenenti
    * allo stesso settore dell'azienda specificata nell'URL, rispetto ad uno
    * specifico anno*/
    public List<Analisi> getAnalisiAnnoSettore(String anno, String nome){
        Azienda azienda = this.as.findAziendaByNome(nome);

        List<StatoPatrimoniale> lsp = this.sps.findAllStatiPatrimoniali();
        List<ContoEconomico> lce = this.ces.findContiEconomici();
        List<Analisi> la = new ArrayList<>();
        String buffer;

        for (StatoPatrimoniale sp: lsp){
            if(!(sp.getIdAzienda().getSettore().equals(azienda.getSettore()))){
                continue;
            }
            buffer =  new SimpleDateFormat("yyyy").format(sp.getStilatura());
            if(buffer.equals(anno)) {
                for (ContoEconomico ce : lce) {
                    //if inserito per efficienza
                    if(!(ce.getIdAzienda().getSettore().equals(azienda.getSettore()))){
                        continue;
                    }
                    buffer =  new SimpleDateFormat("yyyy").format(ce.getStilatura());
                    if(buffer.equals(anno) && ce.getIdAzienda().equals(sp.getIdAzienda())) {
                        Analisi toAdd = new Analisi(ce.getIdAzienda());
                        toAdd.setSp(sp);
                        toAdd.setCe(ce);
                        la.add(toAdd);
                        break;
                    }
                }
            }
        }
        return la;
    }
}
