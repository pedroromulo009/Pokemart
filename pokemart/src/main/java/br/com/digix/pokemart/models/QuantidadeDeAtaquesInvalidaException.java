package br.com.digix.pokemart.models;

public class QuantidadeDeAtaquesInvalidaException extends Exception {

    public QuantidadeDeAtaquesInvalidaException() {
        super("Nao pode ter mais que quatro ataques");
    }
    
}
