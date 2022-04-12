package br.com.dh.ctd.ecommerce.service.exceptions;

public class EntitieNotFound extends RuntimeException{

    public EntitieNotFound(String message) {
        super(message);
    }
}
