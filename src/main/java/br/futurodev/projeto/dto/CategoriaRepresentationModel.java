package br.futurodev.projeto.dto;

import br.futurodev.projeto.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class CategoriaRepresentationModel {

    private Long id;
    private String nomeCategoria;
    private String descricaoCategoria;
    private List<Produto> produtos = new ArrayList<Produto>();

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

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
