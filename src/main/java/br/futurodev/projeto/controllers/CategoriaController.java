package br.futurodev.projeto.controllers;

import br.futurodev.projeto.dto.CategoriaRepresentationModel;

import br.futurodev.projeto.dto.ProdutoRepresentationModel;
import br.futurodev.projeto.input.CategoriaInput;

import br.futurodev.projeto.model.Categoria;

import br.futurodev.projeto.model.Produto;
import br.futurodev.projeto.service.CadastroCategoriaService;

import br.futurodev.projeto.service.CadastroProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "Categoria")
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
    @Autowired
    private CadastroCategoriaService cadastroCategoriaService;

    @Autowired
    private CadastroProdutoService cadastroProdutoService;
    @ApiOperation("Cadastrar Categoria")
    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<CategoriaRepresentationModel> cadastrar (@RequestBody @Valid CategoriaInput categoriaInput){

        Categoria categoria =cadastroCategoriaService.salvar(toDomainObject(categoriaInput));
        return new ResponseEntity<CategoriaRepresentationModel>(toModel(categoria), HttpStatus.OK);
    }

    @ApiOperation("Editar categoria")
    @PutMapping(value = "/", produces = "Application/json")
    public ResponseEntity<CategoriaRepresentationModel> editar(@RequestBody CategoriaInput categoriaInput){
        Categoria categoria = cadastroCategoriaService.salvar(toDomainObject(categoriaInput));
        return new ResponseEntity<CategoriaRepresentationModel>(toModel(categoria), HttpStatus.OK);
    }

    @ApiOperation("Deletar categoria sem produto cadastrado")
    @DeleteMapping(value = "/")
    @ResponseBody

    public ResponseEntity<String> deletar (@ApiParam(value = "ID categoria", example ="1") @RequestParam Long idCategoria){
            Categoria categoria = new Categoria();
            categoria = cadastroCategoriaService.getCategoriaById(idCategoria);
        if(categoria.getProdutos().isEmpty()) {
            cadastroCategoriaService.deletar(idCategoria);
            return new ResponseEntity<String>("Categoria deletado!", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>("Categoria não pode ser deletada, possui produtos registrados!", HttpStatus.OK);
        }

    }
    @ApiOperation("Buscar categorias cadastrados")
    @GetMapping(value = "/", produces = "application/json")

    public ResponseEntity<List<CategoriaRepresentationModel>> getListaCategoria(){

        List<Categoria> categorias = cadastroCategoriaService.getListaCategorias();


        List<CategoriaRepresentationModel> categoriasRepresentationModel = toColletionModel(categorias);
        return new ResponseEntity<List<CategoriaRepresentationModel>>(categoriasRepresentationModel,HttpStatus.OK);
    }

    private List<CategoriaRepresentationModel> toColletionModel(List<Categoria> categorias){
        return categorias.stream()
                .map(categoria ->toModel(categoria)).collect(Collectors.toList());
    }

    private CategoriaRepresentationModel toModel(Categoria categoria) {
        CategoriaRepresentationModel categoriaRepresentationModel = new CategoriaRepresentationModel();
        List<Produto> produtos = cadastroProdutoService.getProdutosPorCategoria(categoria.getId());
        categoriaRepresentationModel.setId(categoria.getId());
        categoriaRepresentationModel.setNomeCategoria(categoria.getNomeCategoria());
        categoriaRepresentationModel.setDescricaoCategoria(categoria.getDescricaoCategoria());
        categoriaRepresentationModel.setProdutos(produtos);

        return categoriaRepresentationModel;
    }



    private Categoria toDomainObject(CategoriaInput categoriaInput){
        Categoria categoria = new Categoria();
        categoria.setId(categoriaInput.getId());
        categoria.setNomeCategoria(categoriaInput.getNomeCategoria());
        categoria.setDescricaoCategoria(categoriaInput.getDescricaoCategoria());

        return categoria;

    }

}
