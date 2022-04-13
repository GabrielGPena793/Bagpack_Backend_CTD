package br.com.dh.ctd.ecommerce.service.exceptions;

public class SourceNotFound extends RuntimeException{

    public SourceNotFound(String message) {
        super(message);
    }
}
