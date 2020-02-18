package Model;

import java.io.IOException;

public class Lock implements IStmt {
    private static java.util.concurrent.locks.Lock lock = new java.util.concurrent.locks.ReentrantLock();
    private String variable;

    public Lock(String variable) {
        this.variable = variable;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException, IOException {
        lock.lock();
        MyIDictionary<String,Integer> symTable = state.getSymTable();
        try {
            int foundIndex;
            foundIndex = symTable.lookup(variable);
            if (state.getLockTable().get(foundIndex) == -1)
                state.getLockTable().update(foundIndex, state.getId());
            else
                state.getStk().push(this);
        }
        catch (MyException e)
        {
            throw new MyException(""+e);
        }finally {
            lock.unlock();
        }
        return null;
    }

    public String toString()
    {
        return "Lock("+variable+")";
    }

}
