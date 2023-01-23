package br.com.digix.pokemart.models;

public class PesoInvalidoException extends Exception {

    public PesoInvalidoException() {
        super("O Peso nao pode ser menor que zero.");
    }
    
}
