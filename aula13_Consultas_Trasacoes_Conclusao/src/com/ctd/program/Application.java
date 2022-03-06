package com.ctd.program;

import com.ctd.db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Application {

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Connection conn = DB.getConnection();
        PreparedStatement st = null;

        try {

            conn.setAutoCommit(false);

            st = conn.prepareStatement("""
                    INSERT INTO paciente (nome, sobreNome, endereco, rg, dataCadastro, nomeUsuario, senha)
                    VALUES (?,?,?,?,?,?,?);
                    """);

            st.setString(1,"Paulo" );
            st.setString(2,"Rocha" );
            st.setString(3,"Rua das tres voltas");
            st.setString(4,"1245896");
            st.setDate(5, new  java.sql.Date(sdf.parse("1996/03/28").getTime()));
            st.setString(6,"PaulRocha");
            st.setString(7,"AFD5548");

            st.executeUpdate();

            st = conn.prepareStatement("""
                    UPDATE paciente SET senha = "novaSenha"
                    WHERE nome = "Paulo";
                    """);

            int x = 0;
            if (x == 0){
                throw new SQLException("FAKE ERROR");
            }
            st.executeUpdate();


            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}
