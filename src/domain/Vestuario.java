package domain;

public class Vestuario extends Produto{
    public Vestuario(String nome, String codigo, Categoria categoria) {
        super(nome, codigo, categoria);
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
        System.out.println(this.getCategoria().getCategoria_texto());
        System.out.println("Nome: " + this.getNome());
        System.out.println("Código: " + this.getCodigo());
        System.out.println("Preço: " + this.getPrecoVenda());
    }
}
