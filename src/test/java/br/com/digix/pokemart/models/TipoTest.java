package br.com.digix.pokemart.models;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.digix.pokemart.builders.TipoBuilder;
import br.com.digix.pokemart.utils.ArquivoUtils;

public class TipoTest {

    private byte[] icone;

    @BeforeEach
    public void carregarIcone() throws IOException {
        this.icone = ArquivoUtils.abrirArquivo("src\\test\\java\\br\\com\\digix\\pokemart\\icons\\Pokemon_Type_Icon_Water.svg");
    }

    @Test 
    public void deve_criar_um_tipo() throws FileNotFoundException, IOException {
        // Arrange
        String nome = "Water";
        String cor = "#4592c4";
        byte[] simbolo = this.icone;

        // Action
        Tipo tipo = new TipoBuilder().construir();

        // Assert
        Assertions.assertEquals(nome, tipo.getNome());
        Assertions.assertEquals(cor, tipo.getCor());
        Assertions.assertEquals(Arrays.toString(simbolo), Arrays.toString(tipo.getSimbolo()));
    }
}
