package br.com.digix.pokemart.models.exceptions;

public class PesoInvalidoException extends Exception {

    public PesoInvalidoException() {
        super("O Peso nao pode ser menor que zero.");
    }
    
}
