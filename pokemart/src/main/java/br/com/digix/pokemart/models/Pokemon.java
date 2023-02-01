package br.com.digix.pokemart.models;



import java.util.List;

import lombok.Getter;

@Getter
public class Pokemon {

    private String nome;
    private char genero;
    private float altura;
    private float peso;
    private int felicidade;
    private int nivel;
    private List<Ataque> ataques;
    private List<Tipos> tipos;
    private int velocidade;

    public Pokemon(String nome, char genero, float altura, float peso, int felicidade, int nivel, List<Ataque> ataques, List<Tipos> tipos, int velocidade) throws FelicidadeInvalidaException, AlturaInvalidaException, NaoPossuiAtaqueException, NivelInvalidaException, PesoInvalidaException ,QuantidadeDeAtaquesInvalidaException, QuantidadesDeTiposInvalidaException, VelocidadeInvalidaException{
        verificarFelicidadeEntreZeroECem(felicidade);
        verificarAlturaMenorQueZero(altura);
        verificarPesoMenorQueZero(peso);
        verificarNivelEntreZeroEUm(nivel);
        verificarSePossuiAoMenosUmAtaque(ataques);
        verificarAtaqueMenorQueQuatro(ataques);
        verificarSePossuiUmTipos(tipos);
        verificarSePossuiVelocidadeMenorQueUm(velocidade);
        this.ataques = ataques;
        this.nome = nome;
        this.genero = genero;
        this.altura = altura;
        this.peso = peso;
        this.felicidade = felicidade;
        this.nivel = nivel;
        this.tipos = tipos;
        this.velocidade = velocidade;
        
    }

    
    private void verificarAtaqueMenorQueQuatro(List<Ataque> ataques) throws QuantidadeDeAtaquesInvalidaException {
        if(ataques.size() > 4) {
            throw new QuantidadeDeAtaquesInvalidaException();
        }
    }

    private void verificarSePossuiAoMenosUmAtaque(List<Ataque> ataques) throws NaoPossuiAtaqueException {
        if(ataques.size() == 0) {
            throw new NaoPossuiAtaqueException();
        }
    }

    private void verificarNivelEntreZeroEUm(int nivel) throws NivelInvalidaException {
        if(nivel < 1 || nivel > 100) {
            throw new NivelInvalidaException();
        }
    }

    private void verificarPesoMenorQueZero(float peso) throws PesoInvalidaException {
        if(peso < 0) {
            throw new PesoInvalidaException();
        }
    }

    private void verificarAlturaMenorQueZero(float altura) throws AlturaInvalidaException {
        if(altura < 0) {
            throw new AlturaInvalidaException();
        }
    }

    private void verificarFelicidadeEntreZeroECem(int felicidade) throws FelicidadeInvalidaException {
        if(felicidade < 0 || felicidade > 100) {
            throw new FelicidadeInvalidaException();
        }
    }

    private void verificarSePossuiUmTipos(List<Tipos> tipos) throws QuantidadesDeTiposInvalidaException {
        if(tipos.size() < 1  || tipos.size() > 2) {
            throw new QuantidadesDeTiposInvalidaException();
        }
    }


    private void verificarSePossuiVelocidadeMenorQueUm(int velocidade) throws VelocidadeInvalidaException {
        if(velocidade < 1 ) {
            throw new VelocidadeInvalidaException();
        }
    
        
    }
    
}
    








    

