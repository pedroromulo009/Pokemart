package br.com.digix.pokemart.models;

public class FelicidadeInvalidaException extends Exception {

    public FelicidadeInvalidaException() {
        super("A felicidade deve estar em 0 e 100");
        
    }
    
    
}
