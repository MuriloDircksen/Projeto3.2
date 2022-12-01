package br.futurodev.projeto.controllers;

import br.futurodev.projeto.dto.CategoriaRepresentationModel;

import br.futurodev.projeto.input.CategoriaInput;

import br.futurodev.projeto.model.Categoria;

import br.futurodev.projeto.service.CadastroCategoriaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Categoria")
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
    @Autowired
    private CadastroCategoriaService cadastroCategoriaService;
    @ApiOperation("Cadastrar Categoria")
    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<CategoriaRepresentationModel> cadastrar (@RequestBody CategoriaInput categoriaInput){

        Categoria categoria =cadastroCategoriaService.salvar(toDomainObject(categoriaInput));
        return new ResponseEntity<CategoriaRepresentationModel>(toModel(categoria), HttpStatus.OK);
    }

    @ApiOperation("Editar categoria")
    @PutMapping(value = "/", produces = "Application/json")
    public ResponseEntity<CategoriaRepresentationModel> editar(@RequestBody CategoriaInput categoriaInput){
        Categoria categoria = cadastroCategoriaService.salvar(toDomainObject(categoriaInput));
        return new ResponseEntity<CategoriaRepresentationModel>(toModel(categoria), HttpStatus.OK);
    }

    @ApiOperation("Deletar categoria")
    @DeleteMapping(value = "/")
    @ResponseBody

    public ResponseEntity<String> deletar (@RequestParam Long idCategoria){
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



    private CategoriaRepresentationModel toModel(Categoria categoria) {
        CategoriaRepresentationModel categoriaRepresentationModel = new CategoriaRepresentationModel();

        categoriaRepresentationModel.setId(categoria.getId());
        categoriaRepresentationModel.setNomeCategoria(categoria.getNomeCategoria());
        categoriaRepresentationModel.setDescricaoCategoria(categoria.getDescricaoCategoria());
        categoriaRepresentationModel.setProdutos(categoria.getProdutos());

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
