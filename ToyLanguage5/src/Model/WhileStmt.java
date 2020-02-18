package Model;

import java.io.IOException;

public class WhileStmt implements IStmt{
    private Exp exp;
    private IStmt whileS;

    public WhileStmt(Exp exp, IStmt whileS) {
        this.exp = exp;
        this.whileS = whileS;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException, IOException {
        MyIDictionary<String,Integer> dict = state.getSymTable();
        MyIStack<IStmt> stk = state.getStk();
        MyIHeap<Integer,Integer> hp = state.getHeap();
        try{
            if(exp.eval(dict,hp)!=0){
                stk.push(this);
                stk.push(whileS);
            }

        }
        catch(MyException ex)
        {
            throw new MyException(""+ex);
        }
        return state;
    }

    @Override
    public String toString() {
        return "WHILE(" + exp +")" +"{ " + whileS + "}";
    }
}
