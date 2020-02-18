package Model;

import javafx.util.Pair;

import java.io.BufferedReader;

public class PrgState {
    private MyIStack<IStmt> exeStack;
    private MyIDictionary<String,Integer> symTable;
    private MyIList<Integer> out;
    private MyIFileDictionary<Integer, Pair<String, BufferedReader>> fileTable;
    private  MyIHeap<Integer,Integer> heap;
    IStmt originalProgram;

    public PrgState(MyIStack<IStmt> exeStack, MyIDictionary<String, Integer> symTable, MyIList<Integer> out, MyIFileDictionary<Integer, Pair<String, BufferedReader>> fileTable,MyIHeap<Integer,Integer> heap,IStmt prg) {
        this.exeStack = exeStack;
        this.symTable = symTable;
        this.out = out;
        this.fileTable = fileTable;
        this.heap=heap;
        //this.originalProgram = deepCopy(prg);
        exeStack.push(prg);
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
        return "PrgState{\n" +
                "exeStack=" + exeStack +
                ",\n symTable=" + symTable +
                ",\n out=" + out +
                ",\n fileTable=" + fileTable +
                ",\n heap=" + heap +
                "}\n";
    }
}
