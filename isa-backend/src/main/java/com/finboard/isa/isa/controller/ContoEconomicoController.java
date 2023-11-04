package com.finboard.isa.isa.controller;


import com.finboard.isa.isa.model.ContoEconomico;
import com.finboard.isa.isa.model.StatoPatrimoniale;
import com.finboard.isa.isa.service.ContoEconomicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContoEconomicoController {
    @Autowired
    private ContoEconomicoService ces;

    @CrossOrigin
    @GetMapping("/contoeconomico")
    public List<ContoEconomico> getAll(){
        return this.ces.findContiEconomici();
    }

    @CrossOrigin
    @GetMapping("/contoeconomico/today")
    public List<ContoEconomico> getActive(){return this.ces.contiEconomiciAnnuali();}

    @CrossOrigin
    @GetMapping("/contoeconomico/dieci/{nome}")
    public List<ContoEconomico> getDieci(@PathVariable("nome") String nome){return this.ces.contiEconomiciDieciAnni(nome);}
    /*
    @GetMapping("/contoeconomico/azienda/{id}")
    public List<ContoEconomico> getById(@PathVariable("id") Long id){
        return this.ces.findByIdAzienda(id);
    }
    */

    @CrossOrigin
    @GetMapping("/contoeconomico/today/{nome}")
    public ContoEconomico getToday(@PathVariable("nome")String nome){return this.ces.contoEconomicoAnnoCorrente(nome);}
//    @CrossOrigin
//    @DeleteMapping("/contoeconomico")
//    public void deleteAll(){
//        this.ces.deleteContoEconomico();
//    }

    @CrossOrigin
    @DeleteMapping("/contoeconomico/{nome}/{anno}")
    public void deleteContoEconomico(@PathVariable("nome")String nome,@PathVariable("anno")String anno){
        ContoEconomico sp = this.ces.findByNomeAziendaAndAnno(nome,anno);
        this.ces.deleteById(sp.getId());
    }

}
