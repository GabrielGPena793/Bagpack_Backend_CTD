package com.springDh.aula21.dao.impl;

import com.springDh.aula21.dao.IDao;
import com.springDh.aula21.dao.config.DB;
import com.springDh.aula21.model.Paciente;
import com.springDh.aula21.util.Util;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class PacienteDaoMySql implements IDao<Paciente> {

    private Connection conn;
    private EnderecoDaoMySql enderecoDaoMySql;

    public PacienteDaoMySql(EnderecoDaoMySql enderecoDaoMySql) {
        this.conn = DB.getConnection();
        this.enderecoDaoMySql = enderecoDaoMySql;
    }

    @Override
    public Paciente salvar(Paciente paciente) {

        PreparedStatement st = null;

        paciente.setEndereco(enderecoDaoMySql.salvar(paciente.getEndereco()));

        try {
            st = conn.prepareStatement("""
                    INSERT INTO paciente
                    (nome, sobrenome, cpf, dataCad, id_endereco)
                    VALUES (?, ?, ?, ?, ?)
                    """, Statement.RETURN_GENERATED_KEYS);

            st.setString(1, paciente.getNome());
            st.setString(2, paciente.getSobrenome());
            st.setString(3, paciente.getCpf());
            st.setTimestamp(4, Util.dateToTimestamp(paciente.getDataCad()));
            st.setInt(5, paciente.getEndereco().getId());

            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();

            if (rs.next()){
                paciente.setId(rs.getInt(1));
                DB.closeResultSet(rs);
            }

            return paciente;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(st);
        }


        return null;
    }

    @Override
    public Optional<Paciente> buscar(Integer id) {
        return Optional.empty();
    }

    @Override
    public void excluir(Integer id) {

    }

    @Override
    public List<Paciente> buscarTodos() {
        return null;
    }

    @Override
    public Paciente atualizar(Paciente paciente) {
        return null;
    }
}
