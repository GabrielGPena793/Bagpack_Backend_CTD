package com.ctd.Dao.impl;

import com.ctd.Dao.IDAO;
import com.ctd.db.DB;
import com.ctd.db.exceptions.DbException;
import com.ctd.model.Funcionario;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDaoH2 implements IDAO<Funcionario> {

    private Connection conn;
    private final Logger LOGGER = Logger.getLogger(FuncionarioDaoH2.class);

    public FuncionarioDaoH2() {
        this.conn = DB.getConnection();
    }


    @Override
    public void insert(Funcionario funcionario) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("""
                    INSERT INTO funcionario (id, nome, email)
                    VALUES
                    (?, ?, ?)
                    """);

            st.setInt(1, funcionario.getId());
            st.setString(2 , funcionario.getNome());
            st.setString(3 , funcionario.getEmail());

            int rows = st.executeUpdate();

            System.out.println("ok");

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public void update(Funcionario funcionario) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("""
                    UPDATE funcionario
                    SET nome = ?, email = ?
                    WHERE Id = ?
                    """);

            st.setString(1, funcionario.getNome());
            st.setString(2, funcionario.getEmail());
            st.setInt(3, funcionario.getId());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public Funcionario findById(int id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("""
                    SELECT * FROM funcionario
                    WHERE id = ?
                    """);
            st.setInt(1, id);

            rs = st.executeQuery();

            if (rs.next()){
                return instantiateFuncionario(rs);
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
    public List<Funcionario> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("""
                    SELECT * FROM funcionario
                    """);
            rs = st.executeQuery();

            List<Funcionario> funcionarios = new ArrayList<>();

            while (rs.next()){
                funcionarios.add(instantiateFuncionario(rs));
            }

            return funcionarios;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

        return null;
    }

    @Override
    public void delete(String campo, Object valor) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(String.format("""
                    DELETE FROM funcionario
                    WHERE %s = ?
                    """, campo) );

            st.setObject(1, valor);

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

//    public void deleteByEmail(String email) {
//        PreparedStatement st = null;
//
//        try {
//            st = conn.prepareStatement("""
//                    DELETE FROM funcionario
//                    WHERE email = ?
//                    """);
//            st.setString(1, email);
//
//            int rows = st.executeUpdate();
//
//            if (rows == 0){
//                throw new DbException("No exist email");
//            }
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            DB.closeStatement(st);
//        }
//
//    }


    public Funcionario instantiateFuncionario(ResultSet rs) throws SQLException {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(rs.getInt("id"));
        funcionario.setNome(rs.getString("nome"));
        funcionario.setEmail(rs.getString("email"));

        return funcionario;
    }

}
