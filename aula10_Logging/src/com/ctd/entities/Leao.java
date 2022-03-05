package com.ctd.entities;

import com.ctd.tests.TestLog;
import org.apache.log4j.Logger;

public class Leao {

    private static final org.apache.log4j.Logger logger = Logger.getLogger(TestLog.class);

    private String name;
    private int age;
    private boolean eAlfa;

    public Leao() {
    }

    public Leao(String name, int age, boolean eAlfa) {
        this.name = name;
        this.age = age;
        this.eAlfa = eAlfa;
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
        logger.info("O Leão " + name +  " está correndo");
    }

    public void eMaiorQue10(){
//
//        if (age <= 10 && age >= 0){
//            logger.error("A idade do leão é menor ou igual a 10 anos");
//        }

        if (age < 0){
            logger.error("A idade não pode ser negativa");
            throw new IllegalStateException();
        }

        if (!eAlfa){
            logger.error("O leão não é Alfa");
        }
    }
}
