package Model;

public class Conjunction extends Exp {
    private Exp ex1;
    private Exp ex2;

    public Conjunction(Exp ex1, Exp ex2) {
        this.ex1 = ex1;
        this.ex2 = ex2;
    }

    public int eval()
    {
        if(ex1.eval()==1 && ex2.eval()==1)
            return 1;
        return 0;

    }
}
