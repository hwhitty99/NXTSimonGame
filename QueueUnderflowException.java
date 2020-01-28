// From textbook -> needs appropriate documentation

public class QueueUnderflowException extends RuntimeException {
    public QueueUnderflowException() {
        super();
    }

    public QueueUnderflowException(String message) {
        super(message);
    }
}