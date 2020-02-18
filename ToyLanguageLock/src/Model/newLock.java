package Model;

import java.io.IOException;

public class newLock implements IStmt {
    private static java.util.concurrent.locks.Lock lock = new java.util.concurrent.locks.ReentrantLock();
    private String variable;
    private static int key = 0;

    public newLock(String variable) {
        this.variable = variable;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException, IOException {
        lock.lock();
        MyIDictionary<String,Integer> symTable = state.getSymTable();
        MyILock<Integer,Integer> lockTable = state.getLockTable();

        lockTable.update(key,-1);
        if(symTable.isDefined(variable))
            symTable.update(variable,key);
        else
            symTable.add(variable,key);
        key++;
        lock.unlock();
        return null;
    }

    public String toString()
    {
        return "NewLock("+variable+")";
    }

}
