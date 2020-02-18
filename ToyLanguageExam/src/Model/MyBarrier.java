package Model;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyBarrier implements MyIBarrier<Integer, Pair<Integer, ArrayList<Integer>>> {
    private static java.util.concurrent.locks.Lock lock = new java.util.concurrent.locks.ReentrantLock();
    private HashMap<Integer,Pair<Integer,ArrayList<Integer>>> barrier;
    private int key=0;

    public MyBarrier() {
        this.barrier = new HashMap<>();
    }

    @Override
    public void add(Pair<Integer, ArrayList<Integer>> val) {
        lock.lock();
        key++;
        barrier.put(key,val);
        lock.unlock();
    }

    @Override
    public void update(Pair<Integer, ArrayList<Integer>> val,Integer k) {
        lock.lock();
        barrier.put(k,val);
        lock.unlock();
    }

    @Override
    public Pair<Integer, ArrayList<Integer>> lookup(Integer key) throws MyException {
        if(isDefined(key))
            return get(key);
        else
        {
            throw new MyException("Variable "+key+" is not defined!");
        }
    }

    @Override
    public boolean isDefined(Integer key) {
        return barrier.containsKey(key);
    }

    @Override
    public int size() {
        return barrier.size();
    }

    @Override
    public void remove(Integer key) {
        barrier.remove(key);
    }

    @Override
    public boolean isEmpty() {
        return barrier.size()==0;
    }

    @Override
    public Pair<Integer, ArrayList<Integer>> get(Integer key) {
        return barrier.get(key);
    }

    @Override
    public int getKey() {
        return this.key;
    }

    @Override
    public void setContent(Map<Integer, Pair<Integer, ArrayList<Integer>>> m) {
        this.barrier = (HashMap<Integer,Pair<Integer,ArrayList<Integer>>>) m;
    }

    @Override
    public Map<Integer, Pair<Integer, ArrayList<Integer>>> getContent() {
        return this.barrier;
    }

    ///CAUTION HERE
    @Override
    public ArrayList<Pair<Integer, Pair<Integer,ArrayList<Integer>>>> getAllBarrier() {
        ArrayList<Pair<Integer, Pair<Integer,ArrayList<Integer>>>> arr = new ArrayList<>();
        barrier.forEach((k,u)->arr.add(new Pair<>(k,u)));
        return arr;
    }
}
