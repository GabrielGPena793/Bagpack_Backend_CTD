package com.springDh.aula21;

import com.springDh.aula21.dao.impl.DentistaDaoMySql;
import com.springDh.aula21.dao.impl.EnderecoDaoMySql;
import com.springDh.aula21.dao.impl.UsuarioDaoMySql;
import com.springDh.aula21.model.Dentista;
import com.springDh.aula21.model.Endereco;
import com.springDh.aula21.model.Usuario;
import com.springDh.aula21.services.DentistaService;
import com.springDh.aula21.services.EnderecoService;
import com.springDh.aula21.services.UsuarioService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class Aula21ApplicationTests {

	private  static final DentistaService dentistaService = new DentistaService(new DentistaDaoMySql());
	private static final EnderecoService enderecoService= new EnderecoService(new EnderecoDaoMySql());
	private static final UsuarioService USUARIO_SERVICE = new UsuarioService(new UsuarioDaoMySql());

	@Disabled
	@Test
	public void carregarTresDentistas(){
		Dentista d1 = new Dentista("jorge", "jorge@gmail.com", 12458, 0);
		Dentista d2 = new Dentista("Maria", "maria@gmail.com", 11254, 1);
		Dentista d3 = new Dentista("Luan", "luan@gmail.com", 88945, 0);

		dentistaService.salvar(d1);
		dentistaService.salvar(d2);
		dentistaService.salvar(d3);
	}

	@Disabled
	@Test
	public void trazerTodosOsDentitas(){
		dentistaService.buscarTodos().forEach(System.out::println);
	}

	@Disabled
	@Test
	public void excluirDentistaPeloId(){
		dentistaService.excluir(17);
	}

	@Disabled
	@Test
	public void carregarTresEnderecos(){
		Endereco endereco = new Endereco("buraqueira", "120", "Buraco", "BuraBura", "Burabumco");
		Endereco endereco2 = new Endereco("ventania", "012", "Ventos", "Ventacife", "Ventambuco");
		Endereco endereco3 = new Endereco("Lagoa", "52", "Lagoeira", "Logo", "Lagombuco");

		enderecoService.salvar(endereco);
		enderecoService.salvar(endereco2);
		enderecoService.salvar(endereco3);
	}

	@Disabled
	@Test
	public void trazerTodosOsEndercos(){
		enderecoService.buscarTodos().forEach(System.out::println);
	}

	@Disabled
	@Test
	public void excluirEnderecoPorId(){
		enderecoService.excluir(3);
	}

	@Disabled
	@Test
	public void salvarUsuario(){

		Usuario usuario = new Usuario("Piteco", "piteco@hotmail.com", "piteco123", 2);
		Usuario usuario2 = new Usuario("Lili", "lili@hotmail.com", "lili123", 1);
		Usuario usuario3 = new Usuario("Jorge", "jorge@hotmail.com", "jorge123", 4);

		USUARIO_SERVICE.salvar(usuario);
		USUARIO_SERVICE.salvar(usuario2);
		USUARIO_SERVICE.salvar(usuario3);
	}

	@Disabled
	@Test
	public void buscarTodosUsuarios(){
		USUARIO_SERVICE.buscarTodos().forEach(System.out::println);
	}

	@Disabled
	@Test
	public void excluirPorId(){
		USUARIO_SERVICE.excluir(4);
	}

	@Disabled
	@Test
	public void acharDentistaPorId(){
		Optional<Dentista> dentista = dentistaService.buscar(16);
		System.out.println(dentista);
	}

	@Disabled
	@Test
	public void atualizarDentista(){
		Dentista dentista = new Dentista(16, "Carla", "Carla@gmail.com",12458, 1);

		System.out.println(dentistaService.atualizar(dentista));
	}

	@Disabled
	@Test
	public void buscarEnderecoPorId(){
		System.out.println(enderecoService.buscar(2) );
	}

	@Disabled
	@Test
	public void atualizarEndereco(){
		enderecoService.atualizar(new Endereco(1, "Sono", "000", "Sonolencia", "Sonolise", "Sonambuco"));

		System.out.println(enderecoService.buscar(1) );
	}

	@Test
	public void buscarUsuarioPorId(){
		System.out.println(USUARIO_SERVICE.buscar(7));
	}

	@Test
	public void atualizarUsuario(){
		System.out.println(USUARIO_SERVICE.atualizar(new Usuario(2, "Barbara", "barbara@hotmail.com", "barbara512", 5)));
	}
}
