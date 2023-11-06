package com.finboard.isa.isa.model.funzioniDiAnalisi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**mock class which implements the SelezioneInterface interface*/
public class SelezioneApprofondimentiSemplice implements SelezioneInterface{
    public HashMap<String,Float> selezione(HashMap<String, HashMap<String, Float>> risultati){
        HashMap<String, Float> toRet = new HashMap<>();
        for(String area: risultati.keySet()){
            HashMap<String,Float> item = risultati.get(area);
            float biggest = 0;
            String indicazioni = "";
            for(String campo: item.keySet()){
                if(item.get(campo) > biggest){
                    biggest = item.get(campo);
                    indicazioni = campo;
                }
            }
            toRet.put("approfondimentoaArea_"+area+"_campo_"+indicazioni,biggest);
        }

        return toRet;
    }
}
