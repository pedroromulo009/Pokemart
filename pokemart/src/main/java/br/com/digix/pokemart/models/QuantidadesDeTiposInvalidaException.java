package br.com.digix.pokemart.models;

public class QuantidadesDeTiposInvalidaException extends Exception {
    public QuantidadesDeTiposInvalidaException() {
        super("Nao deve ter mais que dois tipos");
    }

}
