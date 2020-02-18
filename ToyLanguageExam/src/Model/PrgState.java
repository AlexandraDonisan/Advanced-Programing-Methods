package Model;

import javafx.util.Pair;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class PrgState {
    private MyIStack<IStmt> exeStack;
    private MyIDictionary<String,Integer> symTable;
    private MyIList<Integer> out;
    private MyIFileDictionary<Integer, Pair<String, BufferedReader>> fileTable;
    private  MyIHeap<Integer,Integer> heap;
    private MyIBarrier<Integer,Pair<Integer,ArrayList<Integer>>> barrier;
    private int id;

    public PrgState(MyIStack<IStmt> exeStack, MyIDictionary<String, Integer> symTable, MyIList<Integer> out, MyIFileDictionary<Integer, Pair<String, BufferedReader>> fileTable,MyIHeap<Integer,Integer> heap,MyIBarrier<Integer,Pair<Integer,ArrayList<Integer>>> bar,IStmt prg) {
        this.exeStack = exeStack;
        this.symTable = symTable;
        this.out = out;
        this.fileTable = fileTable;
        this.heap=heap;
        this.barrier = bar;
        exeStack.push(prg);
    }

    public Boolean isNotCompleted(){
        return !exeStack.isEmpty();
    }

    public PrgState oneStep() throws MyException {
        if(exeStack.isEmpty())throw new MyException("The stack is empty");
        IStmt crtStmt = exeStack.pop();
        try {
            return crtStmt.execute(this);
        }
        catch(MyException | IOException ex)
        {
            throw new MyException(""+ex);
        }
    }

    public MyIDictionary<String, Integer> getSymTable() {
        return symTable;
    }

    public MyIList<Integer> getOut() {
        return out;
    }

    public MyIStack<IStmt> getStk() {
        return exeStack;
    }

    public MyIFileDictionary<Integer, Pair<String, BufferedReader>> getFileTable() {
        return fileTable;
    }

    public MyIHeap<Integer, Integer> getHeap() {
        return heap;
    }

    public MyIBarrier<Integer,Pair<Integer,ArrayList<Integer>>> getBarrierTable(){return barrier;}

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNewId() {
        this.id += 1;
    }

    public void setExeStack(MyIStack<IStmt> exeStack) {
        this.exeStack = exeStack;
    }

    public void setSymTable(MyIDictionary<String, Integer> symTable) {
        this.symTable = symTable;
    }

    public void setOut(MyIList<Integer> out) {
        this.out = out;
    }

    public void setFileTable(MyIFileDictionary<Integer, Pair<String, BufferedReader>> fileTable) {
        this.fileTable = fileTable;
    }

    @Override
    public String toString() {
        return "id=" + getId();
    }

    public void setBarrier(MyIBarrier<Integer, Pair<Integer, ArrayList<Integer>>> barrier) {
        this.barrier = barrier;
    }
}
