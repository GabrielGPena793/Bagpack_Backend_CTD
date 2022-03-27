package com.dh.aula31Conclusao.controllers;

import com.dh.aula31Conclusao.entitites.Mascote;
import com.dh.aula31Conclusao.services.IMascoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mascote")
public class MascoteController {

    @Autowired
    private IMascoteService<Mascote> mascoteService;

    @PostMapping
    public ResponseEntity<String> post(@RequestBody Mascote mascote){

        mascoteService.insert(mascote);

        return ResponseEntity.ok().body("success");
    }
}
