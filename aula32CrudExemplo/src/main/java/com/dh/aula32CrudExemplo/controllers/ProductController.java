package com.dh.aula32CrudExemplo.controllers;

import com.dh.aula32CrudExemplo.model.Products;
import com.dh.aula32CrudExemplo.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private CrudService<Products> productService;

    @PostMapping
    public ResponseEntity<Products> postProduct(@RequestBody Products products){
        return ResponseEntity.ok(productService.create(products));
    }

    @GetMapping
    public ResponseEntity<List<Products>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> findById(@PathVariable Long id){
        return ResponseEntity.ok(productService.findByID(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){

        if (productService.findByID(id) != null){
            productService.deleteById(id);
            return ResponseEntity.ok("deletado com sucesso!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
