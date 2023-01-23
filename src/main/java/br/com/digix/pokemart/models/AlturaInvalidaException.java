package br.com.digix.pokemart.models;

public class AlturaInvalidaException extends Exception {

    public AlturaInvalidaException() {
        super("A Altura nao pode ser menor que zero.");
    }
    
}
