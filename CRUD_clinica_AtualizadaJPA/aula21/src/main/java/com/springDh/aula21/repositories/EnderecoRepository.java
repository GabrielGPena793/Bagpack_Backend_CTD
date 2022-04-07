package com.springDh.aula21.repositories;

import com.springDh.aula21.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
