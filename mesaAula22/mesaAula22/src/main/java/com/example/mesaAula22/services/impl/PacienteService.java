package com.example.mesaAula22.services.impl;

import com.example.mesaAula22.model.Paciente;
import com.example.mesaAula22.services.IPacienteService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PacienteService  implements IPacienteService {


    @Override
    public List<Paciente> pacienteList() {
        return Arrays.asList(new Paciente("jorge"), new Paciente("Luan"), new Paciente("Karla"));
    }
}
