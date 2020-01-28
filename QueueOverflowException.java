// From textbook -> needs appropriate documentation

public class QueueOverflowException extends RuntimeException {
    public QueueOverflowException() {
      super();
    }

    public QueueOverflowException(String message) {
      super(message);
    }
}