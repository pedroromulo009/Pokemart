package br.com.digix.pokemart.models;


import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.digix.pokemart.builders.AtaqueBuilder;
import br.com.digix.pokemart.builders.TiposBuilder;

public class AtaqueTest {
    @Test
    public void deve_criar_um_ataque() throws AcuraciaInvalidaException, ForcaInvalidaException, IOException, QuantidadesDeTiposInvalidaException{
        // Arrange
        int forca = 40;
        Categoria categoria = Categoria.FISICO;
        int acuracia= 100;
        String nome = "Chamas da paixao";
        String descricao = "Deixa o nimigo apaixonado";
        int pontosDePoder = 15;

        // Action 
        Ataque ataque = new AtaqueBuilder().construir();

        // Assertion
        Assertions.assertEquals(forca, ataque.getForca());
        Assertions.assertEquals(categoria, ataque.getCategoria());
        Assertions.assertEquals(acuracia, ataque.getAcuracia());
        Assertions.assertEquals(nome, ataque.getNome());
        Assertions.assertEquals(descricao, ataque.getDescricao());
        Assertions.assertEquals(pontosDePoder, ataque.getPontosDePoder());

    }

    @Test
    public void acuracia_nao_pode_ser_menor_que_zero() {

        // Arrange, Action & Assert
        Assertions.assertThrows(AcuraciaInvalidaException.class,()->{
            new AtaqueBuilder().comAcuracia(-1).construir();
        });
    }
    @Test
    public void acuracia_nao_pode_ser_maior_que_cem() {

        // Arrange, Action & Assert
        Assertions.assertThrows(AcuraciaInvalidaException.class,()->{
           new AtaqueBuilder().comAcuracia(101).construir();
    });
    }
    
    
    
    @Test
    public void forca_nao_pode_ser_menor_que_zero() {

        // Arrange, Action& Assert
        Assertions.assertThrows(ForcaInvalidaException.class,()->{
            new AtaqueBuilder().comForca(-3).construir();
        });
    }


    @Test
    public void deve_ter_um_tipo()
            throws IOException, AcuraciaInvalidaException, ForcaInvalidaException, QuantidadesDeTiposInvalidaException {

        Tipos tipos = new TiposBuilder().construir();

        Ataque ataque = new AtaqueBuilder().comTipos(tipos).construir();

        Assertions.assertEquals(tipos, ataque.getTipos());
    }

    








}