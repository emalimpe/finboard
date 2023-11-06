package com.finboard.isa.isa.model.funzioniDiAnalisi;

import java.util.HashMap;

/**mock class which implements the SelezioneInterface interface*/
public class SelezioneApprofondimentiSemplice {
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

    /**
     * interface which specifies the required type to be analyzed (the parameter)
     * and the required return type*/
}
