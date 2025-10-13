package exception;

public class EstoqueCheioException extends RuntimeException{
    public EstoqueCheioException() {
        super("Não é possível adicionar mais produtos ao estoque.");
    }

    public EstoqueCheioException(String message) {
        super(message);
    }
}
