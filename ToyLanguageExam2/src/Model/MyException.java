package Model;

public class MyException extends Exception {
    private String message;

    public MyException(String message) {
        super(message);
    }
}
