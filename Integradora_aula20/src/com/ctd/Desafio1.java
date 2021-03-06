package com.ctd;

import com.ctd.model.Empregado;
import com.ctd.model.Empresa;

import java.io.*;

public class Desafio1 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Empresa empresa = new Empresa("13541651311", "TI comunicações");

        empresa.addEmpregados(new Empregado("jorge", "borges", "1245865", 3500.00));
        empresa.addEmpregados(new Empregado("Lais", "gonçales", "8465135", 4500.00));
        empresa.addEmpregados(new Empregado("Keu", "Bar", "7846651", 1300.00));
        empresa.addEmpregados(new Empregado("Lara", "Menezes", "894134", 2150.00));

        /*Salvar o objeto em um arquivo*/
        FileOutputStream fo = new FileOutputStream("listaDePaginas.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fo);
        oos.writeObject(empresa);


        /*Recuperar o objeto de um arquivo*/
        FileInputStream fi = new FileInputStream("listaDePaginas.txt");
        ObjectInputStream ois = new ObjectInputStream(fi);

        System.out.println(ois.readObject());

        ois.close();
    }
}
