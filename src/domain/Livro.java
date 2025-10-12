package domain;

public class Livro extends Produto{
    private String autor;
    private String editora;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor == null || autor.isEmpty()){
            throw new IllegalArgumentException("O campo deve ser preenchido.");
        }
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        if (editora == null || editora.isEmpty()){
            throw new IllegalArgumentException("O campo deve ser preenchido.");
        }
        this.editora = editora;
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
