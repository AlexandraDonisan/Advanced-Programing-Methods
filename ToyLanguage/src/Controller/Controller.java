package Controller;

import Model.IStmt;
import Model.MyException;
import Model.MyIStack;
import Model.PrgState;
import Repository.IRepository;

public class Controller {
    private IRepository repo;

    public Controller(IRepository repo) {
        this.repo = repo;
    }

    private PrgState oneStep(PrgState state) throws MyStmtExecException {
        MyIStack<IStmt> stk = state.getStk();
        if(stk.isEmpty())throw new MyStmtExecException("The stack is empty");
        IStmt crtStmt = stk.pop();
        try {
            return crtStmt.execute(state);
        }
        catch(MyException ex)
        {
            throw new MyStmtExecException(""+ex);
        }
    }

    public void allStep()
    {
        PrgState prg = repo.getCtrPrg();
        while(!prg.getStk().isEmpty())
        {
            try {
                oneStep(prg);
            } catch (MyStmtExecException e) {
                System.err.println("Exception is : "+e);
            }
            System.out.println(prg.toString());
        }
    }
}
