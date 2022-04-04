package com.dh.aula33.services;

import com.dh.aula33.model.Time;
import com.dh.aula33.repositories.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    public Time post(Time time){
        return timeRepository.save(time);
    }

    public Time findById(Long id){
        return timeRepository.findById(id).orElse(null);
    }

    public List<Time> findAll(){
        return timeRepository.findAll();
    }

    public void deleteById(Long id){
        timeRepository.deleteById(id);
    }

    public Time updateTime(Time time){

        Time timeAtualizado = findById(time.getId());
        timeAtualizado.setNome(time.getNome());
        timeAtualizado.setCidade(time.getCidade());
        timeAtualizado.setEstado(time.getEstado());

        return timeRepository.save(timeAtualizado);
    }
}
