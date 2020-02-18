package Model;

public class Negation extends Exp{
    private Exp expression;

    public Negation(Exp e)
    {
        this.expression=e;
    }

    public int eval()
    {
        if(expression.eval()==1)
            return 0;
        return 1;
    }
}
