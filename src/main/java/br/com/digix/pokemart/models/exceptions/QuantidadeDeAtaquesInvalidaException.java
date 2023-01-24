package br.com.digix.pokemart.models.exceptions;

public class QuantidadeDeAtaquesInvalidaException extends Exception {

    public QuantidadeDeAtaquesInvalidaException() {
        super("Nao pode conter mais que 4 ataques.");
    }
    
}
