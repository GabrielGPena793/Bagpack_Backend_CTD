package com.dh.commerce.controllers;

import com.dh.commerce.dto.ProductDTO;
import com.dh.commerce.entities.Categories;
import com.dh.commerce.entities.Product;
import com.dh.commerce.services.CategoriesService;
import com.dh.commerce.services.ProductsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @Autowired
    private CategoriesService categoriesService;


    @PostMapping
    private ResponseEntity<String> post(@RequestBody ProductDTO productDTO){

        Categories categories = categoriesService.findById(productDTO.getCategory());
        Product product = new Product();

        product.setTitle(productDTO.getTitle());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setImage(productDTO.getImage());
        product.setCategory(categories);

        productsService.post(product);

        return ResponseEntity.ok().body("Produto cadastrado");

    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){

        return ResponseEntity.status(200).body(productsService.findAll());
    }
}
