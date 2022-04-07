package com.springDh.aula21.controllers;

import com.springDh.aula21.model.Consultas;
import com.springDh.aula21.services.ConsultasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
public class ConsultasController {

    @Autowired
    private ConsultasService consultasService;

    @PostMapping
    public ResponseEntity<Consultas> salvar(@RequestBody Consultas consultas){

        return ResponseEntity.ok(consultasService.salvar(consultas));
    }

}
