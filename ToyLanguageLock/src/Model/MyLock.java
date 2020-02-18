package Model;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyLock implements MyILock<Integer,Integer>{
    private HashMap<Integer, Integer> lock;
    private int key=0;

    public MyLock()
    {
        this.lock = new HashMap<>();
    }

    @Override
    public void add(Integer val) {
        key++;
        lock.put(key,val);
    }

    @Override
    public void update(Integer k,Integer val) {
        //key++;
        lock.put(k,val);
    }

    @Override
    public Integer lookup(Integer key) throws MyException {
        if(isDefined(key))
            return get(key);
        else
        {
            throw new MyException("Variable "+key+" is not defined!");
        }
    }

    @Override
    public boolean isDefined(Integer key) {
        return lock.containsKey(key);
    }

    @Override
    public int size() {
        return lock.size();
    }

    @Override
    public void remove(Integer key) {
        lock.remove(key);
    }

    @Override
    public boolean isEmpty() {
        return lock.size()==0;
    }

    @Override
    public Integer get(Integer key) {
        return lock.get(key);
    }

    public int getKey()
    {
        return this.key;
    }

    @Override
    public void setContent(Map<Integer, Integer> m) {
        this.lock = (HashMap<Integer, Integer>) m;
    }

    @Override
    public Map<Integer, Integer> getContent() {
        return this.lock;
    }

    @Override
    public ArrayList<Pair<Integer, Integer>> getAllLocks() {
        ArrayList<Pair<Integer, Integer>> arr = new ArrayList<>();
        lock.forEach((k,u)->arr.add(new Pair<>(k,u)));
        return arr;
    }

    @Override
    public String toString() {
        //return "{" + key + "->" + heap.get(key) +'}';
        return String.valueOf(lock);
    }
}

