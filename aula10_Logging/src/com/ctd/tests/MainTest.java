package com.ctd.tests;

import com.ctd.entities.Leao;
import com.ctd.entities.Tigre;
import org.apache.log4j.Logger;

public class MainTest {

    private static final org.apache.log4j.Logger logger = Logger.getLogger(TestLog.class);


    public static void main(String[] args) {

        Leao simba = new Leao("Simba", 15, true);
        Leao mafusa = new Leao("Mafusa", -1, true);

        Tigre tigre = new Tigre("Pipo", 15);
        Tigre tigre2 = new Tigre("Lili", 5);

        simba.run();
        mafusa.run();

        try{
            simba.eMaiorQue10();
            mafusa.eMaiorQue10();
        }catch (Exception e){
            logger.error("A idade do leão " + mafusa.getName() + " está incorreta", e );
        }

        tigre.run();
        tigre.run();

    }
}
