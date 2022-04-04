package com.dh.aula33.services;

import com.dh.aula33.dto.JogadorDTO;
import com.dh.aula33.model.Jogador;
import com.dh.aula33.model.Time;
import com.dh.aula33.repositories.JogadoresRepository;
import com.dh.aula33.repositories.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class JogadorService {

    @Autowired
    private JogadoresRepository jogadoresRepository;

    @Autowired
    private TimeService timeRepository;

   public Jogador saveJogador(JogadorDTO jogadorDTO){

       Jogador jogador = new Jogador();
       jogador.setNome(jogadorDTO.getNome());
       jogador.setAltura(jogadorDTO.getAltura());
       jogador.setPeso(jogadorDTO.getPeso());
       jogador.setPosicao(jogadorDTO.getPosicao());
       jogador.setTime(timeRepository.findById(jogadorDTO.getTime()));

       return jogadoresRepository.save(jogador);
   }

   public List<Jogador> findAll(){
       return jogadoresRepository.findAll();
   }

   public Jogador findById(Long id){
       return jogadoresRepository.findById(id).orElse(null);
   }

   public void deleteById(Long id){
       jogadoresRepository.deleteById(id);
   }

    public Jogador updateJogador(JogadorDTO jogadorDTO){

        Jogador jogador = findById(jogadorDTO.getId());
        jogador.setNome(jogadorDTO.getNome());
        jogador.setAltura(jogadorDTO.getAltura());
        jogador.setPeso(jogadorDTO.getPeso());
        jogador.setPosicao(jogadorDTO.getPosicao());
        jogador.setTime(timeRepository.findById(jogadorDTO.getTime()));

        return jogadoresRepository.save(jogador);
    }

}
