package br.com.digix.pokemart.models;

public class ForcaInvalidaException extends Exception {
    public ForcaInvalidaException() {
        super("A forca nao pode ser menor que zero");
    }
    
}
