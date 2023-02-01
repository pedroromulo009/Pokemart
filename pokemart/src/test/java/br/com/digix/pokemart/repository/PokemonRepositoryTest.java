package br.com.digix.pokemart.repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.digix.pokemart.builders.PokemonBuilder;
import br.com.digix.pokemart.models.AcuraciaInvalidaException;
import br.com.digix.pokemart.models.AlturaInvalidaException;
import br.com.digix.pokemart.models.FelicidadeInvalidaException;
import br.com.digix.pokemart.models.ForcaInvalidaException;
import br.com.digix.pokemart.models.NaoPossuiAtaqueException;
import br.com.digix.pokemart.models.NivelInvalidaException;
import br.com.digix.pokemart.models.PesoInvalidaException;
import br.com.digix.pokemart.models.Pokemon;
import br.com.digix.pokemart.models.QuantidadeDeAtaquesInvalidaException;
import br.com.digix.pokemart.models.QuantidadesDeTiposInvalidaException;
import br.com.digix.pokemart.models.VelocidadeInvalidaException;

@DataJpaTest
public class PokemonRepositoryTest { 
    @Autowired
    private PokemonRepository pokemonRepository;

    @Test
    public void deve_salvar_um_pokemon() throws FelicidadeInvalidaException, AlturaInvalidaException, PesoInvalidaException, NivelInvalidaException, NaoPossuiAtaqueException, QuantidadeDeAtaquesInvalidaException, QuantidadesDeTiposInvalidaException, VelocidadeInvalidaException, AcuraciaInvalidaException, ForcaInvalidaException, IOException {
        Pokemon pokemon = new PokemonBuilder().construir();

        pokemonRepository.save(pokemon);

        Assertions.assertNotNull(pokemon.getId());


    }


    @Test
    public void deve_deletar_um_pokemon() throws FelicidadeInvalidaException, AlturaInvalidaException, PesoInvalidaException, NivelInvalidaException, NaoPossuiAtaqueException, QuantidadeDeAtaquesInvalidaException, QuantidadesDeTiposInvalidaException, VelocidadeInvalidaException, AcuraciaInvalidaException, ForcaInvalidaException, IOException {
        Pokemon pokemon = new PokemonBuilder().construir();
        pokemonRepository.save(pokemon);

        pokemonRepository.deleteById(pokemon.getId());

        Optional<Pokemon> pokemonBuscado = pokemonRepository.findById(pokemon.getId());
        Assertions.assertFalse(pokemonBuscado.isPresent());

    }

    @Test
    public void deve_buscar_por_nome() throws FelicidadeInvalidaException, AlturaInvalidaException, PesoInvalidaException, NivelInvalidaException, NaoPossuiAtaqueException, QuantidadeDeAtaquesInvalidaException, QuantidadesDeTiposInvalidaException, VelocidadeInvalidaException, AcuraciaInvalidaException, ForcaInvalidaException, IOException {
        String nome = "Pikachu";
        Pokemon pokemon = new PokemonBuilder().comNome(nome).construir();
        pokemonRepository.save(pokemon);

        List<Pokemon> pokemonRetornado = pokemonRepository.findByNomeContainingIgnoreCase(nome);
        
        Assertions.assertTrue(pokemonRetornado.contains(pokemon));
    }
    
}
