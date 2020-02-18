package Model;

public class AssignStmt implements IStmt{
    private String id;
    private Exp exp;

    public AssignStmt(String id, Exp exp) {
        this.id = id;
        this.exp = exp;
    }

    public PrgState execute(PrgState state) throws MyException {
        //MyIStack<IStmt> stk = state.getStk();
        MyIDictionary<String,Integer> symTbl = state.getSymTable();
        try {
            int val = exp.eval(symTbl);
            if(symTbl.isDefined(id)) {
                symTbl.update(id,val);
            }
            else
            {
                symTbl.add(id,val);
            }
        }
        catch(MyException ex){
            throw new MyException(""+ex);
        }

        return state;
    }

    @Override
    public String toString() {
        return id +"=" + exp;
    }
}
