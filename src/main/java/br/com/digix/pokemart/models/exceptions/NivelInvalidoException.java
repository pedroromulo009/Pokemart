package br.com.digix.pokemart.models.exceptions;

public class NivelInvalidoException extends Exception {

    public NivelInvalidoException() {
        super("O Nivel deve estar entre um e cem.");
    }
    
}
