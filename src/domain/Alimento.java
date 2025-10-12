package domain;


public class Alimento extends Produto{
    private String dataDeValidade;

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
}
