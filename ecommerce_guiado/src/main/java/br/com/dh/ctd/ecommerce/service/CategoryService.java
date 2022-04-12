package br.com.dh.ctd.ecommerce.service;

import br.com.dh.ctd.ecommerce.dto.CategoryDTO;
import br.com.dh.ctd.ecommerce.dto.ProductDTO;
import br.com.dh.ctd.ecommerce.model.Categories;
import br.com.dh.ctd.ecommerce.repositories.CategoriesRepository;
import br.com.dh.ctd.ecommerce.service.exceptions.EntitieNotFound;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoriesRepository categoriesRepository;


    public Page<CategoryDTO> findAll(Pageable pageable) {
        return categoriesRepository.findAll(pageable).map(CategoryDTO::new);
    }

    @Transactional
    public CategoryDTO findById(Integer id){
        Optional<Categories> categoryOptional = categoriesRepository.findById(id);
        Categories categories = categoryOptional.orElseThrow(() -> new EntitieNotFound("Entidade não encontrada!"));
        return new CategoryDTO(categories);
    }
}
