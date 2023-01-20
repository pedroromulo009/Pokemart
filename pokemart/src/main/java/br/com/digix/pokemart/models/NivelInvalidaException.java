package br.com.digix.pokemart.models;

public class NivelInvalidaException extends Exception {
    public NivelInvalidaException() {
        super("Nivel deve estar em 0 e 100");
    }
    
}
