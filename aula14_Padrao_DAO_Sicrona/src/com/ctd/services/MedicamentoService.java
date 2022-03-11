package com.ctd.services;

import com.ctd.dao.IDAO;
import com.ctd.model.Medicamento;

import java.util.List;

public class MedicamentoService {

    private IDAO<Medicamento> medicamentoIDAO;

    public MedicamentoService(IDAO<Medicamento> medicamentoIDAO) {
        this.medicamentoIDAO = medicamentoIDAO;
    }

    public void salvar(Medicamento medicamento){
        medicamentoIDAO.salvar(medicamento);
    }

    public Medicamento findById(int id){
        return medicamentoIDAO.findById(id);
    }

    public List<Medicamento> findAll(){
        return medicamentoIDAO.findAll();
    }

    public void deleteById(int id){
        medicamentoIDAO.deleteByID(id);
    }

    public void update(Medicamento medicamento){
        medicamentoIDAO.update(medicamento);
    }
}
