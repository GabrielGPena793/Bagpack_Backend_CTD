package com.ctd.test;

import com.ctd.dao.impl.EndercoDaoH2;
import com.ctd.model.Endereco;
import com.ctd.service.EnderecoService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

class EnderecoServiceTest {

    private static final Logger LOGGER = Logger.getLogger(EnderecoServiceTest.class);


    private EnderecoService enderecoService = new EnderecoService(new EndercoDaoH2());

    @Test
    public void cadastrarEnderecoNoH2(){
        Endereco endereco = enderecoService.salvar(new Endereco("Av. Eldorado", "251", "São Paulo", "Morombi")) ;
        Endereco endereco2 = enderecoService.salvar(new Endereco("Av. dos estados", "350", "São josé", "Industrial"));
        Endereco endereco3 = enderecoService.salvar(new Endereco("RUA Sepé Tiaraju", "441", "Uruguaiana", "Centro"));

        LOGGER.info(endereco);

    }

}