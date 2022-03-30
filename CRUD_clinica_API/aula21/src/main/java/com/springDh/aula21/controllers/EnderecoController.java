package com.springDh.aula21.controllers;

import com.springDh.aula21.dao.impl.EnderecoDaoMySql;
import com.springDh.aula21.model.Endereco;
import com.springDh.aula21.services.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController() {
        this.enderecoService = new EnderecoService(new EnderecoDaoMySql());
    }

    @PostMapping
    public ResponseEntity<Endereco> salvar(@RequestBody Endereco endereco){
        return ResponseEntity.ok(enderecoService.salvar(endereco));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(enderecoService.buscar(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> buscarTodos(){
        return ResponseEntity.ok(enderecoService.buscarTodos());
    }

    @PutMapping
    public ResponseEntity<Endereco> atualizar(@RequestBody Endereco endereco){

        if (endereco.getId() != null && enderecoService.buscar(endereco.getId()).isPresent()){
            return ResponseEntity.ok(enderecoService.atualizar(endereco));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id){

        if (enderecoService.buscar(id).isPresent()){
            enderecoService.excluir(id);
            return ResponseEntity.ok("Excluido com sucesso");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }
}
