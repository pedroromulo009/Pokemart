package br.com.digix.pokemart.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.digix.pokemart.models.Pokemon;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, Long> {
    List<Pokemon> findByNomeContainingIgnoreCase(String nome);
    
}
