package br.com.digix.pokemart.builders;

import br.com.digix.pokemart.models.Ataque;
import br.com.digix.pokemart.models.enums.Categoria;
import br.com.digix.pokemart.models.exceptions.AcuraciaInvalidaException;
import br.com.digix.pokemart.models.exceptions.ForcaInvalidaException;

public class AtaqueBuilder {
    int forca = 40;
    Categoria categoria = Categoria.FISICO;
    int acuracia = 100;
    String nome = "Chamas da paixao";
    String descricao = "Deixa o inimigo apaixonado";
    int pontosDePoder = 15;

    public Ataque construir() throws AcuraciaInvalidaException, ForcaInvalidaException {
        return new Ataque(forca, categoria, acuracia, nome, descricao, pontosDePoder);
    }

    public AtaqueBuilder comAcuracia(int acuracia) {
        this.acuracia = acuracia;
        return this;
    }

    public AtaqueBuilder comForca(int forca) {
        this.forca = forca;
        return this;
    }

}
