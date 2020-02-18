package Model;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;

public class closeRFile implements IStmt {
    private Exp exp_file_id;

    public closeRFile(Exp exp_file_id) {
        this.exp_file_id = exp_file_id;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException, IOException {
        MyIDictionary<String,Integer> symTbl = state.getSymTable();
        MyIFileDictionary<Integer, Pair<String, BufferedReader>> fileTable = state.getFileTable();
        MyIHeap<Integer,Integer> hp = state.getHeap();
        try
        {
            int val = exp_file_id.eval(symTbl,hp);
            Pair<String,BufferedReader> p = fileTable.lookup(val);
            BufferedReader br = p.getValue();
            br.close();
            fileTable.remove(val); //not Sure
        }
        catch (MyException ex) {
            throw new MyException("" + ex);
        }

        return  state;
    }

    @Override
    public String toString() {
        return "closeRFile(" +exp_file_id +')';
    }
}
