package br.com.dh.ctd.ecommerce.service;

import br.com.dh.ctd.ecommerce.dto.CategoryDTO;
import br.com.dh.ctd.ecommerce.model.Categories;
import br.com.dh.ctd.ecommerce.repositories.CategoriesRepository;
import br.com.dh.ctd.ecommerce.service.exceptions.BDException;
import br.com.dh.ctd.ecommerce.service.exceptions.SourceNotFound;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoriesRepository categoriesRepository;


    @Transactional(readOnly = true)
    public Page<CategoryDTO> findAll(Pageable pageable) {
        return categoriesRepository.findAll(pageable).map(CategoryDTO::new);
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Integer id){
        Optional<Categories> categoryOptional = categoriesRepository.findById(id);
        Categories categories = categoryOptional.orElseThrow(() -> new SourceNotFound("Entidade não encontrada!"));
        return new CategoryDTO(categories);
    }

    @Transactional
    public CategoryDTO insert(CategoryDTO categoryDTO){
        Categories entity = new Categories();
        entity.setName(categoryDTO.getName());
        entity = categoriesRepository.save(entity);
        return new CategoryDTO(entity);
    }

    @Transactional
    public void delete(Integer id){
        try {
            categoriesRepository.deleteById(id);

        }catch (EmptyResultDataAccessException e){
            throw new SourceNotFound("Id not found: " + id);
        }
        catch (DataIntegrityViolationException e){
            throw new BDException("Integrity Violation");
        }
    }
}
