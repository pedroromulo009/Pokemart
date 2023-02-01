package br.com.digix.pokemart.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.digix.pokemart.models.Tipos;

@Repository
public interface TiposRepository extends CrudRepository <Tipos, Long>{
    public List<Tipos> findByNomeContainingIgnoreCase(String nome);
    
}
