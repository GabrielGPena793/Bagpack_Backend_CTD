package com.dh.aula33.services;

import com.dh.aula33.model.Jogador;
import com.dh.aula33.repositories.JogadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JogadorService {

    @Autowired
    private JogadoresRepository jogadoresRepository;

   public Jogador post(Jogador jogador){
       return jogadoresRepository.save(jogador);
   }


}
