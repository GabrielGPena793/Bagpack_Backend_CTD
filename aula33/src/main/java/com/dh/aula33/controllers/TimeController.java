package com.dh.aula33.controllers;

import com.dh.aula33.model.Time;
import com.dh.aula33.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/times")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @PostMapping
    public Time saveTime(@RequestBody Time time){
        return timeService.post(time);
    }

    @GetMapping
    public ResponseEntity<List<Time>> findAll(){
        return ResponseEntity.ok().body(timeService.findAll());
    }

    @GetMapping("/{id}")
    public Time findByid(@PathVariable Long id){
        return timeService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable  Long id){

        if (timeService.findById(id) != null){
            timeService.deleteById(id);
            return ResponseEntity.ok().body("Deletado com sucesso!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping
    public Time updateTime(@RequestBody Time time){

        return timeService.updateTime(time);
    }
}
