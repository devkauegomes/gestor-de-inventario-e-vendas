package exception;

public class ProdutoNaoEncontradoException extends RuntimeException{
    public ProdutoNaoEncontradoException() {
        super("Não foi possível encontrar o produto.");
    }

    public ProdutoNaoEncontradoException(String message) {
        super(message);
    }
}
