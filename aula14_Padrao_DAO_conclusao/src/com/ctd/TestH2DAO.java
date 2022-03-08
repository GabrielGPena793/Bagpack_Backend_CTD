package com.ctd;

import com.ctd.dao.IDAO;
import com.ctd.dao.impl.AirPlaneDAOH2;
import com.ctd.model.AirPlane;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestH2DAO {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        IDAO<AirPlane> airPlaneService = new AirPlaneDAOH2();

        AirPlane airPlane = new AirPlane(1, "voador", "jato", 2564, sdf.parse("28/02/1850"));

        airPlaneService.insert(airPlane);
    }
}
