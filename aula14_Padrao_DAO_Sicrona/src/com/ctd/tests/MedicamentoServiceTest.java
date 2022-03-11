package com.ctd.tests;

import com.ctd.Main;
import com.ctd.dao.DB;
import com.ctd.dao.impl.MedicamentoDaoH2;
import com.ctd.model.Medicamento;
import com.ctd.services.MedicamentoService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MedicamentoServiceTest {

    private static final org.apache.log4j.Logger logger = Logger.getLogger(Main.class);
    MedicamentoService medicamentoService;


    @BeforeEach
    public void alimentandoBanco(){
        medicamentoService = new MedicamentoService(new MedicamentoDaoH2(DB.getConnection()));

        Medicamento medicamento = new Medicamento("Ibuprofeno", "Aché", 935, 35.7);
        Medicamento medicamento2 = new Medicamento("Dorflex", "Aché", 5, 10.0);
        Medicamento medicamento3 = new Medicamento("Tylenol", "Aché", 1, 3.0);

        logger.info("Adicioando os dados...");
        medicamentoService.salvar(medicamento);
        medicamentoService.salvar(medicamento2);
        medicamentoService.salvar(medicamento3);
    }


    @Test
    public void findById(){

        Medicamento medicamentoBD = medicamentoService.findById(1);

        Medicamento medicamento = new Medicamento(1,"Ibuprofeno", "Aché", 935, 35.7);
        assertEquals(medicamento.toString(), medicamentoBD.toString());
        logger.info("Teste passou, retornou os dados esperados no id");


    }

    @Test
    public void findAll(){

        List<Medicamento> medicamentos = medicamentoService.findAll();

        assertEquals(3, medicamentos.size());
        logger.info("Teste passou, com o tamanho esperado do array");
    }


    @Test
    public void update(){

        Medicamento medicamento = new Medicamento("Tylenol", "Aché", 1, 3.0);

        Medicamento medicamentoUpdate = new Medicamento(3,"update", "Aché", 935, 55.00);
        medicamentoService.update(medicamentoUpdate);

        medicamentoUpdate = medicamentoService.findById(1);

        assertNotEquals(medicamento.toString(), medicamentoUpdate.toString());
        logger.info("Teste passou, o elemento foi alterado ");

    }


    @Test
    public void deleteById(){
        medicamentoService.deleteById(2);

        assertNull(medicamentoService.findById(2));

        logger.info("O dado foi deletado com sucesso!");

    }

}