package Model;

import javafx.util.Pair;

import java.io.IOException;
import java.util.ArrayList;

public class Await implements IStmt {
    private static java.util.concurrent.locks.Lock lock = new java.util.concurrent.locks.ReentrantLock();
    private String variable;

    public Await(String variable) {
        this.variable = variable;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException, IOException {
        lock.lock();
        MyIStack<IStmt> stk = state.getStk();
        MyIDictionary<String,Integer> sym = state.getSymTable();
        MyIBarrier<Integer, Pair<Integer,ArrayList<Integer>>> barrier = state.getBarrierTable();

        if(!sym.isDefined(variable))
            throw new MyException("Variable is not defined in Symbol Table!");

        int foundIndex = sym.lookup(variable);

        if(!barrier.isDefined(foundIndex))
            throw new MyException("Found Index is not defined in Barrier Table!");

        Pair<Integer,ArrayList<Integer>> pair = barrier.get(foundIndex);
        int N1 = pair.getKey();
        ArrayList<Integer> L1 = pair.getValue();
        int NL = L1.size();

        /*
        - if (N1>NL) then
         if(the identifier of the current PrgState is in L1) then
        - push back await(var) on the ExeStack
         else
        - add the id of the current PrgState to L1
        - push back await(var) on the ExeStack
         */

        if(N1>NL)
        {
            if(L1.contains(state.getId()))
            {
                stk.push(this);
            }
            else
            {
                L1.add(state.getId());
                state.getBarrierTable().update(new Pair<>(N1,L1) ,state.getId());
                stk.push(this);
            }
        }

        lock.unlock();

        return null;
    }

    public String toString()
    {
        return "Await("+variable+")";
    }
}
