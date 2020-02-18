package Model;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.util.HashMap;

public class FileTable implements MyIFileDictionary<Integer,Pair<String, BufferedReader>>
{
    private int key=0;
    private HashMap<Integer,Pair<String,BufferedReader>> dict;


    public FileTable() {
        this.dict = new HashMap<>();
    }

    @Override
    public boolean isDefined(Integer id) {
        return dict.containsKey(id);
    }

    @Override
    public void update(Integer id, Pair<String, BufferedReader> val) {
        key++;
        dict.put(id,val);
        //return key++;
    }

    @Override
    public void add(Pair<String, BufferedReader> val) {
        key++;
        dict.put(key,val);
        //return key++;
    }

    @Override
    public Pair<String, BufferedReader> lookup(Integer id) throws MyException {
        if(isDefined(id))
            return get(id);
        else
        {
            throw new MyException("variable " + id +" is not defined!");
        }
    }

    @Override
    public int size() {
        return dict.size();
    }

    @Override
    public void remove(Integer key) {
        dict.remove(key);
        this.key--;
    }

    @Override
    public boolean isEmpty() {
        return dict.size()==0;
    }

    @Override
    public Pair<String, BufferedReader> get(Integer key) {
        return dict.get(key);
    }

    public int getKey() {
        return key;
    }

    @Override
    public String toString() {
        StringBuilder result;
        result = new StringBuilder();
        for(int d: this.dict.keySet())
        {
            result.append(d).append(":");
            result.append(this.dict.get(d).getKey());
            result.append("\n");
        }

        if(result.length()==0)
            return "";
        return result.substring(0,result.length()-1);
        //return key+"";
    }
}
