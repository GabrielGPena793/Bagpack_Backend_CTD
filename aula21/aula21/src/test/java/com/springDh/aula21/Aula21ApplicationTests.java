package com.springDh.aula21;

import com.springDh.aula21.dao.impl.DentistaDaoMySql;
import com.springDh.aula21.dao.impl.EnderecoDaoMySql;
import com.springDh.aula21.model.Dentista;
import com.springDh.aula21.model.Endereco;
import com.springDh.aula21.services.DentistaService;
import com.springDh.aula21.services.EnderecoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Aula21ApplicationTests {

	private  static final DentistaService dentistaService = new DentistaService(new DentistaDaoMySql());
	private static final EnderecoService enderecoService= new EnderecoService(new EnderecoDaoMySql());

	@Test
	void contextLoads() {
	}

	@Test
	public void carregarTresDentistas(){
		Dentista d1 = new Dentista("jorge", "jorge@gmail.com", 12458, 0);
		Dentista d2 = new Dentista("Maria", "maria@gmail.com", 11254, 1);
		Dentista d3 = new Dentista("Luan", "luan@gmail.com", 88945, 0);

		dentistaService.salvar(d1);
		dentistaService.salvar(d2);
		dentistaService.salvar(d3);
	}

	@Test
	public void trazerTodosOsDentitas(){
		dentistaService.buscarTodos().forEach(System.out::println);
	}

	@Test
	public void carregarTresEnderecos(){
		Endereco endereco = new Endereco("buraqueira", "120", "Buraco", "BuraBura", "Burabumco");
		Endereco endereco2 = new Endereco("ventania", "012", "Ventos", "Ventacife", "Ventambuco");
		Endereco endereco3 = new Endereco("Lagoa", "52", "Lagoeira", "Logo", "Lagombuco");

		enderecoService.salvar(endereco);
		enderecoService.salvar(endereco2);
		enderecoService.salvar(endereco3);
	}

	@Test
	public void trazerTodosOsEndercos(){
		enderecoService.buscarTodos().forEach(System.out::println);
	}
}
