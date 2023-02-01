package br.com.digix.pokemart.models;

public class AcuraciaInvalidaException extends Exception {
    public AcuraciaInvalidaException() {
        super("A acuracia deve estar entre 0 e 100");
    }

    
}
