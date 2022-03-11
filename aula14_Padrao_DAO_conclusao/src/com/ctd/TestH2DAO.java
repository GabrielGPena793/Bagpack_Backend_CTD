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

        AirPlane airPlane = new AirPlane(1,"voador", "jato", 2548796, sdf.parse("28/03/1996"));
        AirPlane airPlane2 = new AirPlane(2,"Aeronave", "jatot", 1023548, sdf.parse("28/03/1880"));
        AirPlane airPlane3 = new AirPlane(3,"Foguete", "jatoq", 9996, sdf.parse("28/03/2000"));
        AirPlane airPlane4 = new AirPlane(4,"Jato", "jatos", 5555, sdf.parse("28/03/2010"));

        airPlaneService.insert(airPlane);
        airPlaneService.insert(airPlane2);
        airPlaneService.insert(airPlane3);
        airPlaneService.insert(airPlane4);

        System.out.println(" ==== buscar por id ====");
        System.out.println(airPlaneService.fingById(4));

        System.out.println(" ==== deletar por id ====");
        System.out.println("deletando o número " + 1);
        airPlaneService.deleteById(1);

        System.out.println(" ==== selecionado todos no banco ==== ");
        airPlaneService.findAll().forEach(System.out::println);

    }
}
