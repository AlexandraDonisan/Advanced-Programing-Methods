package Model;

public class Abs extends Exp{
    private Exp expression;

    public Abs(Exp e)
    {
        this.expression =e;
    }

    public int eval()
    {
        return Math.abs(expression.eval());
    }
}
