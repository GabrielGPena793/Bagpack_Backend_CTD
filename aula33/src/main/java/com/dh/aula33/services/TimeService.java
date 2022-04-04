package com.dh.aula33.services;

import com.dh.aula33.model.Time;
import com.dh.aula33.repositories.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    public Time post(Time time){
        return timeRepository.save(time);
    }

}
