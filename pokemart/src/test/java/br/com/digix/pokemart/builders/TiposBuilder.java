package br.com.digix.pokemart.builders;

import java.io.IOException;

import br.com.digix.pokemart.models.Tipos;
import br.com.digix.pokemart.utils.ArquivoUtils;

public class TiposBuilder {
    private String nome = "Electric";
    private String cor = "#eed535";
    private byte[] simbolo;
    
    public TiposBuilder() throws IOException {
        this.simbolo = ArquivoUtils.abrirArquivo("src\\test\\java\\br\\com\\digix\\pokemart\\icons\\Pokemon_Type_Icon_Electric.png");
    }

    public Tipos construir() {
        
        return new Tipos(nome, cor, simbolo);
    }

    public TiposBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }
}
