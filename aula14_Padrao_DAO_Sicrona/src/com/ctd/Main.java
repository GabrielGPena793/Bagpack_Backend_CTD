package com.ctd;

import com.ctd.dao.DB;
import com.ctd.dao.impl.MedicamentoDaoH2;
import com.ctd.model.Medicamento;
import com.ctd.services.MedicamentoService;
import org.apache.log4j.Logger;

public class Main {

    private static final org.apache.log4j.Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoDaoH2(DB.getConnection()));


        Medicamento medicamento = new Medicamento("Ibuprofeno", "Aché", 935, 35.7);
        Medicamento medicamento2 = new Medicamento("Dorflex", "Aché", 5, 10.0);
        Medicamento medicamento3 = new Medicamento("Tylenol", "Aché", 1, 3.0);

        logger.info("Adicioando os dados...");
        medicamentoService.salvar(medicamento);
        medicamentoService.salvar(medicamento2);
        medicamentoService.salvar(medicamento3);


        logger.info("Buscando todos os dados do banco...");
        medicamentoService.findAll().forEach(System.out::println);
        logger.info("Apagando o id 2...");
        medicamentoService.deleteById(2);
        logger.info("Buscando todos os dados do banco novamente...");
        medicamentoService.findAll().forEach(System.out::println);
        System.out.println("Atualizando o id 3...");
        Medicamento medicamento4 = new Medicamento(3, "Tylenol", "update", 1, 3.0);
        medicamentoService.update(medicamento4);
        System.out.println("verificando se teve alteração no id 3...");
        System.out.println(medicamentoService.findById(3));


    }
}
