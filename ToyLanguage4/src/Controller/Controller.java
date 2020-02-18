package Controller;

import Model.IStmt;
import Model.MyException;
import Model.MyIStack;
import Model.PrgState;
import Repository.IRepository;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class Controller {
    private IRepository repo;

    public Controller(IRepository repo) {
        this.repo = repo;
    }

    Map<Integer,Integer> conservativeGarbageCollector(Collection<Integer> symTableValues,Map<Integer,Integer> heap)
    {
        return heap.entrySet().stream()
                .filter(e->symTableValues.contains(e.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    }

    private PrgState oneStep(PrgState state) throws MyStmtExecException {
        MyIStack<IStmt> stk = state.getStk();
        if(stk.isEmpty())throw new MyStmtExecException("The stack is empty");
        IStmt crtStmt = stk.pop();
        try {
            return crtStmt.execute(state);
        }
        catch(MyException | IOException ex)
        {
            throw new MyStmtExecException(""+ex);
        }
    }

    public void allStep()
    {
        PrgState prg = repo.getCtrPrg();
        repo.clearData();
        while(!prg.getStk().isEmpty())
        {
            try {
                oneStep(prg);
                prg.getHeap().setContent(conservativeGarbageCollector(prg.getSymTable().getContent().values(),prg.getHeap().getContent()));
                repo.logPrgStateExec();
            } catch (MyStmtExecException e) {
                System.err.println("Exception is : "+e);}
            System.out.println(prg.toString());
            }

        }
    }
