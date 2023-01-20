package br.com.digix.pokemart.models;

import lombok.Getter;

@Getter
public class Pokemon {

    private String nome;
    private char genero;
    private float altura;
    private float peso;
    private int felicidade;
    private int nivel;

    public Pokemon(String nome, char genero, float altura, float peso, int felicidade, int nivel) throws FelicidadeInvalidaException, AlturaInvalidaException, PesoInvalidaException, NivelInvalidaException {
        
        if(felicidade < 0) {
            throw new FelicidadeInvalidaException();
        }
        if(felicidade > 100) {
            throw new FelicidadeInvalidaException();
        }
        
        
        if(altura < 0) {
            throw new AlturaInvalidaException();
        }


        if(peso < 0) {
            throw new PesoInvalidaException();
        }

        
        if(nivel < 0) {
            throw new NivelInvalidaException();
        }
        if(nivel > 100) {
            throw new NivelInvalidaException();
        }
    
        



        this.nome = nome;
        this.genero = genero;
        this.altura = altura;
        this.peso = peso;
        this.felicidade = felicidade;
        this.nivel = nivel;
    }
    

    

    







}
    

