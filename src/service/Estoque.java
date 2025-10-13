package service;

import domain.Produto;
import exception.EstoqueCheioException;
import exception.ProdutoNaoEncontradoException;

public class Estoque {
    private Produto[] produtos;
    private int contadorDeProdutos;

    public Estoque(){
        this.produtos = new Produto[100];
    }

    public void adicionarProdutoAoEstoque(Produto produto){
        if (this.contadorDeProdutos < this.produtos.length){
            this.produtos[contadorDeProdutos] = produto;
            contadorDeProdutos++;
        }
        throw new EstoqueCheioException();
    }

    public void buscarProdutoPorCodigo(String codigo){
        for (Produto produto : this.produtos){
            if (produto.getCodigo().equals(codigo)){
                produto.exibirDetalhes();
                return;
            }
        }
        throw new ProdutoNaoEncontradoException();
    }
}
