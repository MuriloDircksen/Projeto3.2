package br.futurodev.projeto.dto;

import br.futurodev.projeto.ENUM.Status;
import br.futurodev.projeto.model.Categoria;

public class ProdutoRepresentationModel {

    private Long id;
    private String nomeCategoria;
    private String nomeProduto;
    private Double precoProduto;
    private Status statusProduto;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public Status getStatusProduto() {
        return statusProduto;
    }

    public void setStatusProduto(Status statusProduto) {
        this.statusProduto = statusProduto;
    }
}
