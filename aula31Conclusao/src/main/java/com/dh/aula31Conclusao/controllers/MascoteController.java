package com.dh.aula31Conclusao.controllers;

import com.dh.aula31Conclusao.entitites.Mascote;
import com.dh.aula31Conclusao.services.IMascoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){

        if (mascoteService.findById(id) != null){
            mascoteService.delete(id);
            return ResponseEntity.status(200).body("Deleted success");

        }

        return ResponseEntity.badRequest().body("Id Not found");

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Mascote> findById(@PathVariable Long id){

        if (mascoteService.findById(id) != null){

            Mascote mascote = mascoteService.findById(id);

            return ResponseEntity.status(200).body(mascote);
        }

        return ResponseEntity.status(404).body(null);
    }
}
