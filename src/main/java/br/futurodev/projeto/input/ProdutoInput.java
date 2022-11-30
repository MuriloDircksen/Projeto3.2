package br.futurodev.projeto.input;

import br.futurodev.projeto.ENUM.Status;
import br.futurodev.projeto.model.Categoria;

public class ProdutoInput {

    private Long id;
    private Long idCategoria;
    private String nomeProduto;
    private Double precoProduto;
    private Status statusProduto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
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