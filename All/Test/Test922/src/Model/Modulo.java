package Model;

public class Modulo extends Exp {
    private Exp expression;

    public Modulo(Exp expression) {
        this.expression = expression;
    }

    public int eval()
    {
        return expression.eval()%5;
    }
}
