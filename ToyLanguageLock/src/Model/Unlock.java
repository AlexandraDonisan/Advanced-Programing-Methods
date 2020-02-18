package Model;

import java.io.IOException;

public class Unlock implements IStmt {
    private static java.util.concurrent.locks.Lock lock1 = new java.util.concurrent.locks.ReentrantLock();
    private String variable;

    public Unlock(String variable) {
        this.variable = variable;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException, IOException {
        lock1.lock();
        MyIDictionary<String,Integer> symTable = state.getSymTable();
        MyILock<Integer,Integer> lock = state.getLockTable();

        try {
            int foundIndex = symTable.lookup(variable);
            if (lock.lookup(foundIndex) == state.getId())
                lock.update(foundIndex, -1);
        }
        catch(MyException e)
        {
            throw new MyException(""+e);
        }
        finally {
            lock1.unlock();
        }
        return null;
    }

    public String toString()
    {
        return "Unlock("+variable+")";
    }
}
