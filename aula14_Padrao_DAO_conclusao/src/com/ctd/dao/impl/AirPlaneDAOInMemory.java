package com.ctd.dao.impl;

import com.ctd.dao.IDAO;
import com.ctd.model.AirPlane;

import java.util.ArrayList;
import java.util.List;

public class AirPlaneDAOInMemory implements IDAO<AirPlane> {
    private List<AirPlane> airPlanes;

    public AirPlaneDAOInMemory() {
        this.airPlanes = new ArrayList<>();
    }

    @Override
    public void insert(AirPlane obj) {
        airPlanes.add(obj);
    }

    @Override
    public void deleteById(Integer id) {

        airPlanes.removeIf(airPlane -> airPlane.getId() == id);

    }

    @Override
    public AirPlane findById(Integer id) {
        return  airPlanes.stream().filter( airPlane -> airPlane.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<AirPlane> findAll() {
        return airPlanes;
    }
}
