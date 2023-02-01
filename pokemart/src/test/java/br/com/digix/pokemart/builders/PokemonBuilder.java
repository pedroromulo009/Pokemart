package br.com.digix.pokemart.builders;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.digix.pokemart.models.AcuraciaInvalidaException;
import br.com.digix.pokemart.models.AlturaInvalidaException;
import br.com.digix.pokemart.models.Ataque;
import br.com.digix.pokemart.models.FelicidadeInvalidaException;
import br.com.digix.pokemart.models.ForcaInvalidaException;
import br.com.digix.pokemart.models.NaoPossuiAtaqueException;
import br.com.digix.pokemart.models.NivelInvalidaException;
import br.com.digix.pokemart.models.PesoInvalidaException;
import br.com.digix.pokemart.models.Pokemon;
import br.com.digix.pokemart.models.QuantidadeDeAtaquesInvalidaException;
import br.com.digix.pokemart.models.QuantidadesDeTiposInvalidaException;
import br.com.digix.pokemart.models.Tipos;
import br.com.digix.pokemart.models.VelocidadeInvalidaException;


public class PokemonBuilder {

    private String nome = "Pikachu";
    private char genero = 'F';
    private float altura = 0.3f;
    private float peso = 2f;
    private int felicidade = 70;
    private int nivel = 5;
    private List<Ataque> ataques = new ArrayList<>();
    private List<Tipos> tipos = new ArrayList<>();
    private int velocidade = 10;
    

    public PokemonBuilder() throws FelicidadeInvalidaException, AlturaInvalidaException, PesoInvalidaException, NivelInvalidaException, AcuraciaInvalidaException, ForcaInvalidaException  , QuantidadeDeAtaquesInvalidaException, IOException, QuantidadesDeTiposInvalidaException {
    this.ataques.add(new AtaqueBuilder().construir());
    this.tipos.add(new TiposBuilder().construir());
}

    public Pokemon construir() throws FelicidadeInvalidaException, AlturaInvalidaException, PesoInvalidaException, NivelInvalidaException, NaoPossuiAtaqueException, QuantidadeDeAtaquesInvalidaException, QuantidadesDeTiposInvalidaException, VelocidadeInvalidaException {
        return new Pokemon(nome, genero, altura, peso, felicidade, nivel, ataques, tipos, velocidade);
    }

    public PokemonBuilder comFelicidade(int felicidade)  {
        this.felicidade = felicidade;
        return this;
    }

    public PokemonBuilder comAltura(float altura) {
        this.altura = altura;
        return this;
    }

    public PokemonBuilder comPeso(float peso) {
        this.peso = peso;
        return this;
    }

    public PokemonBuilder comNivel(int nivel) {
        this.nivel = nivel;
        return this;
    }

    public PokemonBuilder semAtaque() {
        this.ataques = new ArrayList<>();
        return this;
    }

    

    public PokemonBuilder comAtaques(List<Ataque> ataques) {
        this.ataques = ataques;
        return this;
    }

    public PokemonBuilder comTipos(List<Tipos> tipos) {
        this.tipos = tipos;
        return this;
    }


    public PokemonBuilder comVelocidade(int velocidade) {
        this.velocidade = velocidade;
        return this;
    }
    

    

    




}
