package br.com.digix.pokemart.models;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.io.IOException;
import java.util.Arrays;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.digix.pokemart.builders.TiposBuilder;
import br.com.digix.pokemart.utils.ArquivoUtils;

public class TiposTest {
    
    private byte[] icone;

    @BeforeEach
    public void carregarIcone() throws IOException {
        this.icone = ArquivoUtils.abrirArquivo("src\\test\\java\\br\\com\\digix\\pokemart\\icons\\Pokemon_Type_Icon_Electric.png");
        


    }
    
    @Test
    public void deve_criar_um_tipo() throws IOException {

        // Arrange
        String nome = "Electric";
        String cor = "#eed535";
        byte[] simbolo = this.icone;


        // Action
        Tipos tipos = new TiposBuilder().construir();

        // Assertions
        assertEquals(nome, tipos.getNome());
        assertEquals(cor, tipos.getCor());
        assertEquals(Arrays.toString(simbolo), Arrays.toString(tipos.getSimbolo()));
    
    }

    

    
}
