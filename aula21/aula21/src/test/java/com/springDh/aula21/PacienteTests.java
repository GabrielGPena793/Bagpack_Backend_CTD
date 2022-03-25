package com.springDh.aula21;

import com.springDh.aula21.dao.impl.EnderecoDaoMySql;
import com.springDh.aula21.dao.impl.PacienteDaoMySql;
import com.springDh.aula21.model.Endereco;
import com.springDh.aula21.model.Paciente;
import com.springDh.aula21.services.PacienteService;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PacienteTests {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private PacienteService pacienteService = new PacienteService(new PacienteDaoMySql(new EnderecoDaoMySql()));

    @Test
    public void salvarPaciente() throws ParseException {
        Endereco endereco = new Endereco("rua da rua", "121", "ruas", "ruaria", "RA");
        Paciente paciente = new Paciente("jorge", "barbosa", "15216351", sdf.parse("25/02/1998"), endereco );

        Endereco endereco2 = new Endereco("av eldorado", "56", "eldorist", "eldorumc", "EO");
        Paciente paciente2 = new Paciente("Antoino", "Carlos", "55481356", sdf.parse("23/05/2000"), endereco2 );

        Endereco endereco3 = new Endereco("São bento", "12", "Ben", "Bentisc", "BT");
        Paciente paciente3 = new Paciente("Karla", "Yall", "002556189", sdf.parse("02/08/2010"), endereco3 );

        pacienteService.salvar(paciente);
        pacienteService.salvar(paciente2);
        pacienteService.salvar(paciente3);
    }

    @Test
    public void buscarPeloId3(){
        Paciente paciente = pacienteService.buscarPorId(3);
        System.out.println(paciente);
    }

    @Test
    public void excluirPeloId3(){
       pacienteService.excluir(3);
    }

    @Test
    public void buscarTodos(){
        pacienteService.buscarTodos().forEach(System.out::println);
    }

    @Test
    public void atualizarPacienteComId4(){
        Endereco endAt = new Endereco(9, "Av. Paraguassú", "524", "centro", "Capão da canoa", "RS");
        Paciente paciente = new Paciente(2,"Pepi", "Almeida", "15652148", endAt);

        pacienteService.atualizar(paciente);
    }
}
