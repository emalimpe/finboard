package com.finboard.isa.isa.model.funzioniDiAnalisi;

import java.util.HashMap;

/**
 * interface which specifies the required type to be analyzed (the parameter)
 * and the required return type*/
public interface SelezioneInterface {

    public HashMap<String,Float> selezione(HashMap<String, HashMap<String, Float>> risultati);
}
