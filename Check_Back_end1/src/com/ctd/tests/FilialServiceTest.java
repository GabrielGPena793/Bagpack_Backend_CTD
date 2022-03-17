package com.ctd.tests;

import com.ctd.dao.impl.FilialDaoH2;
import com.ctd.model.Filial;
import com.ctd.services.FilialService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilialServiceTest {

    private static final Logger LOGGER = Logger.getLogger(FilialServiceTest.class);

    @Test
    public void temQueRetonarObjetoComIdSalvoDoBanco(){

        FilialService filialService = new FilialService(new FilialDaoH2());

        Filial filial = new Filial("jorgeProduções", "rua onde tudo volta", "152", "São Paulo", "São Paulo", true);
        Filial filial2 = new Filial("jorgeEntreterimento", "rua tudo vai", "200", "Recife", "Pernambuco", true);
        Filial filial3 = new Filial("jorgeSaude", "rua tudo vem", "100", "Bahia", "Salvador", false);
        Filial filial4 = new Filial("jorgeFilmes", "rua tudo já foi", "5", "Florianopolis", "Santacatarina", true);
        Filial filial5 = new Filial("jorgeInformatica", "rua tudo é", "6", "Belo horizonte", "Minas Gerais", false);

        filial = filialService.salvar(filial);
        filial2 = filialService.salvar(filial2);
        filial3 = filialService.salvar(filial3);
        filial4 = filialService.salvar(filial4);
        filial5 = filialService.salvar(filial5);

//        assertNotNull(filial.getId());
//        LOGGER.info("Retornando o primeiro objeto com o id salvo do banco: " + filial);
//        assertNotNull(filial2.getId());
//        LOGGER.info("Retornando o segundo objeto com o id salvo do banco: " + filial2);
//        assertNotNull(filial3.getId());
//        LOGGER.info("Retornando o terceiro objeto com o id salvo do banco: " + filial3);
//        assertNotNull(filial4.getId());
//        LOGGER.info("Retornando o quarto objeto com o id salvo do banco: " + filial4);
//        assertNotNull(filial5.getId());
//        LOGGER.info("Retornando o quinto objeto com o id salvo do banco: " + filial5);
//

        filialService.findAll().forEach(System.out::println);

    }

}