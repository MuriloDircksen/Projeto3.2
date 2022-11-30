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

    @Transactional
    public Produto salvar(Produto produto){


        return produtoRepository.save(produto);
    }

    @Transactional
    public void deletar(Long idProduto){


        produtoRepository.deleteById(idProduto);
    }

    @Transactional
    public List<Produto> getProdutoByStatus(){
        return produtoRepository.getProdutos();
    }

}
