package br.com.digix.pokemart.models;

public class PesoInvalidaException extends Exception {

    public PesoInvalidaException() {
        super("Peso nao pode ser menor que 0");
    }
}
