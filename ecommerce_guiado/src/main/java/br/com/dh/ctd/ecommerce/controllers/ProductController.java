package br.com.dh.ctd.ecommerce.controllers;

import br.com.dh.ctd.ecommerce.dto.ProductDTO;
import br.com.dh.ctd.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAll(@RequestParam( value = "page", defaultValue = "0") Integer page,
                                                    @RequestParam(value = "size", defaultValue = "5") Integer size){

        PageRequest pageRequest = PageRequest.of(page, size);
        Page<ProductDTO> productDTOS = productService.buscarTodos(pageRequest);
        return ResponseEntity.ok(productDTOS);
    }
}
