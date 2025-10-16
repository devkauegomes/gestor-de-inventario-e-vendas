package domain;

public class Eletronico extends Produto implements Taxavel{
    private int mesesGarantia;

    public Eletronico(String nome, String codigo, double precoCusto, double precoVenda, int quantidadeEstoque, Categoria categoria) {
        super(nome, codigo, precoCusto, precoVenda, quantidadeEstoque, categoria);
    }

    public int getMesesGarantia() {
        return mesesGarantia;
    }

    public void setMesesGarantia(int mesesGarantia) {
        if (mesesGarantia < 0){
            throw new IllegalArgumentException("A garantia deve ser maior ou igual a 0.");
        }
        this.mesesGarantia = mesesGarantia;
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
        System.out.println("Meses de Garantia: " + this.mesesGarantia);
    }
}
