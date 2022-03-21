package com.example.dentista.services.impl;

import com.example.dentista.model.Dentista;
import com.example.dentista.services.IDentistaService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DentistaService implements IDentistaService {

    @Override
    public List<Dentista> listaDentistas() {
        return Arrays.asList(new Dentista("Maria"), new Dentista("João"));
    }

}
