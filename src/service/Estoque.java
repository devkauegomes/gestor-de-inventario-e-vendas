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

    public Produto[] getProdutos() {
        return produtos;
    }


    public void adicionarProdutoAoEstoque(Produto produto){
        if (this.contadorDeProdutos < this.produtos.length){
            this.produtos[contadorDeProdutos] = produto;
            contadorDeProdutos++;
            return;
        }
        throw new EstoqueCheioException();
    }

    public void buscarProdutoPorCodigo(String codigo){
        for (Produto produto : this.produtos){
            if (produto != null){
                if (produto.getCodigo().equals(codigo)){
                    produto.exibirDetalhes();
                    return;
                }
            }

        }
        throw new ProdutoNaoEncontradoException();
    }

    public void exibirDetalhes(){
        for (Produto produto: this.produtos){
            if (produto == null){
                continue;
            }
            produto.exibirDetalhes();
        }
    }

    public void removerProduto(Produto produto){
        Produto[] novoProdutos = new Produto[this.produtos.length - 1];
        int novoIndice = 0;
        boolean removido = false;

        for (int i = 0; i < this.produtos.length; i++) {
            if (this.produtos[i] != null){
                if (this.produtos[i].getCodigo().equals(produto.getCodigo()) && !removido){
                    removido = true;
                    continue;
                }
            }

            novoProdutos[novoIndice] = this.produtos[i];
            novoIndice++;
        }

        this.produtos = novoProdutos;
    }

}
