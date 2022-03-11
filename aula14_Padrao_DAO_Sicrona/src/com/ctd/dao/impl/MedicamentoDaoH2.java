package com.ctd.dao.impl;

import com.ctd.dao.DB;
import com.ctd.dao.IDAO;
import com.ctd.dao.exceptions.DbException;
import com.ctd.model.Medicamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicamentoDaoH2 implements IDAO<Medicamento> {

    private Connection conn;

    public MedicamentoDaoH2(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void salvar(Medicamento medicamento) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(String.format("""
                    INSERT INTO medicamentos (nome, laboratorio, quantidade, preco)
                    VALUES
                    ('%s', '%s', '%s', '%s')
                    """, medicamento.getNome(), medicamento.getLaboratorio(),
                    medicamento.getQuantidade(), medicamento.getPreco()), Statement
                    .RETURN_GENERATED_KEYS);

            int rows = st.executeUpdate();

            if (rows > 0){
                rs = st.getGeneratedKeys();
                if (rs.next()){
                    int id = rs.getInt(1);
                    medicamento.setId(id);
                }
            }
            else {
                throw new DbException("Unexpected error! No rows affected!");
            }

            System.out.println("ok");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

    }

    @Override
    public Medicamento findById(int id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("""
                    SELECT * FROM medicamentos
                    WHERE id = ?
                    """);
            st.setInt(1, id);

            rs = st.executeQuery();

            if (rs.next()){
                return instantiateMediacamento(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

        return null;
    }

    @Override
    public List<Medicamento> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("""
                    SELECT * FROM medicamentos
                    """);
            rs = st.executeQuery();

            List<Medicamento> medicamentos = new ArrayList<>();

            while (rs.next()){
                medicamentos.add(instantiateMediacamento(rs));
            }

            return medicamentos;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

        return null;
    }

    @Override
    public void deleteByID(int id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("""
                    DELETE FROM medicamentos
                    WHERE id = ?
                    """);
            st.setInt(1, id);

            int rows = st.executeUpdate();

            if (rows == 0){
                throw new DbException("No exist id");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public void update(Medicamento medicamento) {
            PreparedStatement st = null;

            try {
                st = conn.prepareStatement("""
                    UPDATE medicamentos
                    SET nome = ?, laboratorio = ?, quantidade = ?, preco = ?
                    WHERE Id = ?
                    """);

                st.setString(1, medicamento.getNome());
                st.setString(2, medicamento.getLaboratorio());
                st.setInt(3, medicamento.getQuantidade());
                st.setDouble(4, medicamento.getPreco());
                st.setInt(5, medicamento.getId());

                st.executeUpdate();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }finally {
                DB.closeStatement(st);
            }

    }

    public Medicamento instantiateMediacamento(ResultSet rs) throws SQLException {
        Medicamento medicamento = new Medicamento();
        medicamento.setId(rs.getInt("id"));
        medicamento.setNome(rs.getString("nome"));
        medicamento.setLaboratorio(rs.getString("laboratorio"));
        medicamento.setQuantidade(rs.getInt("quantidade"));
        medicamento.setPreco(rs.getDouble("preco"));

        return medicamento;
    }

}
