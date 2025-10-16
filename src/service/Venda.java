package service;

import domain.Produto;
import exception.EstoqueCheioException;
import exception.ProdutoForaDeEstoqueException;

public class Venda {
    private String cliente;
    private StatusVenda statusVenda;
    private Estoque estoque;
    private Produto[] itensNaVenda;
    private int contadorProdutos;

    public Venda(String cliente, StatusVenda statusVenda, Estoque estoque) {
        this.cliente = cliente;
        this.statusVenda = statusVenda;
        this.itensNaVenda = new Produto[30];
        this.estoque = estoque;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        if (cliente == null || cliente.isEmpty()){
            throw new IllegalArgumentException("O nome do produto não deve ser nulo.");
        }
        this.cliente = cliente;
    }

    public StatusVenda getStatusVenda() {
        return statusVenda;
    }

    public void setStatusVenda(StatusVenda statusVenda) {
        this.statusVenda = statusVenda;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        if (estoque == null || estoque.getProdutos().length == 0){
            throw new IllegalArgumentException("O estoque não pode ser nulo ou vazio.");
        }
        this.estoque = estoque;
    }

    public void adicionarProduto(Produto produto){
        if (verificaProdutoNoEstoque(produto) && verificaQuantidadeEmEstoque(produto)){
            if (contadorProdutos < this.itensNaVenda.length){
                this.itensNaVenda[contadorProdutos] = produto;
                contadorProdutos++;
                return;
            }
            throw new EstoqueCheioException();
        }
        throw new ProdutoForaDeEstoqueException();
    }

    private boolean verificaProdutoNoEstoque(Produto produto){
        for (Produto produtoEstoque : this.estoque.getProdutos()){
            if (produtoEstoque != null){
                if (produtoEstoque.getCodigo().equals(produto.getCodigo())){
                    return true;
                }
            }

        }
        return false;
    }


    private boolean verificaQuantidadeEmEstoque(Produto produto){
        return produto.getQuantidadeEstoque() > 0;
    }

    public void exibirDetalhes(){
        for (Produto produto : this.itensNaVenda){
            if (produto != null){
                produto.exibirDetalhes();
            }
        }
    }

    public double calcularPrecoItens(){
        double valorTotal = 0;
        for (Produto produto : this.itensNaVenda){
            if (produto != null){
                valorTotal += produto.getPrecoVenda();
            }
        }
        System.out.println("Valor total da venda: " + valorTotal);
        return valorTotal;
    }

    public void removerProduto(Produto produto){
        Produto[] novoItensNaVenda = new Produto[this.itensNaVenda.length - 1];
        int novoIndice = 0;
        boolean removido = false;

            for (int i = 0; i < this.itensNaVenda.length; i++) {
                if (this.itensNaVenda[i] != null){
                    if (this.itensNaVenda[i].getCodigo().equals(produto.getCodigo()) && !removido){
                        removido = true;
                        continue;
                    }
                }

                novoItensNaVenda[novoIndice] = this.itensNaVenda[i];
                novoIndice++;
            }

        this.itensNaVenda = novoItensNaVenda;
    }
}
