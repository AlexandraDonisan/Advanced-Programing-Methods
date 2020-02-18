package Model;

public class BooleanExp extends Exp {
    private Exp exp1;
    private Exp exp2;
    private String symbol;

    public BooleanExp(Exp exp1, Exp exp2, String symbol) {
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.symbol = symbol;
    }

    @Override
    int eval(MyIDictionary<String, Integer> tbl, MyIHeap<Integer, Integer> hp) throws MyException {
        if(symbol.equals("<="))
        {
            if(exp1.eval(tbl,hp)<=exp2.eval(tbl,hp))
                return 1;
            return 0;
        }
        else if(symbol.equals("<"))
        {
            if(exp1.eval(tbl,hp)< exp2.eval(tbl,hp))
                return 1;
            return 0;
        }
        else if(symbol.equals("=="))
        {
            if(exp1.eval(tbl,hp)== exp2.eval(tbl,hp))
                return 1;
            return 0;
        }
        else if(symbol.equals("!="))
        {
            if(exp1.eval(tbl,hp) != exp2.eval(tbl,hp))
                return 1;
            return 0;
        }
        else if(symbol.equals(">"))
        {
            if(exp1.eval(tbl,hp) > exp2.eval(tbl,hp))
                return 1;
            return 0;
        }
        else if(symbol.equals(">="))
        {
            if(exp1.eval(tbl,hp) >= exp2.eval(tbl,hp))
                return 1;
            return 0;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "("+exp1 + symbol+exp2+")";
    }
}
