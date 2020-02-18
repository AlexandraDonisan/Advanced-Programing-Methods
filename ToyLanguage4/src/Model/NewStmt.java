package Model;

import java.io.IOException;

public class NewStmt implements IStmt {
    private String var_name;
    private Exp expression;

    public NewStmt(String var_name, Exp expression) {
        this.var_name = var_name;
        this.expression = expression;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException, IOException {
        MyIDictionary<String,Integer> symTable = state.getSymTable();
        MyIHeap<Integer,Integer> heap = state.getHeap();
        try{
            int val = expression.eval(symTable,heap);
            heap.add(val);
            int lastKey = heap.getKey();
            if(symTable.isDefined(var_name)) {

                symTable.update(var_name, lastKey);}
            else
            {
                symTable.add(var_name,lastKey);
            }


        }
        catch (MyException ex)
        {
            throw new MyException(""+ex);
        }

        return state;
    }

    @Override
    public String toString() {
        return "new(" + var_name +","+expression +')';
    }
}
