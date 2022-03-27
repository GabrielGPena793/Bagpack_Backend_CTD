package com.dh.aula31Conclusao.services.impl;

import com.dh.aula31Conclusao.entitites.Mascote;
import com.dh.aula31Conclusao.repositories.MascoteRepository;
import com.dh.aula31Conclusao.services.IMascoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascoteService implements IMascoteService<Mascote> {

    @Autowired
    private MascoteRepository mascoteRepository;


    @Override
    public void insert(Mascote mascote) {
        mascoteRepository.save(mascote);
    }

    @Override
    public void delete(Long id) {
        mascoteRepository.deleteById(id);
    }

    @Override
    public Mascote findById(Long id) {
        Optional<Mascote> mascote = mascoteRepository.findById(id);

        return mascote.orElse(null);
    }

    @Override
    public List<Mascote> findAll() {
        return mascoteRepository.findAll();
    }

    @Override
    public void update(Mascote mascote) {
        mascoteRepository.save(mascote);
    }
}
