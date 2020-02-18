package Model;

import javafx.util.Pair;

import java.io.IOException;
import java.util.ArrayList;

public class NewBarrier implements IStmt {
    private static java.util.concurrent.locks.Lock lock = new java.util.concurrent.locks.ReentrantLock();
    private String variable;
    private Exp exp;
    private static int key = 0;

    public NewBarrier(String variable, Exp exp) {
        this.variable = variable;
        this.exp = exp;
    }

    /*
            if var exists in SymTable1 then
                SymTable2 = update(SymTable1,var, newfreelocation)
            else SymTable2 = add(SymTable1,var, newfreelocation)
             */
    @Override
    public PrgState execute(PrgState state) throws MyException, IOException {
        lock.lock();
        MyIDictionary<String, Integer> tbl = state.getSymTable();
        MyIHeap<Integer, Integer> hp = state.getHeap();
        MyIBarrier<Integer, Pair<Integer,ArrayList<Integer>>> barrier = state.getBarrierTable();
        MyIDictionary<String,Integer> sym = state.getSymTable();

        int number = this.exp.eval(tbl,hp);
        //barrier.update(new Pair<>(key,new ArrayList<>()),number);

        barrier.update(new Pair<>(number,new ArrayList<>()),key);

        if(sym.isDefined(variable))
            sym.update(variable,key);
        else
            sym.add(variable,key);
        key++;

        lock.unlock();
        return null;
    }

    public String toString()
    {
        return "NewBarrier("+variable+", "+exp+")";
    }
}
