package com.dh.aula31Conclusao.repositories;

import com.dh.aula31Conclusao.entitites.Mascote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascoteRepository extends JpaRepository<Mascote, Long> {

}
