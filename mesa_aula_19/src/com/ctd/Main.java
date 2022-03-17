package com.ctd;

import com.ctd.model.Contato;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Contato c1 = new Contato("jorge", "jorge@gmail.com", "5521454661");
        Contato c2 = new Contato("Maria", "Maria@gmail.com", "84166615444");
        Contato c3 = new Contato("Lia", "Lia@gmail.com", "84914134777");

        List<Contato> contatos = Arrays.asList(c1, c2, c3);

        /*Salvar o objeto em um arquivo*/
        FileOutputStream fo = new FileOutputStream("listaDeContatos.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fo);
        oos.writeObject(contatos);


        /*Recuperar o objeto de um arquivo*/
        FileInputStream fi = new FileInputStream("listaDeContatos.txt");
        ObjectInputStream ois = new ObjectInputStream(fi);

        System.out.println(ois.readObject());

        ois.close();

    }
}
