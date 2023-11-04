package com.finboard.isa.isa.service;


import com.finboard.isa.isa.model.Azienda;
import com.finboard.isa.isa.model.ContoEconomico;
import com.finboard.isa.isa.model.StatoPatrimoniale;
import com.finboard.isa.isa.repo.AziendaRepository;
import com.finboard.isa.isa.repo.StatoPatrimonialeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StatoPatrimonialeService {

    @Autowired
    private StatoPatrimonialeRepository spr;

    @Autowired
    private AziendaRepository ar;

    public List<StatoPatrimoniale> findAllStatiPatrimoniali(){
        List<StatoPatrimoniale> toRet = this.spr.findAll();
        return toRet;
    }

    /*public List<StatoPatrimoniale> findStatiPatrimonialiByIdAzienda(Azienda a){
        return this.spr.findByIdAzienda(a);
    }*/

    public void deleteStatiPatrimoniali(){
        this.spr.deleteAll();
    }

    public List<StatoPatrimoniale> statiPatrimonialiAnnuali(){
        return this.spr.statiPatrimonialiAnnuali();
    }

    public List<StatoPatrimoniale> statiPatrimonialiDieciAnni(String nome) {
        List<StatoPatrimoniale> lsp = this.spr.statiPatrimonialiDieciAnni();
        return lsp.stream().filter(x -> x.getIdAzienda().getNome().equals(nome)).collect(Collectors.toList());
    }

    public StatoPatrimoniale statoPatrimonialeAnnoCorrente(String nome){
        List<StatoPatrimoniale> lsp = this.spr.statiPatrimonialiAnnuali();
        return lsp.stream()
                .filter(x->x.getIdAzienda().getNome().equals(nome))
                .collect(Collectors.toList())
                .get(0);
    }

    public List<StatoPatrimoniale> findByIdAzienda(Azienda a){
        return this.spr.findByIdAzienda(a);
    }

    public void deleteById(Long a){
        this.spr.deleteById(a);
    }

    public StatoPatrimoniale findByNomeAziendaAndAnno(String nome, String anno){
        Azienda a =  this.ar.findByNome(nome).get();
        List<StatoPatrimoniale> lsp = this.spr.findByIdAzienda(a);
        for(StatoPatrimoniale curr: lsp){
            String year = new SimpleDateFormat("yyyy").format(curr.getStilatura());
            if(year.equals(anno)){
                return curr;
            }
        }
        return null;
    }
}
