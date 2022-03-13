package com.ctd;

import com.ctd.model.Dog;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Dog dog1 = new Dog("pepi", "pintcher", "rua lisa, 102", 5);
        Dog dog2 = new Dog("bob", "rottweiler", "rua bomba bomba, 02", 8);
        Dog dog3 = new Dog("piteco", "Beagle", "rua onde o vento deu a curva, 000", 3);
        Dog dog4 = new Dog("lily", "Chihuahua", "rua das flores, 1006", 6);
        Dog dog5 = new Dog("myke", "Maltês", "rua dos buracos, 111", 5);
        Dog dog6 = new Dog("quinn", "Poodle", "rua da luz, 553", 5);

        Map<String, List<Dog>> weekDogs = new LinkedHashMap<>();

        weekDogs.put("segunda", Arrays.asList(dog1, dog3));
        weekDogs.put("terça", Arrays.asList(dog6, dog4));
        weekDogs.put("quarta", Arrays.asList(dog2, dog3));
        weekDogs.put("quinta", Arrays.asList(dog2, dog4));
        weekDogs.put("sexta", Arrays.asList(dog1, dog6));

        FileOutputStream fo = new FileOutputStream("docs.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fo);
        oos.writeObject(weekDogs);

        FileInputStream fi = new FileInputStream("docs.dat");
        ObjectInputStream ois = new ObjectInputStream(fi);

        System.out.println(ois.readObject());

    }
}
