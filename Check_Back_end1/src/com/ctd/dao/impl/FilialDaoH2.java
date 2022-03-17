package com.ctd.dao.impl;

import com.ctd.dao.IDAO;
import com.ctd.dao.config.DB;
import com.ctd.model.Filial;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilialDaoH2 implements IDAO<Filial> {

    private Connection conn;

    public FilialDaoH2() {
        this.conn = DB.getConnection();
    }

    @Override
    public Filial salvar(Filial filial) {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("""
                    INSERT INTO filial (nomeFilial, rua, numero, cidade, estado, e5Estrelas)
                    VALUES
                    (?, ?, ?, ?, ?, ?)
                    """, Statement.RETURN_GENERATED_KEYS);

            st.setString(1, filial.getNomeFilial());
            st.setString(2, filial.getRua());
            st.setString(3, filial.getNumero());
            st.setString(4, filial.getCidade());
            st.setString(5, filial.getEstado());
            st.setInt(6, filial.getE5Estrelas() ? 1 : 0);

            int rows = st.executeUpdate();

            if (rows > 0) {
                rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    filial.setId(id);
                }

            }
            } catch(SQLException e){
                e.printStackTrace();
            }finally{
                DB.closeStatement(st);
            }

            return filial;
    }

    @Override
    public List<Filial> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("""
                    SELECT * FROM filial
                    """);
            rs = st.executeQuery();

            List<Filial> filiais = new ArrayList<>();

            while (rs.next()){
                Filial filial = new Filial();
                filial.setId(rs.getInt("id"));
                filial.setNomeFilial(rs.getString("nomeFilial"));
                filial.setRua(rs.getString("rua"));
                filial.setNumero(rs.getString("numero"));
                filial.setCidade(rs.getString("cidade"));
                filial.setEstado(rs.getString("estado"));
                filial.setE5Estrelas(rs.getInt("e5Estrelas") >= 1);

                filiais.add(filial);
            }

            return filiais;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

        return null;
    }
}
