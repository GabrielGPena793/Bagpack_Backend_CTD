package com.springDh.aula21.controllers;

import com.springDh.aula21.model.Paciente;
import com.springDh.aula21.services.EnderecoService;
import com.springDh.aula21.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Paciente> salvar(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.salvar(paciente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Integer id){
        return  ResponseEntity.ok(pacienteService.buscarPorId(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> buscarTodos(){
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }

    @PutMapping
    public ResponseEntity<Paciente> atualizar(@RequestBody Paciente paciente){

        if (paciente.getId() != null && pacienteService.buscarPorId(paciente.getId()) != null){
            return ResponseEntity.ok(pacienteService.atualizar(paciente));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirPorId(@PathVariable Integer id){

        if ( pacienteService.buscarPorId(id).isPresent()){
            pacienteService.excluir(id);
            return ResponseEntity.status(200).body("deletatado com sucesso");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }
}
