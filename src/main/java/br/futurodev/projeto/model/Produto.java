package br.futurodev.projeto.model;

import br.futurodev.projeto.ENUM.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idCategoria", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_categoria"))
    @JsonBackReference
    private Categoria categoria;

    @Column(nullable = false)
    private String nomeProduto;
    @Column(nullable = false, precision = 2)
    private Double precoProduto;
    @Enumerated(EnumType.STRING)
    private Status statusProduto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id.equals(produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
