package com.finboard.isa.isa.service;


import com.finboard.isa.isa.model.Azienda;
import com.finboard.isa.isa.model.ContoEconomico;
import com.finboard.isa.isa.model.StatoPatrimoniale;
import com.finboard.isa.isa.repo.AziendaRepository;
import com.finboard.isa.isa.repo.ContoEconomicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * service which interfaces the repository layer
 * and provides services to the AziendaController class
 */
@Service
public class AziendaService {

    @Autowired
    private AziendaRepository ar;
    @Autowired
    private ContoEconomicoService ces;
    @Autowired
    private StatoPatrimonialeService sps;

    /**
     * allows to find all the aziende records*/
    public List<Azienda> findAziende(){
        List<Azienda> resp = this.ar.findAll();
        return resp;
    }

    /**
     * allows to delete all the aziende records*/
    public void deleteAllAziende(){
        this.ar.deleteAll();
    }

    /*
     * allows to find the aziende record
     * which match the string name provided as parameter*/
    public Azienda findAziendaByNome(String nome){
        Optional<Azienda> resp = this.ar.findByNome(nome);
        return resp.get();
    }

    /**
     * allows to find all the aziende records
     * which match the settore field of the azienda record
     * matching the provided name*/
    public List<Azienda> findAziendaByNomeSettoreLimited(String nome){
        List<Azienda> la = this.ar.findAll();
        Azienda curr = la.stream()
                .filter(x -> x.getNome().equals(nome))
                .collect(Collectors.toList())
                .get(0);
        return la.stream()
                .filter(x -> x.getSettore()
                        .equals(curr.getSettore()))
                        .collect(Collectors.toList());
    }

    /**
     * allows to delete the aziende record
     * which match the string name provided as parameter*/
    public void deleteAziendaByNome(String nome){
        Azienda a = findAziendaByNome(nome);
        /*System.out.println(a);*/
        List<ContoEconomico> lce = this.ces.findByIdAzienda(a);
        List<StatoPatrimoniale> lsp = this.sps.findByIdAzienda(a);
        lce.stream().forEach(x -> System.out.println(x));
        lsp.stream().forEach(x -> System.out.println(x));
        lce.stream().forEach(x -> this.ces.deleteById(x.getId()));
        lsp.stream().forEach(x -> this.sps.deleteById(x.getId()));
        this.ar.deleteById(a.getId());
    }
}
