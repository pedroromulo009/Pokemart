package br.com.digix.pokemart.models;

public class NaoPossuiAtaqueException extends Exception {

    public NaoPossuiAtaqueException() {
        super("O pokemon deve possuir um ataque");
    }
    
}
