package com.dh.aula33.controllers;

import com.dh.aula33.model.Jogador;
import com.dh.aula33.services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @PostMapping
    public Jogador post(@RequestBody Jogador jogador){
        return jogadorService.post(jogador);
    }
}
