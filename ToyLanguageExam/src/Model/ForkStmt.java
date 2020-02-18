package Model;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class ForkStmt implements IStmt {
    private IStmt stmt;

    public ForkStmt(IStmt stmt) {
        this.stmt = stmt;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException, IOException {
        MyIStack<IStmt> newExeStack = new MyStack<>();
        //newExeStack.push(stmt);

        MyIDictionary<String,Integer> symTable = state.getSymTable(); //CAREFUL HERE
        MyIDictionary<String,Integer> cloneSymTable = new MyDictionary<>();
        symTable.getKeys().forEach(key->cloneSymTable.add(key,symTable.get(key)));

        MyIList<Integer> newOut = state.getOut();

        MyIFileDictionary<Integer, Pair<String, BufferedReader>> newFileTable = state.getFileTable();

        MyIHeap<Integer,Integer> newHeap = state.getHeap();

        MyIBarrier<Integer,Pair<Integer, ArrayList<Integer>>> newBarrier= state.getBarrierTable();

        //state.setId(state.getId()*10);

        return new PrgState(newExeStack,cloneSymTable,newOut,newFileTable,newHeap,newBarrier, stmt);
    }

    @Override
    public String toString() {
        return "forkStmt{" +stmt +'}';
    }
}
