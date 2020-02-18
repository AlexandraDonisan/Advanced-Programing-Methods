package Model;

public class IfStmt implements IStmt {
    private Exp exp;
    private IStmt thenS;
    private IStmt elseS;

    public IfStmt(Exp exp, IStmt thenS, IStmt elseS) {
        this.exp = exp;
        this.thenS = thenS;
        this.elseS = elseS;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIDictionary<String,Integer> dict = state.getSymTable();
        MyIStack<IStmt> stk = state.getStk();
        try {
            if (exp.eval(dict) != 0) {
                stk.push(thenS);
            } else {
                stk.push(elseS);
            }
        } catch (MyException ex)
        {
            throw new MyException(""+ex);
        }
        return state;
    }

    @Override
    public String toString() {
        return "IfStmt{" +
                "exp=" + exp +
                ", thenS=" + thenS +
                ", elseS=" + elseS +
                '}';
    }
}