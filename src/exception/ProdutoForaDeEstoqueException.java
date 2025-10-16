package exception;

public class ProdutoForaDeEstoqueException extends RuntimeException{
    public ProdutoForaDeEstoqueException() {
        super("O produto em questão não está disponível.");
    }

    public ProdutoForaDeEstoqueException(String message) {
        super(message);
    }
}
