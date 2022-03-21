package com.example.aula25conclusao.controller;

import com.example.aula25conclusao.services.IDataNascimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DataNascimentoController {

    private final IDataNascimentoService dataNascimentoService;

    @Autowired
    public DataNascimentoController(IDataNascimentoService dataNascimentoService) {
        this.dataNascimentoService = dataNascimentoService;
    }

    @GetMapping("{dia}/{mes}/{ano}")
    public Integer idade(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer ano){

        return dataNascimentoService.calcularIdade(dia, mes ,ano);
    };

}
