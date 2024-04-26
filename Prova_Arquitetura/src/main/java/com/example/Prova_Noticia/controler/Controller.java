package com.example.Prova_Noticia.controler;

import com.example.Prova_Noticia.service.NoticiasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @Autowired
    private NoticiasService service;

    @GetMapping("/noticia")
    public String buscarNoticia(){
        return service.buscarNoticia();
    }
}