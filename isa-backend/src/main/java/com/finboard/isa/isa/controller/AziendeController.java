package com.finboard.isa.isa.controller;

import com.finboard.isa.isa.model.Azienda;
import com.finboard.isa.isa.service.AziendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
public class AziendeController {
    @Autowired
    private AziendaService as;
    @CrossOrigin
    @GetMapping("/aziende")
    public List<Azienda> getAziende(){
        return as.findAziende();
    }
    @CrossOrigin
    @GetMapping("/aziende/{nome}")
    public Azienda getByNome(@PathVariable("nome") String nome){
        Azienda a = this.as.findAziendaByNome(nome);
        return a;
    }

    @CrossOrigin
    @GetMapping("/aziende/delete/{nome}")
    public void deleteGetByNome(@PathVariable("nome") String nome){
        this.as.deleteAziendaByNome(nome);
    }

    @CrossOrigin
    @GetMapping("/aziende/settore/{nome}")
    public List<Azienda> getByNomeAndSettoreLimited(@PathVariable("nome") String nome){
        return this.as.findAziendaByNomeSettoreLimited(nome);
    }


//    @CrossOrigin
//    @DeleteMapping("/aziende")
//    public void deleteAziende(){
//        as.deleteAllAziende();
//    }
    @CrossOrigin
    @DeleteMapping("/aziende/{nome}")
    public void deleteByNome(@PathVariable("nome") String nome){
        this.as.deleteAziendaByNome(nome);
    }

}
