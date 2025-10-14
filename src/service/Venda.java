package service;

import domain.Produto;
import exception.ProdutoNaoEncontradoException;

public class Venda {
    private String cliente;
    private StatusVenda statusVenda;
    private Estoque estoque;
    private Produto[] produtos;
    private int contadorProdutos;

    public Venda(String cliente, StatusVenda statusVenda, Estoque estoque) {
        this.cliente = cliente;
        this.statusVenda = statusVenda;
        this.estoque = estoque;
        this.produtos = new Produto[30];
    }

    public void adicionarProduto(Produto produto){
        for (Produto produtoEstoque : estoque.getProdutos()){
            if (produto.getCodigo().equals(produtoEstoque.getCodigo())){
                this.produtos[contadorProdutos] = produto;
                contadorProdutos++;
                return;
            }
        }
        throw new ProdutoNaoEncontradoException();
    }
}
