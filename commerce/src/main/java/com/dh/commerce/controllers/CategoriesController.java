package com.dh.commerce.controllers;

import com.dh.commerce.entities.Categories;
import com.dh.commerce.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    @PostMapping
    private ResponseEntity<String> post(@RequestBody Categories categories){
        categoriesService.post(categories);

        return ResponseEntity.ok().body("Produto cadastrado");

    }

    @GetMapping
    public ResponseEntity<List<Categories>> findAll(){

        List<Categories> categories = categoriesService.findAll();
        return ResponseEntity.ok().body(categories);
    }
}
