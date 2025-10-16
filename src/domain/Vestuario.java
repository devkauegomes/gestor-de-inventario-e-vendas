package domain;

public class Vestuario extends Produto implements Taxavel{
    public Vestuario(String nome, String codigo, double precoCusto, double precoVenda, int quantidadeEstoque, Categoria categoria) {
        super(nome, codigo, precoCusto, precoVenda, quantidadeEstoque, categoria);
    }

    @Override
    public void calcularPrecoVendaComImposto(double imposto) {
        if (imposto < 0){
            throw new IllegalArgumentException("O valor do imposto deve ser maior ou igual a 0");
        }
        double precoComImposto = this.getPrecoVenda() * (imposto/100 + 1);
        this.setPrecoVenda(precoComImposto);
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
    }
}
