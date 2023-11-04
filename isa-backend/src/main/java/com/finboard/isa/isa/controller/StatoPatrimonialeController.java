package com.finboard.isa.isa.controller;


import com.finboard.isa.isa.model.ContoEconomico;
import com.finboard.isa.isa.model.StatoPatrimoniale;
import com.finboard.isa.isa.service.StatoPatrimonialeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StatoPatrimonialeController {

    @Autowired
    private StatoPatrimonialeService sps;

    @CrossOrigin
    @GetMapping("/statopatrimoniale")
    public List<StatoPatrimoniale> findAllStatiPatrimoniali(){
        return this.sps.findAllStatiPatrimoniali();
    }

    @CrossOrigin
    @GetMapping("/statopatrimoniale/today")
    public List<StatoPatrimoniale> getActive(){return this.sps.statiPatrimonialiAnnuali();}

    @CrossOrigin
    @GetMapping("/statopatrimoniale/dieci/{nome}")
    public List<StatoPatrimoniale> getDieci(@PathVariable("nome") String nome){return this.sps.statiPatrimonialiDieciAnni(nome);}

    @CrossOrigin
    @GetMapping("/statopatrimoniale/today/{nome}")
    public StatoPatrimoniale getToday(@PathVariable("nome") String nome){return this.sps.statoPatrimonialeAnnoCorrente(nome);}

    @CrossOrigin
    @DeleteMapping("/statopatrimoniale")
    public void deleteAllStatiPatrimoniali(){
        this.sps.deleteStatiPatrimoniali();
    }

    @CrossOrigin
    @DeleteMapping("/statopatrimoniale/{nome}/{anno}")
    public void deleteStatoPatrimoniale(@PathVariable("nome")String nome,@PathVariable("anno")String anno){
        StatoPatrimoniale sp = this.sps.findByNomeAziendaAndAnno(nome,anno);
        this.sps.deleteById(sp.getId());
    }


}
