package br.com.digix.pokemart.models;

public class NivelInvalidoException extends Exception {

    public NivelInvalidoException() {
        super("O Nivel nao pode ser menor que um.");
    }
    
}
