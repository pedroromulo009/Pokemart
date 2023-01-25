package br.com.digix.pokemart.models.exceptions;

public class FelicidadeInvalidaException extends Exception {

    public FelicidadeInvalidaException() {
        super("A felicidade deve estar entre 0 e 100");
    }
    
}
