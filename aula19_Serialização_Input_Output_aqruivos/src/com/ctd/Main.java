package com.ctd;

import com.ctd.model.PaginasFavoritas;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        PaginasFavoritas pg1 = new PaginasFavoritas("www.google.com", "google");
        PaginasFavoritas pg2 = new PaginasFavoritas("www.youtube.com", "youtube");
        PaginasFavoritas pg3 = new PaginasFavoritas("www.instagram.com", "instagram");

        List<PaginasFavoritas> paginasFavoritas = Arrays.asList(pg1, pg2, pg3);

        /*Salvar o objeto em um arquivo*/
        FileOutputStream fo = new FileOutputStream("listaDePaginas.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fo);
        oos.writeObject(paginasFavoritas);


        /*Recuperar o objeto de um arquivo*/
        FileInputStream fi = new FileInputStream("listaDePaginas.txt");
        ObjectInputStream ois = new ObjectInputStream(fi);

        System.out.println(ois.readObject());

        ois.close();

    }
}
