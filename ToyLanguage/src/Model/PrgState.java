package Model;

public class PrgState {
    private MyIStack<IStmt> exeStack;
    private MyIDictionary<String,Integer> symTable;
    private MyIList<Integer> out;
    IStmt originalProgram;

    public PrgState(MyIStack<IStmt> exeStack, MyIDictionary<String, Integer> symTable, MyIList<Integer> out, IStmt prg) {
        this.exeStack = exeStack;
        this.symTable = symTable;
        this.out = out;
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

    public void setExeStack(MyIStack<IStmt> exeStack) {
        this.exeStack = exeStack;
    }

    public void setSymTable(MyIDictionary<String, Integer> symTable) {
        this.symTable = symTable;
    }

    public void setOut(MyIList<Integer> out) {
        this.out = out;
    }

    @Override
    public String toString() {
        return "PrgState{" +
                "exeStack=" + exeStack +
                ",\n symTable=" + symTable +
                ",\n out=" + out +
                '}';
    }
}
