package com.finboard.isa.isa.service;


import com.finboard.isa.isa.model.Azienda;
import com.finboard.isa.isa.model.ContoEconomico;
import com.finboard.isa.isa.model.StatoPatrimoniale;
import com.finboard.isa.isa.repo.AziendaRepository;
import com.finboard.isa.isa.repo.ContoEconomicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ContoEconomicoService {
    @Autowired
    private ContoEconomicoRepository cer;

    @Autowired
    private AziendaRepository ar;

    public List<ContoEconomico> findContiEconomici(){
        List<ContoEconomico> toRet = this.cer.findAll();
        return toRet;
    }

   /* public List<ContoEconomico> findContiEconomiciByIdAzienda(Azienda a){
        return this.cer.findByIdAzienda(a);
    }*/

    public void deleteContoEconomico(){
        this.cer.deleteAll();
    }

    public List<ContoEconomico> contiEconomiciAnnuali(){
        return this.cer.contiAnnuali();
    }

    public List<ContoEconomico> contiEconomiciDieciAnni(String nome){
        List<ContoEconomico> lce = this.cer.contiDieciAnni();
        return lce.stream()
                .filter(x -> x.getIdAzienda().getNome().equals(nome))
                .collect(Collectors.toList());

       /* List<ContoEconomico> toRet = new ArrayList<>();
        for(ContoEconomico ce: lce){
            if(ce.getIdAzienda().getNome().equals(nome)){
                toRet.add(ce);
            }
        }
        return toRet;*/
    }

    public ContoEconomico contoEconomicoAnnoCorrente(String nome){
        List<ContoEconomico> lce = this.cer.contiAnnuali();
        return lce.stream()
                .filter(x -> x.getIdAzienda().getNome().equals(nome))
                .collect(Collectors.toList())
                .get(0);
    }

    public List<ContoEconomico> findByIdAzienda(Azienda a){
        return this.cer.findByIdAzienda(a);
    }

    public void deleteById(Long a){
        this.cer.deleteById(a);
    }

    public ContoEconomico findByNomeAziendaAndAnno(String nome, String anno){
        Azienda a =  this.ar.findByNome(nome).get();
        List<ContoEconomico> lsp = this.cer.findByIdAzienda(a);
        for(ContoEconomico curr: lsp){
            String year = new SimpleDateFormat("yyyy").format(curr.getStilatura());
            if(year.equals(anno)){
                return curr;
            }
        }
        return null;
    }
}
