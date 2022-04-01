package com.dh.aula32CrudExemplo.repositories;

import com.dh.aula32CrudExemplo.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {
}
