package Model;

public class Addition extends Exp{
    private Exp ex1;
    private Exp ex2;

    public Addition(Exp ex1, Exp ex2) {
        this.ex1 = ex1;
        this.ex2 = ex2;
    }

    public int eval()
    {
        int sum = ex1.eval()+ ex2.eval();
        return sum % 5;
    }
}
