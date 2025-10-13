package domain;


public class Alimento extends Produto{
    private String dataDeValidade;

    public Alimento(String nome, String codigo, Categoria categoria, String dataDeValidade) {
        super(nome, codigo, categoria);
        this.dataDeValidade = dataDeValidade;
    }

    public String getDataDeValidade() {
        return dataDeValidade;
    }

    public void setDataDeValidade(String dataDeValidade) {
        if (dataDeValidade == null || dataDeValidade.isEmpty()){
            throw new IllegalArgumentException("O campo deve ser preenchido.");
        }
        this.dataDeValidade = dataDeValidade;
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
