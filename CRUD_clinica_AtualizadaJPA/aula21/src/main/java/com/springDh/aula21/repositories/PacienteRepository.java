package com.springDh.aula21.repositories;

import com.springDh.aula21.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}
