package Model;

public class PrintStmt implements IStmt {
    private Exp exp;

    public PrintStmt(Exp exp) {
        this.exp = exp;
    }

    public PrgState execute(PrgState state) throws MyException {
        MyIList<Integer> list = state.getOut();
        MyIDictionary<String,Integer> dict = state.getSymTable();
        MyIHeap<Integer,Integer> hp = state.getHeap();
        try {
            list.add(exp.eval(dict,hp));
        }
        catch (MyException ex)
        {
            throw new MyException(""+ex);
        }
        return state;
    }

    @Override
    public String toString() {
        //return String.valueOf(exp);
        return "Print("+ exp.toString()+")";
    }
}
