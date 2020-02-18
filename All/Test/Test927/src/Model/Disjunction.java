package Model;

public class Disjunction extends Exp {
    private Exp ex1;
    private Exp ex2;

    public Disjunction(Exp ex1, Exp ex2) {
        this.ex1 = ex1;
        this.ex2 = ex2;
    }

    public int eval()
    {
        if(ex1.eval()==0 && ex2.eval()==0)
            return 0;
        return 1;
    }
}
