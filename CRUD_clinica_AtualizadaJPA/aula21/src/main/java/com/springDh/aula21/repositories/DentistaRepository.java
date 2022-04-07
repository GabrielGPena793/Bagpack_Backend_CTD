package com.springDh.aula21.repositories;

import com.springDh.aula21.model.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistaRepository extends JpaRepository<Dentista, Integer> {
}
