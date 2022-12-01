package br.futurodev.projeto.controllers;

import br.futurodev.projeto.dto.ProdutoRepresentationModel;
import br.futurodev.projeto.input.ProdutoInput;
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

@Api(tags = "Produto")
@RestController
@RequestMapping(value = "produtos")
public class ProdutoController {

    @Autowired
    private CadastroProdutoService cadastroProdutoService;
    @Autowired
    private CadastroCategoriaService cadastroCategoriaService;

    @ApiOperation("Cadastrar produto")
    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<ProdutoRepresentationModel> cadastrar (@RequestBody @Valid ProdutoInput produtoInput){

        Produto produto =cadastroProdutoService.salvar(toDomainObject(produtoInput));
        return new ResponseEntity<ProdutoRepresentationModel>(toModel(produto), HttpStatus.OK);
    }

    @ApiOperation("Editar produto")
    @PutMapping(value = "/", produces = "Application/json")
    public ResponseEntity<ProdutoRepresentationModel> editar(@RequestBody ProdutoInput produtoInput){
        Produto produto = cadastroProdutoService.salvar(toDomainObject(produtoInput));
        return new ResponseEntity<ProdutoRepresentationModel>(toModel(produto), HttpStatus.OK);
    }

    @ApiOperation("Deletar produto")
    @DeleteMapping(value = "/")
    @ResponseBody

    public ResponseEntity<String> deletar (@ApiParam(value = "ID produto", example ="1") @RequestParam Long idProduto){

        cadastroProdutoService.deletar(idProduto);
        return new ResponseEntity<>("Produto deletado!", HttpStatus.OK);
    }

    @ApiOperation("Buscar produtos cadastrados")
    @GetMapping(value = "/", produces = "application/json")

    public ResponseEntity<List<ProdutoRepresentationModel>> getListaProduto(){

        List<Produto> produtos = cadastroProdutoService.getListaProdutos();


        List<ProdutoRepresentationModel> produtosRepresentationModel = toColletionModel(produtos);
        return new ResponseEntity<List<ProdutoRepresentationModel>>(produtosRepresentationModel,HttpStatus.OK);
    }
    @ApiOperation("Somar total dos itens comprados")
    @GetMapping(value = "/somar", produces = "application/json")
    @ResponseBody
    public ResponseEntity<String> somaProdutosComprados() {

        return new ResponseEntity<String>("Soma total das compras: R$ "+cadastroProdutoService.getProdutoByStatus(), HttpStatus.OK);
    }

    private ProdutoRepresentationModel toModel(Produto produto) {
        ProdutoRepresentationModel produtoRepresentationModel = new ProdutoRepresentationModel();

        produtoRepresentationModel.setId(produto.getId());
        produtoRepresentationModel.setNomeProduto(produto.getNomeProduto());
        produtoRepresentationModel.setPrecoProduto(produto.getPrecoProduto());
        produtoRepresentationModel.setStatusProduto(produto.getStatusProduto());
        produtoRepresentationModel.setNomeCategoria(produto.getCategoria().getNomeCategoria());

        return produtoRepresentationModel;
    }
    private List<ProdutoRepresentationModel> toColletionModel(List<Produto> produtos){
        return produtos.stream()
                .map(produto ->toModel(produto)).collect(Collectors.toList());
    }



    private Produto toDomainObject(ProdutoInput produtoInput){
        Produto produto = new Produto();
        produto.setId(produtoInput.getId());
        produto.setNomeProduto(produtoInput.getNomeProduto());
        produto.setPrecoProduto(produtoInput.getPrecoProduto());
        produto.setStatusProduto(produtoInput.getStatusProduto());
        produto.setCategoria(cadastroCategoriaService.getCategoriaById(produtoInput.getIdCategoria()));

        return produto;

    }
}
