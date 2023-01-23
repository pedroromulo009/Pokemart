package br.com.digix.pokemart.models.exceptions;

public class AcuraciaInvalidaException extends Exception {

    public AcuraciaInvalidaException() {
        super("A Acuracia deve estar entre zero e cem.");
    }
    
}
