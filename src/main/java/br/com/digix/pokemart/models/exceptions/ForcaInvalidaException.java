package br.com.digix.pokemart.models.exceptions;

public class ForcaInvalidaException extends Exception {

    public ForcaInvalidaException() {
        super("A Forca nao pode ser menor que zero.");
    }
    
}
