package com.finboard.isa.isa.controller;

import com.finboard.isa.isa.model.Analisi;
import com.finboard.isa.isa.model.Azienda;
import com.finboard.isa.isa.service.AnalisiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**REST controller
 * which handles the analisi requests
 * */
@RestController
public class AnalisiController {
    @Autowired
    AnalisiService as;

    @CrossOrigin
    @GetMapping(value="/analisi/{azienda}/{anno}")
    public Analisi getAnalisi(@PathVariable("azienda") String a, @PathVariable("anno") String anno){
        return this.as.getAnalisiAnnoAzienda(a, anno);
    }


    @CrossOrigin
    @GetMapping(value="/analisi/{azienda}")
    public List<Analisi> getAnalisiAzienda(@PathVariable("azienda") String a){

        //equivalente alla query SQL :
        //
        // SELECT *
        // FROM
        //      stato_patrimoniale AS sp
        //      JOIN
        //      aziende AS a
        //          ON a.id = sp.id
        //      JOIN
        //      conto_economico AS ce
        //          ON a.id = ce.id
        // WHERE
        //       a.nome={azienda}
        //       AND
        //       YEAR(sp.stilatura) = YEAR(ce.stilatura)
        //       AND YEAR(sp.stilatura) > YEAR(CURDATE()) - 10;

        return this.as.getAnalisiAzienda(a);
    }

    @CrossOrigin
    @GetMapping(value="/analisi/settore/{nome}/{anno}")
    public List<Analisi> getAnalisiAnno(@PathVariable("anno") String anno, @PathVariable("nome") String nome){
        return this.as.getAnalisiAnnoSettore(anno, nome);
    }
}
