package Model;

public class IfNegExp extends Exp{
    private Exp e1;
    private Exp e2;

    public IfNegExp(Exp e1,Exp e2)
    {
        this.e1=e1;
        this.e2=e2;
    }

    public int eval()
    {
        if(e1.eval()<0)
            return e2.eval();
        return e1.eval();
    }
}