package Model;

public class Multiplication extends Exp{
    private Exp ex1;
    private Exp ex2;

    public Multiplication(Exp ex1, Exp ex2) {
        this.ex1 = ex1;
        this.ex2 = ex2;
    }

    public int eval() {
        int mul = ex1.eval()*ex2.eval();
        return mul%5;
    }

}
