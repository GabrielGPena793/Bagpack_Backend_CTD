package com.ctd.services.impl;

import com.ctd.services.ISerie;

public class SerieService implements ISerie {

    // retorna o nome do filme como url, caso seja um nome que contenha espaços vai ser retirado os espaços
    @Override
    public String getSerie(String name) {
        return "www." + name.replace(" ", "") + ".com";
    }
}
