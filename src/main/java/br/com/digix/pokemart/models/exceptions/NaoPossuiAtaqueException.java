package br.com.digix.pokemart.models.exceptions;

public class NaoPossuiAtaqueException extends Exception {

    public NaoPossuiAtaqueException() {
        super("O Pokemon deve possuir pelo menos um ataque.");
    }
    
}
