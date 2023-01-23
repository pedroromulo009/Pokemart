package br.com.digix.pokemart.models;

import br.com.digix.pokemart.models.exceptions.AlturaInvalidaException;
import br.com.digix.pokemart.models.exceptions.FelicidadeInvalidaException;
import br.com.digix.pokemart.models.exceptions.NaoPossuiAtaqueException;
import br.com.digix.pokemart.models.exceptions.NivelInvalidoException;
import br.com.digix.pokemart.models.exceptions.PesoInvalidoException;
import lombok.Getter;

@Getter
public class Pokemon {

    private String nome;
    private char genero;
    private float altura;
    private float peso;
    private int felicidade;
    private int nivel;
    private Ataque ataque;

    public Pokemon(String nome, char genero, float altura, float peso, int felicidade, int nivel, Ataque ataque) throws FelicidadeInvalidaException, AlturaInvalidaException, PesoInvalidoException, NivelInvalidoException, NaoPossuiAtaqueException {
        verificarFelicidadeEntreZeroECem(felicidade);
        verificarAlturaMenorQueZero(altura);
        verificarPesoMenorQueZero(peso);
        verificarNivelEntreZeroEUm(nivel);
        verificarSePossuiAoMenosUmAtaque(ataque);
        this.ataque = ataque;
        this.nome = nome;
        this.genero = genero;
        this.altura = altura;
        this.peso = peso;
        this.felicidade = felicidade;
        this.nivel = nivel;
    }

    private void verificarSePossuiAoMenosUmAtaque(Ataque ataque) throws NaoPossuiAtaqueException {
        if(ataque == null) {
            throw new NaoPossuiAtaqueException();
        }
    }

    private void verificarNivelEntreZeroEUm(int nivel) throws NivelInvalidoException {
        if(nivel < 1 || nivel > 100) {
            throw new NivelInvalidoException();
        }
    }

    private void verificarPesoMenorQueZero(float peso) throws PesoInvalidoException {
        if(peso < 0) {
            throw new PesoInvalidoException();
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
    
}
