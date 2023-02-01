package br.com.digix.pokemart.models;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.digix.pokemart.builders.AtaqueBuilder;
import br.com.digix.pokemart.builders.PokemonBuilder;
import br.com.digix.pokemart.builders.TiposBuilder;


public class PokemonTest {
    @Test
    public void deve_criar_um_pokemon() throws FelicidadeInvalidaException, AlturaInvalidaException,
            PesoInvalidaException, NivelInvalidaException, NaoPossuiAtaqueException, AcuraciaInvalidaException,
            ForcaInvalidaException, QuantidadeDeAtaquesInvalidaException, IOException, QuantidadesDeTiposInvalidaException, VelocidadeInvalidaException{
        // arrange
        String nome = "Pikachu";
        char genero = 'F';
        float altura = 0.3f;
        float peso = 2f;
        int felicidade = 70;
        int nivel = 5;
        int velocidade = 10;

        // Action
        Pokemon pokemon = new PokemonBuilder().construir();

        // Assertion
        Assertions.assertEquals(nome, pokemon.getNome());
        Assertions.assertEquals(genero, pokemon.getGenero());
        Assertions.assertEquals(altura, pokemon.getAltura());
        Assertions.assertEquals(peso, pokemon.getPeso());
        Assertions.assertEquals(felicidade, pokemon.getFelicidade());
        Assertions.assertEquals(nivel, pokemon.getNivel());
        Assertions.assertEquals(velocidade, pokemon.getVelocidade());

    }

    @Test
    public void nao_deve_ter_felicidade_menor_que_zero() {
        // Arrange, Action & Assert
        Assertions.assertThrows(FelicidadeInvalidaException.class, () -> {
            new PokemonBuilder().comFelicidade(-1).construir();
        });
    }

    @Test
    public void nao_deve_ter_felicidade_acima_de_cem() {

        // Arrange, Action & Assert
        Assertions.assertThrows(FelicidadeInvalidaException.class, () -> {
            new PokemonBuilder().comFelicidade(101).construir();
        });
    }

    @Test
    public void altura_nao_deve_ser_menor_que_zero() {

        // Arrange, Action & Assert
        Assertions.assertThrows(AlturaInvalidaException.class, () -> {
            new PokemonBuilder().comAltura(-1).construir();
        });

    }

    @Test
    public void peso_nao_pode_ser_menor_que_zero() {

        // Arrange, Action & Assert
        Assertions.assertThrows(PesoInvalidaException.class, () -> {
            new PokemonBuilder().comPeso(-1).construir();

        });
    }

    @Test
    public void nivel_nao_pode_ser_menor_que_um() {

        // Arrange, Action & Assert
        Assertions.assertThrows(NivelInvalidaException.class, () -> {
            new PokemonBuilder().comNivel(-1).construir();
        });
    }

    @Test
    public void nivel_nao_pode_ser_maior_que_cem() {

        // Arrange, Action & Assert
        Assertions.assertThrows(NivelInvalidaException.class, () -> {
            new PokemonBuilder().comNivel(101).construir();
        });

    }

    @Test
    public void deve_pelo_menos_ter_um_ataque() throws Exception {
        // Arrange


        // Action
        Assertions.assertThrows(NaoPossuiAtaqueException.class, () -> {
            new PokemonBuilder().semAtaque().construir();

        });
    }

    @Test
    public void deve_poder_ter_quatro_ataques() throws Exception {
        // Arrange
        Ataque ataque1 = new AtaqueBuilder().construir();
        Ataque ataque2 = new AtaqueBuilder().construir();
        Ataque ataque3 = new AtaqueBuilder().construir();
        Ataque ataque4 = new AtaqueBuilder().construir();
        List<Ataque> ataques = new ArrayList<>();
        ataques.add(ataque1);
        ataques.add(ataque2);
        ataques.add(ataque3);
        ataques.add(ataque4);

        // Action
        Pokemon pokemon = new PokemonBuilder().comAtaques(ataques).construir();

        // Assertion
        Assertions.assertTrue(ataques.containsAll(pokemon.getAtaques()));

    }

    @Test
    public void nao_deve_possuir_mais_que_quatro_ataques() throws Exception {
        // Arrange
        List<Ataque> ataques = new ArrayList<>();
        ataques.add(new AtaqueBuilder().construir());
        ataques.add(new AtaqueBuilder().construir());
        ataques.add(new AtaqueBuilder().construir());
        ataques.add(new AtaqueBuilder().construir());
        ataques.add(new AtaqueBuilder().construir());

        // Action & Assert
        Assertions.assertThrows(QuantidadeDeAtaquesInvalidaException.class, () -> {
            new PokemonBuilder().comAtaques(ataques).construir();
        });
    }

    @Test
    public void deve_poder_ter_dois_tipos() throws Exception {
        // Arrange
        Tipos tipos1 = new TiposBuilder().construir();
        Tipos tipos2 = new TiposBuilder().construir();
        List<Tipos> tipos = new ArrayList<>();
        tipos.add(tipos1);
        tipos.add(tipos2);

        // Action 
        Pokemon pokemon = new PokemonBuilder().comTipos(tipos).construir();

        // Asserion
        Assertions.assertTrue(tipos.containsAll(pokemon.getTipos()));
    
    }

    @Test
    public void nao_deve_possuir_mais_que_dois_tipos() throws Exception {
        // Arrange
        List<Tipos> tipos = new ArrayList<>();
        tipos.add(new TiposBuilder().construir());
        tipos.add(new TiposBuilder().construir());
        tipos.add(new TiposBuilder().construir());

        // Action & Assert
        Assertions.assertThrows(QuantidadesDeTiposInvalidaException.class, () -> {
            new PokemonBuilder().comTipos(tipos).construir();
        });

    }

    @Test
    public void nao_ter_velocidade_menor_que_um() {
        // Arrange, Action & Assert
        Assertions.assertThrows(VelocidadeInvalidaException.class, () -> {
            new PokemonBuilder().comVelocidade(-1).construir();
        });
    

    }
    
}