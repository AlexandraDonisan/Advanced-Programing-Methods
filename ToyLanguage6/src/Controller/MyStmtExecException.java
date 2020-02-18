package Controller;

public class MyStmtExecException extends Exception{
    String message;

    public MyStmtExecException(String message) {
        super(message);
    }
}
