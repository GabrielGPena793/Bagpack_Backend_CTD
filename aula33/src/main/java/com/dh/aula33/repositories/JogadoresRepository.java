package com.dh.aula33.repositories;

import com.dh.aula33.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadoresRepository extends JpaRepository<Jogador, Long> {

}
