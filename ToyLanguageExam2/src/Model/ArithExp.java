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

    int eval(MyIDictionary<String, Integer> tbl,MyIHeap<Integer,Integer> hp) throws MyException {
        if (op == 1) return (e1.eval(tbl,hp) + e2.eval(tbl,hp));
        else if (op == 2) return (e1.eval(tbl,hp) - e2.eval(tbl,hp));
        else if (op == 3) return (e1.eval(tbl,hp) * e2.eval(tbl,hp));
        else if (op == 4)
        {
            if(e2.eval(tbl,hp)==0)
                throw new MyException("Division by 0!!!");
            return (e1.eval(tbl,hp) / e2.eval(tbl,hp));
        }
        return (e1.eval(tbl,hp) + e2.eval(tbl,hp)); //CAUTION HERE
    }

    public String operation(int o)
    {
        String res="";
        if(o==1)
            res+="+";
        else if(o==2)
            res+="-";
        else if(o==3)
            res += "*";
        else if(o==4)
            res += "/";
        return res;
    }

    @Override
    public String toString() {
        return e1 + operation(op) + e2; //For +
    }
}
