package com.finboard.isa.isa.test.controllerTest;

import com.finboard.isa.isa.model.Analisi;
import com.finboard.isa.isa.model.Azienda;
import com.finboard.isa.isa.service.AnalisiService;
import com.finboard.isa.isa.service.AziendaService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AnalisiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private AnalisiService as;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MockMvc mockMvc;


    @Test
    void analisiShouldReturnAnalisi() throws Exception{
        assertThat(this.restTemplate.getForObject("http://localhost:"
                        + port
                        + "/"
                        + "analisi/" +
                        "aziendaDiProva0",
                String.class)).isNotNull();
    }

    @Test
    void shouldReturnStatoPatrimonialeObject()throws Exception{
        this.mockMvc.perform(
                        get("/analisi/settore/aziendaDiProva0/2023"))
                .andDo(print())
                .andExpect(
                        status().isOk()
                )
                .andExpect(content()
                        .string(containsString("APPROFONDIMENTI"))
                );
    }
}
