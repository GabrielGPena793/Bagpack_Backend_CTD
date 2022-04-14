package br.com.dh.ctd.ecommerce.service;

import br.com.dh.ctd.ecommerce.dto.ProductDTO;
import br.com.dh.ctd.ecommerce.model.Products;
import br.com.dh.ctd.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public Page<ProductDTO> buscarTodos(PageRequest pageRequest){

        Page<Products> result = productRepository.findAll(pageRequest);
        Page<ProductDTO> page = result.map(ProductDTO::new);
        return page;

    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Integer id){
        Optional<Products> products = productRepository.findById(id);
        return new ProductDTO(products.get());
    }

}
