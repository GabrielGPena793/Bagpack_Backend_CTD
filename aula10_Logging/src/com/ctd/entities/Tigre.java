package com.ctd.entities;

import com.ctd.tests.TestLog;
import org.apache.log4j.Logger;

public class Tigre {

    private static final org.apache.log4j.Logger logger = Logger.getLogger(TestLog.class);

    private String name;
    private int age;

    public Tigre() {
    }

    public Tigre(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void run(){
        logger.info("O Tigre está correndo");
    }
}
