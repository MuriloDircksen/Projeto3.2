package br.futurodev.projeto.repository;

import br.futurodev.projeto.model.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

    //@Query(value = "select p from PedidoModel p where p.clienteModel.nome like %?1%")
    //fazer querry que retorne todos os status true
    @Query(value = "select SUM(p.precoProduto)from Produto p where p.statusProduto = 'COMPRADO'")
    ArrayList<Produto> getProdutos();

    @Query(value = "from Produto p where p.categoria.id = ?1")
    ArrayList<Produto> getProdutosPorCategoria(Long idCategoria);
}
