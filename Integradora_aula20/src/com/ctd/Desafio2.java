package com.ctd;

import com.ctd.model.Empregado;
import com.ctd.model.Empresa;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Desafio2 {

    public static void main(String[] args) {
        Empresa empresa = new Empresa("13541651311", "TI comunicações");

        empresa.addEmpregados(new Empregado("jorge", "borges", "1245865", 3500.00));
        empresa.addEmpregados(new Empregado("Lais", "gonçales", "8465135", 4500.00));
        empresa.addEmpregados(new Empregado("Keu", "Bar", "7846651", 1300.00));
        empresa.addEmpregados(new Empregado("Lara", "Menezes", "894134", 2150.00));


        String path = "out.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Empregado empregado : empresa.getEmpregados()) {
                bw.write(String.valueOf(empregado));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
