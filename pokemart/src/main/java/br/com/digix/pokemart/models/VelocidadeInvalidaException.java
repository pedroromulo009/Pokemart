package br.com.digix.pokemart.models;

public class VelocidadeInvalidaException extends Exception {

    public VelocidadeInvalidaException() {
        super("Verificar se a velociade e menor que zero");
    }
    
    
}
