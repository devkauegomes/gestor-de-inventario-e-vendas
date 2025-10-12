package service;

public enum StatusVenda {
    PROCESSANDO(1),
    CONCLUIDA(2),
    CANCELADA(3);

    private final int statusNumero;

    StatusVenda(int statusNumero){
        this.statusNumero = statusNumero;
    }

    public int getStatusNumero() {
        return statusNumero;
    }
}
