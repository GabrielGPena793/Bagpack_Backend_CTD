package com.dh.aula32CrudExemplo.services.impl;

import com.dh.aula32CrudExemplo.model.Products;
import com.dh.aula32CrudExemplo.repositories.ProductRepository;
import com.dh.aula32CrudExemplo.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements CrudService<Products> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Products> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Products findByID(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Products create(Products products){
        return productRepository.save(products);
    }

    @Override
    public Products update(Products products) {
        return null;
    }
}
