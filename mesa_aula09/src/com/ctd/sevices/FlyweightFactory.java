package com.ctd.sevices;

import com.ctd.model.ClienteRoupa;

import java.util.ArrayList;
import java.util.List;

public class FlyweightFactory {

    private static final List<ClienteRoupa> tamanhoXS = new ArrayList<>();
    private static final List<ClienteRoupa> tamanhoS = new ArrayList<>();
    private static final List<ClienteRoupa> tamanhoM = new ArrayList<>();
    private static final List<ClienteRoupa> roupasImportadas = new ArrayList<>();
    private static final List<ClienteRoupa> roupasMasCondicoes = new ArrayList<>();

    public void obterRoupa(ClienteRoupa clienteRoupa){

        if (clienteRoupa.iseImportado()){

        }


    }


    public void roupasImportadas(){

        roupasImportadas.stream().


    }
}
