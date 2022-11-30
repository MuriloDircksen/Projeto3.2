package br.futurodev.projeto.controllers;

import br.futurodev.projeto.dto.ProdutoRepresentationModel;
import br.futurodev.projeto.input.ProdutoInput;
import br.futurodev.projeto.model.Produto;
import br.futurodev.projeto.service.CadastroProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "Produto")
@RestController
@RequestMapping(value = "produtos")
public class ProdutoController {

    @Autowired
    private CadastroProdutoService cadastroProdutoService;
    @ApiOperation("Cadastrar")
    @PostMapping(value = "/", produces = "application/JSON")
    public ResponseEntity<ProdutoRepresentationModel> cadastrar (@RequestBody ProdutoInput produtoInput){

        Produto produto =cadastroProdutoService.salvar(toDomainObject(produtoInput));
        return new ResponseEntity<ProdutoRepresentationModel>(toModel(produto), HttpStatus.OK);
    }

    @ApiOperation("Editar")
    @PutMapping(value = "/", produces = "Application/json")
    public ResponseEntity<ProdutoRepresentationModel> editar(@RequestBody ProdutoInput produtoInput){
        Produto produto = cadastroProdutoService.salvar(toDomainObject(produtoInput));
        return new ResponseEntity<ProdutoRepresentationModel>(toModel(produto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/")
    @ResponseBody

    public ResponseEntity<String> deletar (@RequestParam Long idPedido){

        cadastroProdutoService.deletar(idPedido);
        return new ResponseEntity<>("Usuario deletado!", HttpStatus.OK);
    }
    @GetMapping(value = "/somar", produces = "application/json")
    @ResponseBody
    public ResponseEntity<String> somaProdutosComprados() {
        //obtem a lista de pedidos do tipo model
        double soma=0;
        List<Produto> produtos = cadastroProdutoService.getProdutoByStatus();
        for(int i=0; i<produtos.size();i++) {
            soma+=produtos.get(i).getPrecoProduto();
        }

        return new ResponseEntity<String>("Soma total das compras: R$ "+soma, HttpStatus.OK);
    }

    private ProdutoRepresentationModel toModel(Produto produto) {
        ProdutoRepresentationModel produtoRepresentationModel = new ProdutoRepresentationModel();
        //realizar a conversão do UsuarioModel para representation model
        produtoRepresentationModel.setId(produto.getId());
        produtoRepresentationModel.setNomeProduto(produto.getNomeProduto());
        produtoRepresentationModel.setPrecoProduto(produto.getPrecoProduto());
        produtoRepresentationModel.setStatusProduto(produto.getStatusProduto());
        produtoRepresentationModel.setCategoria(produto.getCategoria());

        return produtoRepresentationModel;
    }


    //converter um objeto do tipo usuario input para usuario model
    private Produto toDomainObject(ProdutoInput produtoInput){
        Produto produto = new Produto();
        produto.setId(produtoInput.getId());
        produto.setNomeProduto(produtoInput.getNomeProduto());
        produto.setPrecoProduto(produtoInput.getPrecoProduto());
        produto.setStatusProduto(produtoInput.getStatusProduto());
        produto.setCategoria(produtoInput.getCategoria());



        return produto;

    }
}
