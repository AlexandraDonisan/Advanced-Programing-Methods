package Model;

public class ArithExp extends Exp {
    private Exp e1;
    private Exp e2;
    private int op;

    public ArithExp(int op,Exp e1, Exp e2) {
        this.e1 = e1;
        this.e2 = e2;
        this.op = op;
    }

    int eval(MyIDictionary<String, Integer> tbl) throws MyException {
        if (op == 1) return (e1.eval(tbl) + e2.eval(tbl));
        else if (op == 2) return (e1.eval(tbl) - e2.eval(tbl));
        else if (op == 3) return (e1.eval(tbl) * e2.eval(tbl));
        else if (op == 4)
        {
            if(e2.eval(tbl)==0)
                throw new MyException("Division by 0!!!");
            return (e1.eval(tbl) / e2.eval(tbl));}
        return (e1.eval(tbl) + e2.eval(tbl)); //CAUTION HERE
    }

    @Override
    public String toString() {
        return "ArithExp{" +
                "op=" + op +
                ", e1=" + e1 +
                ", e2=" + e2 +
                '}';
    }
}
