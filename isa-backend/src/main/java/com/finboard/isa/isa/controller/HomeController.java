package com.finboard.isa.isa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    EntityManager entityManager;
    @CrossOrigin
    @GetMapping("/accesso")
    public String login(Model model){
        return "grafica1/index";
    }


}
