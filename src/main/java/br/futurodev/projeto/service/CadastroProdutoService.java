package br.futurodev.projeto.service;

import br.futurodev.projeto.model.Produto;
import br.futurodev.projeto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class CadastroProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CadastroProdutoService cadastroProdutoService;

    @Transactional
    public Produto salvar(Produto produto){


        return produtoRepository.save(produto);
    }

    @Transactional
    public void deletar(Long idProduto){
        Produto produto=new Produto();
        produto=cadastroProdutoService.getProdutoById(idProduto);
        produto.setCategoria(null);
        cadastroProdutoService.salvar(produto);
        produtoRepository.deleteById(idProduto);
    }

    @Transactional
    public List<Produto> getProdutoByStatus(){
        return produtoRepository.getProdutos();
    }

    @Transactional
    public List<Produto> getListaProdutos(){
        List<Produto> produtos = (List<Produto>) produtoRepository.findAll();

        return produtos;
    }
    @Transactional
    public List<Produto> getProdutosPorCategoria(Long idCategoria){

        return produtoRepository.getProdutosPorCategoria(idCategoria);
    }
    @Transactional
    public Produto getProdutoById(Long idProduto){
        return produtoRepository.findById(idProduto).get();
    }



}
