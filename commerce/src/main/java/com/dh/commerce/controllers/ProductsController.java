package com.dh.commerce.controllers;

import com.dh.commerce.entities.Product;
import com.dh.commerce.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @PostMapping
    private ResponseEntity<String> post(@RequestBody Product product){
        productsService.post(product);

        return ResponseEntity.ok().body("Produto cadastrado");

    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){

        return ResponseEntity.status(200).body(productsService.findAll());
    }
}
