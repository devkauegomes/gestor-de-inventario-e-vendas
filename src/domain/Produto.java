package domain;

public abstract class Produto {
    private String nome;
    private String codigo;
    private double precoCusto;
    private double precoVenda;
    private int quantidadeEstoque;
    private Categoria categoria;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()){
            throw new IllegalArgumentException("O nome do produto não deve ser nulo.");
        }
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        if (precoCusto < 0){
            throw new IllegalArgumentException("O preço de custo não pode ser menor ou igual a 0.");
        }
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public boolean setPrecoVenda(double precoVenda) {
        if (precoVenda >= this.precoCusto){
            this.precoVenda = precoVenda;
            return true;
        }
        return false;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }


    public void adicionarEstoque(int valor){
        if (valor < 0){
            throw new IllegalArgumentException("O valor adicionado ao estoque deve ser maior que 0.");
        }
        this.quantidadeEstoque += valor;
    }

    public void removerEstoque(int valor){
        if (valor > this.quantidadeEstoque){
            throw new IllegalArgumentException("Valor informado é maior que a quantidade em estoque.");
        }
        this.quantidadeEstoque -= valor;
    }

    public abstract void calcularPrecoVendaComImposto(double imposto);
}