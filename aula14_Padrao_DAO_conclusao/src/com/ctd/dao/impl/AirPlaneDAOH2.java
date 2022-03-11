package com.ctd.dao.impl;

import com.ctd.dao.IDAO;
import com.ctd.db.DB;
import com.ctd.db.DbException;
import com.ctd.model.AirPlane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirPlaneDAOH2 implements IDAO<AirPlane> {

    private Connection conn;

    public AirPlaneDAOH2() {
        this.conn = DB.getConnection();

        try {
            conn.prepareStatement("""
                    CREATE TABLE airPlane (
                    id INT PRIMARY KEY,
                    brand VARCHAR(60),
                    model VARCHAR(60),
                    registration INT,
                    dateEntryIntoservice DATE
                    );
                                        
                    """).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        }finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public void deleteById(Integer id) {

        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("""
                    DELETE FROM airPlane
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
    public AirPlane fingById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("""
                    SELECT * FROM airPlane
                    WHERE id = ?
                    """);

            st.setInt(1, id);

            rs = st.executeQuery();

            if (rs.next()){
                return instantiateAirPlane(rs);
            }else{
                throw new DbException("Id not exists!");
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
    public List<AirPlane> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("""
                    SELECT * FROM airPlane
                    """);

            rs = st.executeQuery();

            List<AirPlane> airPlanes = new ArrayList<>();

            while (rs.next()){
                airPlanes.add(instantiateAirPlane(rs));
            }

            return airPlanes;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

        return null;
    }

    public AirPlane instantiateAirPlane(ResultSet rs) throws SQLException {
        AirPlane airPlane = new AirPlane(
                rs.getInt("id"),
                rs.getString("brand"),
                rs.getString("model"),
                rs.getInt("registration"),
                rs.getDate("dateEntryIntoservice"
                ));
        return airPlane;
    }
}
