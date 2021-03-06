package com.ctd;

import com.ctd.dao.IDAO;
import com.ctd.dao.impl.AirPlaneDAOInMemory;
import com.ctd.model.AirPlane;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestMemoryDAO {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        IDAO<AirPlane> airPlaneIDAOMemory = new AirPlaneDAOInMemory();

        AirPlane airPlane = new AirPlane(1,"voador", "jato", 2548796, sdf.parse("28/03/1996"));
        AirPlane airPlane2 = new AirPlane(2,"Aeronave", "jatot", 1023548, sdf.parse("28/03/1880"));
        AirPlane airPlane3 = new AirPlane(3,"Foguete", "jatoq", 9996, sdf.parse("28/03/2000"));
        AirPlane airPlane4 = new AirPlane(4,"Jato", "jatos", 5555, sdf.parse("28/03/2010"));

        airPlaneIDAOMemory.insert(airPlane);
        airPlaneIDAOMemory.insert(airPlane2);
        airPlaneIDAOMemory.insert(airPlane3);
        airPlaneIDAOMemory.insert(airPlane4);


        System.out.println(" ==== buscar por id ====");
        System.out.println(airPlaneIDAOMemory.findById(2));

        System.out.println(" ==== deletar por id ====");
        airPlaneIDAOMemory.deleteById(4);


        System.out.println(" ==== selecionado todos no banco ==== ");
        airPlaneIDAOMemory.findAll().forEach(System.out::println);


    }
}
