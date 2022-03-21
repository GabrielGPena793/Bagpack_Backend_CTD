package com.example.aula25conclusao;

import com.example.aula25conclusao.services.IDataNascimentoService;
import com.example.aula25conclusao.services.impl.DataNascimentoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Aula25conclusaoApplicationTests {

	@Test
	void contextLoads() {
		IDataNascimentoService dataNascimentoService = new DataNascimentoService();

		System.out.println(dataNascimentoService.calcularIdade(28, 3,1996));

	}

}
