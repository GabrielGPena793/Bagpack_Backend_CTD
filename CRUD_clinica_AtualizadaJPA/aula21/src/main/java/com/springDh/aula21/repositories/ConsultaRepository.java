package com.springDh.aula21.repositories;

import com.springDh.aula21.model.Consultas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consultas, Integer> {
}
