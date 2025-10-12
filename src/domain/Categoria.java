package domain;

public enum Categoria {
    ELETRONICO("Eletrônico"),
    VESTUARIO("Vestuário"),
    LIVRO("Livro"),
    ALIMENTO("Alimento");

    private final String categoria_texto;

    Categoria(String texto){
        this.categoria_texto = texto;
    }

    public String getCategoria_texto() {
        return categoria_texto;
    }
}
