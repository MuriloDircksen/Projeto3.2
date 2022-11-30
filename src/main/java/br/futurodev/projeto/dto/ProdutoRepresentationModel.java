package br.futurodev.projeto.dto;

import br.futurodev.projeto.ENUM.Status;
import br.futurodev.projeto.model.Categoria;

public class ProdutoRepresentationModel {

    private long id;
    private Categoria categoria;
    private String nomeProduto;
    private Double precoProduto;
    private Status statusProduto;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
