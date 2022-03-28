package com.springDh.aula21.controllers;

import com.springDh.aula21.dao.impl.UsuarioDaoMySql;
import com.springDh.aula21.model.Usuario;
import com.springDh.aula21.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UserController {


    private UsuarioService usuarioService;

    public UserController() {
        this.usuarioService = new UsuarioService(new UsuarioDaoMySql());
    }

    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){

        return ResponseEntity.ok(usuarioService.salvar(usuario));
    }

}
