package br.com.digix.pokemart.builders;

import java.io.IOException;

import br.com.digix.pokemart.models.AcuraciaInvalidaException;
import br.com.digix.pokemart.models.Ataque;
import br.com.digix.pokemart.models.Categoria;
import br.com.digix.pokemart.models.ForcaInvalidaException;

import br.com.digix.pokemart.models.Tipos;

public class AtaqueBuilder {
    private int forca = 40;
    private Categoria categoria = Categoria.FISICO;
    private int acuracia= 100;
    private String nome = "Chamas da paixao";
    private String descricao = "Deixa o nimigo apaixonado";
    private int pontosDePoder = 15;
    private Tipos tipos;

    

    public AtaqueBuilder() throws IOException {
        this.tipos = new TiposBuilder().construir();
    }

    public Ataque construir() throws AcuraciaInvalidaException, ForcaInvalidaException {
        return new Ataque(forca, categoria, acuracia, nome, descricao, pontosDePoder, tipos);
    }

    public AtaqueBuilder comAcuracia(int acuracia) {
        this.acuracia = acuracia;
        return this;
    }

    public AtaqueBuilder comForca(int forca) {
        this.forca = forca;
        return this;
    }

    public AtaqueBuilder comTipos(Tipos tipos) {
        this.tipos = tipos;
        return this;
    }

    public AtaqueBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }
    
}
