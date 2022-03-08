package com.ctd.dao.impl;

import com.ctd.dao.IDAO;
import com.ctd.db.DB;
import com.ctd.model.AirPlane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AirPlaneDAOH2 implements IDAO<AirPlane> {

    private Connection conn;

    public AirPlaneDAOH2() {
        this.conn = DB.getConnection();
    }

    @Override
    public void insert(AirPlane obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("""
                    INSERT INTO airPlane (id, brand, model, registration, DateEntryIntoservice)
                    VALUES
                    (?, ?, ?, ?, ?)
                    """);

            st.setInt(1,obj.getId());
            st.setString(2, obj.getBrand());
            st.setString(3, obj.getModel());
            st.setInt(4,obj.getRegistration());
            st.setDate(5, new  java.sql.Date(obj.getDateEntryIntoservice().getTime()));

            int rowsAffect = st.executeUpdate();

            System.out.println(rowsAffect);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(AirPlane obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public AirPlane fingById(Integer id) {
        return null;
    }

    @Override
    public List<AirPlane> findAll() {
        return null;
    }
}
