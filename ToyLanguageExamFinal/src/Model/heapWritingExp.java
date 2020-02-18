package Model;

import java.io.IOException;
import java.sql.SQLOutput;

public class heapWritingExp implements IStmt{
    private String variableName;
    private Exp expression;

    public heapWritingExp(String variableName, Exp expression) {
        this.variableName = variableName;
        this.expression = expression;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException, IOException {
        MyIDictionary<String,Integer> symTbl = state.getSymTable();
        MyIHeap<Integer,Integer> hp = state.getHeap();
        try{
            int heapAddress = symTbl.lookup(variableName);

            int v = expression.eval(symTbl, hp);
            if(hp.isDefined(heapAddress))
                hp.update(heapAddress,v);
            else
                hp.add(v);
        }
        catch (MyException ex)
        {
            throw new MyException(""+ex);
        }
        return null;
    }

    @Override
    public String toString() {
        return "wH(" + variableName + "," + expression + ')';
    }

}
