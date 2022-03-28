package com.springDh.aula21.dao.impl;

import com.springDh.aula21.dao.IDao;
import com.springDh.aula21.dao.config.DB;
import com.springDh.aula21.model.Endereco;
import com.springDh.aula21.model.Paciente;
import com.springDh.aula21.util.Util;

import java.sql.*;
import java.util.ArrayList;
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

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("""
                    Select * FROM paciente
                    WHERE id = ?;
                    """);

            st.setInt(1, id);

            rs = st.executeQuery();

            if(rs.next()){
                Paciente paciente = instatietePaiciente(rs);
                return Optional.of(paciente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

        return Optional.empty();
    }

    @Override
    public void excluir(Integer id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("""
                    DELETE FROM paciente
                    WHERE id = ?;
                    """);

            st.setInt(1 , id);
            int rows = st.executeUpdate();

            if (rows == 0){
                System.out.println("Não existe esse Id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public List<Paciente> buscarTodos() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("""
                    Select * from paciente
                    """);

            rs = st.executeQuery();

            List<Paciente> pacienteList = new ArrayList<>();

            while (rs.next()){
                pacienteList.add(instatietePaiciente(rs));
            }

            return pacienteList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }

        return null;
    }

    @Override
    public Paciente atualizar(Paciente paciente) {
        PreparedStatement st = null;

        //atualizar endereco
        if (paciente.getEndereco() != null && paciente.getId() != null){
            enderecoDaoMySql.atualizar(paciente.getEndereco());
        }

        try {
            st = conn.prepareStatement("""
                    UPDATE paciente
                    SET nome = ?, sobrenome = ?, cpf = ?
                    WHERE id = ?;
                    """);

            st.setString(1, paciente.getNome());
            st.setString(2, paciente.getSobrenome());
            st.setString(3, paciente.getCpf());
            st.setInt(4, paciente.getId());

            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paciente;
    }

    public Paciente instatietePaiciente(ResultSet rs) throws SQLException {
        Paciente paciente = new Paciente();
        paciente.setId(rs.getInt("id"));
        paciente.setNome(rs.getString("nome"));
        paciente.setSobrenome(rs.getString("sobrenome"));
        paciente.setCpf(rs.getString("cpf"));
        paciente.setDataCad(rs.getDate("dataCad"));
        Endereco endereco = enderecoDaoMySql.buscar(rs.getInt("id_endereco")).orElse(null);
        paciente.setEndereco(endereco);
        return paciente;
    }


}
