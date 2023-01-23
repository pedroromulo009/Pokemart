package br.com.digix.pokemart.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.digix.pokemart.builders.PokemonBuilder;

public class PokemonTest {

    @Test
    public void deve_criar_um_pokemon() throws FelicidadeInvalidaException, AlturaInvalidaException, PesoInvalidoException, NivelInvalidoException {
        // Arrange
        String nome = "Pikachu";
        char genero = 'F';
        float altura = 0.3f;
        float peso = 2.1f;
        int felicidade = 100;
        int nivel = 5;

        // Action
        Pokemon pokemon = new PokemonBuilder().construir();

        // Assertion
        Assertions.assertEquals(nome, pokemon.getNome());
        Assertions.assertEquals(genero, pokemon.getGenero());
        Assertions.assertEquals(altura, pokemon.getAltura());
        Assertions.assertEquals(peso, pokemon.getPeso());
        Assertions.assertEquals(felicidade, pokemon.getFelicidade());
        Assertions.assertEquals(nivel, pokemon.getNivel());
    } 

    @Test
    public void nao_deve_ter_felicidade_menor_que_zero() {
        // Arrange, Action & Assert
        Assertions.assertThrows(FelicidadeInvalidaException.class, 
        ()->{ 
            new PokemonBuilder().comFelicidade(-1).construir();
        });
    }

    @Test
    public void nao_deve_ter_felicidade_acima_de_cem() {
        // Arrange, Action & Assert
        Assertions.assertThrows(FelicidadeInvalidaException.class, 
        ()->{ 
            new PokemonBuilder().comFelicidade(101).construir();
        });
    }

    @Test
    public void nao_deve_ter_altura_menor_que_zero() {
        Assertions.assertThrows(AlturaInvalidaException.class, 
        ()-> {
            new PokemonBuilder().comAltura(-0.1f).construir();
        });
    }

    @Test
    public void nao_deve_ter_peso_menor_que_zero() {
        Assertions.assertThrows(PesoInvalidoException.class, 
        ()-> {
            new PokemonBuilder().comPeso(-0.1f).construir();
        });
    }

    @Test
    public void nao_deve_ter_nivel_menor_que_um() {
        Assertions.assertThrows(NivelInvalidoException.class, 
        ()-> {
            new PokemonBuilder().comNivel(0).construir();
        });
    }

    @Test
    public void nao_deve_ter_nivel_maior_que_cem() {
        Assertions.assertThrows(NivelInvalidoException.class, 
        ()-> {
            new PokemonBuilder().comNivel(101).construir();
        });
    }
}