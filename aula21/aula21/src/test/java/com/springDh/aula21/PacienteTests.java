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

        pacienteService.salvar(paciente);
    }
}
