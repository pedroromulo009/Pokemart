package br.com.digix.pokemart.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor
public class Ataque {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int forca;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private int acuracia;
    private String nome;
    private String descricao;
    private int pontosDePoder;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Tipos tipos;

    public Ataque(int forca, Categoria categoria, int acuracia, String nome, String descricao, int pontosDePoder, Tipos tipos) throws AcuraciaInvalidaException, ForcaInvalidaException {
        
        if(acuracia < 0) {
            throw new AcuraciaInvalidaException();
        }
        if(acuracia > 100) {
            throw new AcuraciaInvalidaException();
        }


        if(forca < 0) {
            throw new ForcaInvalidaException();
        }

        
        this.forca = forca;
        this.categoria = categoria;
        this.acuracia = acuracia;
        this.nome = nome;
        this.descricao = descricao;
        this.pontosDePoder = pontosDePoder;
        this.tipos = tipos; 
    }

    
    
}
