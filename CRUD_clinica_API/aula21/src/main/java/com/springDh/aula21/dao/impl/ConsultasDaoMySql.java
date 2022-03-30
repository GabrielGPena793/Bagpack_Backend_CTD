package com.springDh.aula21.dao.impl;

import com.springDh.aula21.dao.IDao;
import com.springDh.aula21.dao.config.DB;
import com.springDh.aula21.dao.config.DbException;
import com.springDh.aula21.model.Consultas;
import com.springDh.aula21.util.Util;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class ConsultasDaoMySql implements IDao<Consultas> {

    private Connection conn;

    private PacienteDaoMySql pacienteService;
    private DentistaDaoMySql dentistaService;
    private UsuarioDaoMySql usuarioService;

    public ConsultasDaoMySql() {
        this.conn =  DB.getConnection();
        this.pacienteService = new PacienteDaoMySql(new EnderecoDaoMySql());
        this.dentistaService = new DentistaDaoMySql();
        this.usuarioService = new UsuarioDaoMySql();

    }


    @Override
    public Consultas salvar(Consultas consultas) {

        PreparedStatement st = null;
        ResultSet rs = null;

        if (consultas.getDataAtend().after(consultas.getDataCad())){

            consultas.setPaciente(pacienteService.salvar(consultas.getPaciente()));
            consultas.setDentista(dentistaService.salvar(consultas.getDentista()));
            consultas.setUsuario(usuarioService.salvar(consultas.getUsuario()));

            try {

                st = conn.prepareStatement("""
                    INSERT INTO consultas (id_paciente, id_dentista, id_usuario, dataCad, dataAtend)
                    VALUES (?, ?, ?, ?, ?);
                    """, Statement.RETURN_GENERATED_KEYS);

                st.setInt(1, consultas.getPaciente().getId());
                st.setInt(2, consultas.getDentista().getId());
                st.setInt(3, consultas.getUsuario().getId());
                st.setTimestamp(4, Util.dateToTimestamp(consultas.getDataCad()));
                st.setTimestamp(5, Util.dateToTimestamp(consultas.getDataAtend()));

                st.executeUpdate();
                rs = st.getGeneratedKeys();

                if (rs.next()){
                    consultas.setId(rs.getInt(1));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                DB.closeStatement(st);
                DB.closeResultSet(rs);
            }
        }
        else {
            throw new DbException("Data de atendmento não pode ser antes da data de cadastro!");
        }

        return consultas;
    }

    @Override
    public Optional<Consultas> buscar(Integer id) {
        return Optional.empty();
    }

    @Override
    public void excluir(Integer id) {

    }

    @Override
    public List<Consultas> buscarTodos() {
        return null;
    }

    @Override
    public Consultas atualizar(Consultas consultas) {
        return null;
    }
}
