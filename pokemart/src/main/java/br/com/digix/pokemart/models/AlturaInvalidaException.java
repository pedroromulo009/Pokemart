package br.com.digix.pokemart.models;

public class AlturaInvalidaException extends Exception {
    
    public AlturaInvalidaException() {
        super("A altura nao pode ser menor que 0");

    }
    
}
