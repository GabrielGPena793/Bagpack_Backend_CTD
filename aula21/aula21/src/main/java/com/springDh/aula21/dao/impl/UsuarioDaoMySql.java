package com.springDh.aula21.dao.impl;

import com.springDh.aula21.dao.IDao;
import com.springDh.aula21.dao.config.DB;
import com.springDh.aula21.model.Endereco;
import com.springDh.aula21.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioDaoMySql implements IDao<Usuario> {

    private final Connection conn;

    public UsuarioDaoMySql() {
        this.conn = DB.getConnection();
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("""
                    INSERT INTO usuario
                    (nome, email, senha, acesso)
                    VALUES (?, ?, ?, ?)
                    """, Statement.RETURN_GENERATED_KEYS);

            st.setString(1, usuario.getNome());
            st.setString(2, usuario.getEmail());
            st.setString(3, usuario.getSenha());
            st.setInt(4, usuario.getAcesso());

            st.executeUpdate();
            rs = st.getGeneratedKeys();
            if (rs.next())
                usuario.setId(rs.getInt(1));

            return usuario;

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
    public Optional<Usuario> buscar(Integer id) {
        return Optional.empty();
    }

    @Override
    public void excluir(Integer id) {

        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("""
                    DELETE FROM usuario
                    WHERE id = ?;
                    """);

            st.setInt(1 , id);
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public List<Usuario> buscarTodos() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("""
                    SELECT * FROM usuario;
                    """);

            List<Usuario> usuarios = new ArrayList<>();

            rs = st.executeQuery();

            while (rs.next()){
                usuarios.add(instantieteUsuario(rs));
            }

            return usuarios;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }


        return null;
    }

    private Usuario instantieteUsuario(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(rs.getInt("id"));
        usuario.setNome(rs.getString("nome"));
        usuario.setEmail(rs.getString("email"));
        usuario.setSenha(rs.getString("senha"));
        usuario.setAcesso(rs.getInt("acesso"));

        return usuario;

    }

    @Override
    public Usuario atualizar(Usuario usuario) {
        return null;
    }
}
