package br.com.digix.pokemart.repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.digix.pokemart.builders.TiposBuilder;
import br.com.digix.pokemart.models.Tipos;


@DataJpaTest
public class TiposRepositoryTest {
    @Autowired
    private TiposRepository tiposRepository;


    @Test
    public void deve_salvar_um_tipo() throws IOException {
        // Arrange
        Tipos tipos = new TiposBuilder().construir();

        // Action
        tiposRepository.save(tipos);

        //
        Assertions.assertNotNull(tipos.getId());
        System.out.println(tipos.getId());
    }

    @Test 
    public void deve_remover_um_tipo_cadastrado() throws IOException {
        Tipos tipos = new TiposBuilder().construir();
        tiposRepository.save(tipos);

        tiposRepository.deleteById(tipos.getId());

        Optional<Tipos> tiposBuscado = tiposRepository.findById(tipos.getId());
        Assertions.assertFalse(tiposBuscado.isPresent());

    }

    @Test
    public void deve_buscar_pelo_nome() throws IOException {
        String nome = "Electric";
        Tipos tipos = new TiposBuilder().comNome(nome).construir();
        tiposRepository.save(tipos);

        List<Tipos> TiposRetornado = tiposRepository.findByNomeContainingIgnoreCase(nome);
        
        Assertions.assertTrue(TiposRetornado.contains(tipos));


    }
    
}
