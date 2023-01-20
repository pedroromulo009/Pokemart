package br.com.digix.pokemart.models;

import java.beans.Transient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PokemonTest {
    @Test
    public void deve_criar_um_pokemon() throws FelicidadeInvalidaException, AlturaInvalidaException, PesoInvalidaException, NivelInvalidaException {
        // arrange
        String nome = "Pikachu";
        char genero = 'F';
        float altura = 0.3f;
        float peso = 2f;
        int felicidade = 70;
        int nivel = 5;

        // Action
        Pokemon pokemon = new Pokemon(nome, genero, altura, peso, felicidade, nivel);
        
        // Assertion
        Assertions.assertEquals(nome , pokemon.getNome());
        Assertions.assertEquals(genero, pokemon.getGenero());
        Assertions.assertEquals(altura, pokemon.getAltura());
        Assertions.assertEquals(peso, pokemon.getPeso());
        Assertions.assertEquals(felicidade, pokemon.getFelicidade());
        Assertions.assertEquals(nivel, pokemon.getNivel());


    }

    @Test 
    public void nao_deve_ter_felicidade_menor_que_zero() {
        // arrange
        String nome = "Pikachu";
        char genero = 'F';
        float altura = 0.3f;
        float peso = 2.1f;
        int felicidade = -1;
        int nivel = 5;

        // Action & Assert
        Assertions.assertThrows(FelicidadeInvalidaException.class,()->{
            new Pokemon(nome, genero, altura, peso, felicidade, nivel);
        });

        

    }
    @Test 
    public void nao_deve_ter_felicidade_acima_de_cem() {
        // arrange
        String nome = "Pikachu";
        char genero = 'F';
        float altura = 0.3f;
        float peso = 2.1f;
        int felicidade = 101;
        int nivel = 5;

        // Action & Assert
        Assertions.assertThrows(FelicidadeInvalidaException.class,()->{
            new Pokemon(nome, genero, altura, peso, felicidade, nivel);
        });


    }

    
    @Test
    public void altura_nao_deve_ser_menor_que_zero() {
        // arrange
        String nome = "Pikachu";
        char genero = 'F';
        float altura = -3f;
        float peso = 2.1f;
        int felicidade = 70;
        int nivel = 5;

        //action & Assert
        Assertions.assertThrows(AlturaInvalidaException.class,()->{
            new Pokemon(nome, genero, altura, peso, felicidade, nivel);
        });

    }
    
    
    @Test 
    public void peso_nao_pode_ser_menor_que_zero() {
        //arrange
        String nome = "Pikachu";
        char genero = 'F';
        float altura = 0.3f;
        float peso = -2.1f;
        int felicidade = 70;
        int nivel = 5;

        //action & Assert
        Assertions.assertThrows(PesoInvalidaException.class,()->{
            new Pokemon(nome, genero, altura, peso, felicidade, nivel);
        });

    }

    
    @Test 
    public void nivel_nao_pode_ser_menor_que_um() {
        //arrange
        String nome = "Pikachu";
        char genero = 'F';
        float altura = 0.3f;
        float peso = 2.1f;
        int felicidade = 70;
        int nivel = -1;

        //action & Assert
        Assertions.assertThrows(NivelInvalidaException.class,()->{
            new Pokemon(nome, genero, altura, peso, felicidade, nivel);
        });

    }
    @Test 
    public void nivel_nao_pode_ser_maior_que_cem() {
        //arrange
        String nome = "Pikachu";
        char genero = 'F';
        float altura = 0.3f;
        float peso = 2.1f;
        int felicidade = 70;
        int nivel = 101;

        //action & Assert
        Assertions.assertThrows(NivelInvalidaException.class,()->{
            new Pokemon(nome, genero, altura, peso, felicidade, nivel);
        });

    }




}