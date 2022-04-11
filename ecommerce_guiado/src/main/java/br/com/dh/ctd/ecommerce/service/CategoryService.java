package br.com.dh.ctd.ecommerce.service;

import br.com.dh.ctd.ecommerce.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoriesRepository categoriesRepository;


}
