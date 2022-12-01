package br.futurodev.projeto.service;

import br.futurodev.projeto.model.Categoria;
import br.futurodev.projeto.model.Produto;
import br.futurodev.projeto.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CadastroCategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Transactional
    public Categoria salvar(Categoria categoria){


        return categoriaRepository.save(categoria);
    }

    @Transactional
    public void deletar(Long idCategoria){


        categoriaRepository.deleteById(idCategoria);
    }
    @Transactional
    public List<Categoria> getListaCategorias(){
        List<Categoria> categorias = (List<Categoria>) categoriaRepository.findAll();

        return categorias;
    }
    @Transactional
    public Categoria getCategoriaById(Long idCategoria){
        return categoriaRepository.findById(idCategoria).get();
    }
}
