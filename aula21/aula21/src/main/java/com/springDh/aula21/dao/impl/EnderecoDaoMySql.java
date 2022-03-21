package com.springDh.aula21.dao.impl;

import com.springDh.aula21.dao.IDao;
import com.springDh.aula21.dao.config.DB;
import com.springDh.aula21.model.Dentista;
import com.springDh.aula21.model.Endereco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EnderecoDaoMySql implements IDao<Endereco> {

    private Connection conn;

    public EnderecoDaoMySql() {
        this.conn = DB.getConnection();
    }

    @Override
    public Endereco salvar(Endereco endereco) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("""
                    INSERT INTO endereco
                    (rua, numero, bairro, cidade, estado)
                    VALUES (?, ?, ?, ?, ?)
                    """, Statement.RETURN_GENERATED_KEYS);

            st.setString(1, endereco.getRua());
            st.setString(2, endereco.getNumero());
            st.setString(3, endereco.getBairro());
            st.setString(4, endereco.getCidade());
            st.setString(5, endereco.getEstado());

            st.executeUpdate();
            rs = st.getGeneratedKeys();
            if (rs.next())
                endereco.setId(rs.getInt(1));

            return endereco;

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
    public Optional<Endereco> buscar(Integer id) {
        return Optional.empty();
    }

    @Override
    public void excluir(Integer id) {

    }

    @Override
    public List<Endereco> buscarTodos() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("""
                    SELECT * FROM endereco;
                    """);

            List<Endereco> enderecos = new ArrayList<>();

            rs = st.executeQuery();

            while (rs.next()){
                enderecos.add(instantieteEndereco(rs));
            }

            return enderecos;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public Endereco atualizar(Endereco endereco) {
        return null;
    }

    private Endereco instantieteEndereco(ResultSet rs) throws SQLException {
        Endereco endereco = new Endereco();
        endereco.setId(rs.getInt("id"));
        endereco.setRua(rs.getString("rua"));
        endereco.setBairro(rs.getString("bairro"));
        endereco.setCidade(rs.getString("cidade"));
        endereco.setCidade(rs.getString("cidade"));
        endereco.setEstado(rs.getString("estado"));
        return endereco;
    }
}
