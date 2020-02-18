package Model;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readFile implements IStmt{
    private Exp exp_file_id;
    private String var_name;

    public readFile(Exp exp_file_id, String var_name) {
        this.exp_file_id = exp_file_id;
        this.var_name = var_name;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException, IOException {
        MyIDictionary<String,Integer> symTbl = state.getSymTable();
        MyIFileDictionary<Integer, Pair<String, BufferedReader>> fileTable = state.getFileTable();
        MyIHeap<Integer,Integer> hp = state.getHeap();
        try {
            int val = exp_file_id.eval(symTbl,hp);
            fileTable.lookup(val);
            BufferedReader br = fileTable.get(val).getValue();
            String line = br.readLine();

            int value,x;
            if(line==null)
                value=0;
            else
                value=Integer.parseInt(line);

            if(symTbl.isDefined(var_name))
                symTbl.update(var_name,value);
            else
                symTbl.add(var_name,value);
        }
        catch(MyException e)
        {
            throw new MyException(""+e);
        }
        return  null;
    }

    @Override
    public String toString() {
        return "ReadFile(" +
                exp_file_id +
                ", \"" + var_name + '\"'+")";

    }


}
