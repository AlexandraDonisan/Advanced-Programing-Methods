package Model;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class openRFile implements IStmt {
    private String var_file_id;
    private String filename;

    public openRFile(String var_file_id, String filename) {
        this.var_file_id = var_file_id;
        this.filename = filename;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException, IOException {
        MyIFileDictionary<Integer, Pair<String, BufferedReader>> dict = state.getFileTable();
        try {
            for (int i = 0; i < dict.size(); i++) {
                if (dict.lookup(i).getKey().equals(filename))
                    throw new MyException("Filename already exists!");
            }
            BufferedReader br = null;
            FileReader fr = null;
            try {
                fr = new FileReader(filename);
                br = new BufferedReader(fr);
                Pair<String, BufferedReader> p = new Pair<>(filename,br);
                dict.add(p);
                int lastKey =dict.getKey();
                MyIDictionary<String,Integer> symTbl = state.getSymTable();
                symTbl.add(var_file_id,lastKey);
            } catch (IOException e) {
                throw new IOException(e);
            }
        } catch (MyException ex) {
            throw new MyException("" + ex);
        }
        return  state;
    }

    @Override
    public String toString() {
        return "OpenFile(" +
                var_file_id +
                "," +'\"' +filename + '\"'+")";
    }
}
