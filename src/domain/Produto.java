package domain;

public abstract class Produto {
    private String nome;
    private String codigo;
    private double precoCusto;
    private double precoVenda;
    private int quantidadeEstoque;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo.length() > 5){
            throw new IllegalArgumentException("O código deve ter no máximo 5 digitos.");
        }
        this.codigo = codigo;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        if (precoCusto <= 0){
            throw new IllegalArgumentException("O preço de custo não pode ser menor ou igual a 0.");
        }
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        if (precoVenda < this.precoCusto){
            throw new IllegalArgumentException("O preço de venda não pode ser menor que o preço de custo.");
        }
        this.precoVenda = precoVenda;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }


    public void adicionarEstoque(int valor){
        if (valor <= 0){
            return;
        }
        this.quantidadeEstoque += valor;
    }

    public void removerEstoque(int valor){
        if (valor > this.quantidadeEstoque){
            throw new IllegalArgumentException("Valor informado é maior que a quantidade em estoque.");
        }
        this.quantidadeEstoque -= valor;
    }
}