package com.finboard.isa.isa.test.controllerTest;

import com.finboard.isa.isa.controller.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ControllerCreationTest {

    @Autowired
    private HomeController hc;
    @Autowired
    private AziendeController ac;
    @Autowired
    private AnalisiController analisiC;
    @Autowired
    private StatoPatrimonialeController spc;
    @Autowired
    private ContoEconomicoController cec;

    @Test
    void homeContextCreation(){
        Assertions.assertThat(hc).isNotNull();
    }
    @Test
    void statoPatrimonialeContextCreation(){
        Assertions.assertThat(spc).isNotNull();
    }
    @Test
    void contoEconomicoContextCreation(){
        Assertions.assertThat(cec).isNotNull();
    }
    @Test
    void aziendaContextCreation(){
        Assertions.assertThat(ac).isNotNull();
    }
    @Test
    void analisiContextCreation() {
        Assertions.assertThat(analisiC).isNotNull();
    }

}
