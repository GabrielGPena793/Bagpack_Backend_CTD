package com.dh.aula33.controllers;

import com.dh.aula33.dto.JogadorDTO;
import com.dh.aula33.model.Jogador;
import com.dh.aula33.services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @PostMapping
    public Jogador saveJogador(@RequestBody JogadorDTO jogadorDTO){
        return jogadorService.saveJogador(jogadorDTO);
    }

    @GetMapping
    public ResponseEntity<List<Jogador>> findAll(){

        return ResponseEntity.ok().body(jogadorService.findAll());
    }

    @GetMapping("/{id}")
    public Jogador findByid(@PathVariable Long id){
        return jogadorService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){

        if (jogadorService.findById(id) != null){
            jogadorService.deleteById(id);
            return ResponseEntity.ok().body("Deletado com sucesso!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping
    public ResponseEntity<Jogador> updateJogador(@RequestBody JogadorDTO jogadorDTO){

        if (jogadorService.findById(jogadorDTO.getId()) != null){
            return ResponseEntity.ok(jogadorService.updateJogador(jogadorDTO));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
