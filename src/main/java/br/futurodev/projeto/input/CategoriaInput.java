package br.futurodev.projeto.input;

import br.futurodev.projeto.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class CategoriaInput {
    private Long id;
    private String nomeCategoria;
    private String descricaoCategoria;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getDescricaoCategoria() {
        return descricaoCategoria;
    }

    public void setDescricaoCategoria(String descricaoCategoria) {
        this.descricaoCategoria = descricaoCategoria;
    }


}
