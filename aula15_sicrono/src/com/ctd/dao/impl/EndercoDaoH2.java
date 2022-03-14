package com.ctd.dao.impl;

import com.ctd.dao.IDAO;
import com.ctd.dao.config.DB;
import com.ctd.model.Endereco;

import java.sql.*;

public class EndercoDaoH2 implements IDAO<Endereco> {

    private Connection conn;

    public EndercoDaoH2() {
        this.conn = DB.getConnection();
    }

    @Override
    public Endereco salvar(Endereco endereco) {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("""
                    INSERT INTO enderecos (rua, numero, cidade, bairro)
                    VALUES (?, ? ,?, ?);
                    """, Statement.RETURN_GENERATED_KEYS);

            st.setString(1, endereco.getRua());
            st.setString(2, endereco.getNumero());
            st.setString(3, endereco.getCidade());
            st.setString(4, endereco.getBairro());


            st.execute();
            rs = st.getGeneratedKeys();

            if (rs.next()){
                    endereco.setId(rs.getInt(1));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }

        return endereco;
    }
}
