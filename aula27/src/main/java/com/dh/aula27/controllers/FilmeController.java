package com.dh.aula27.controllers;

import com.dh.aula27.dto.FilmeDTO;
import com.dh.aula27.entities.Filme;
import com.dh.aula27.services.FilmeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping
    public ResponseEntity<List<FilmeDTO>> findAll(){
        List<FilmeDTO> filmeDTOS = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        filmeService.findAll().forEach(filme -> filmeDTOS.add(mapper.convertValue(filme, FilmeDTO.class)));

        return  ResponseEntity.ok()
                .header("Lista com todos Filmes")
                .body(filmeDTOS);
    }

    @PostMapping
    public ResponseEntity<String> post(@RequestBody Filme filme){
        filmeService.insert(filme);

        return ResponseEntity.status(200).body("cadastrado!");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id){

        if (filmeService.findAll().stream().anyMatch(filme -> filme.getId().equals(id))){
            filmeService.delete(id);
            return ResponseEntity.status(200).body("Deletado com sucesso!");
        }

        return ResponseEntity.status(404).body("não achou");

    }

}
