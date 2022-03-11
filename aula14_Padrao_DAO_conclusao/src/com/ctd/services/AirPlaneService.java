package com.ctd.services;

import com.ctd.dao.IDAO;
import com.ctd.model.AirPlane;

import java.util.List;

public class AirPlaneService {

    private IDAO<AirPlane> airPlaneIDAO;

    public AirPlaneService(IDAO<AirPlane> airPlaneIDAO) {
        this.airPlaneIDAO = airPlaneIDAO;
    }

    public void insert(AirPlane airPlane){
        airPlaneIDAO.insert(airPlane);
    }

    public AirPlane findById(int id){
        return airPlaneIDAO.findById(id);
    }

    public void deleteById(int id){
        airPlaneIDAO.deleteById(id);
    }

    public List<AirPlane> findAll(){
        return airPlaneIDAO.findAll();
    }
}
