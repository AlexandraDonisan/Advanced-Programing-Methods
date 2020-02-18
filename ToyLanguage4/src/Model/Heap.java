package Model;

import java.util.HashMap;
import java.util.Map;

public class Heap implements MyIHeap<Integer,Integer> {
    private HashMap<Integer, Integer> heap;
    private int key=0;

    public Heap()
    {
        this.heap = new HashMap<>();
    }

    @Override
    public void add(Integer val) {
        key++;
        heap.put(key,val);
    }

    @Override
    public void update(Integer k,Integer val) {
        //key++;
        heap.put(k,val);
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
        return heap.containsKey(key);
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public void remove(Integer key) {
        heap.remove(key);
    }

    @Override
    public boolean isEmpty() {
        return heap.size()==0;
    }

    @Override
    public Integer get(Integer key) {
        return heap.get(key);
    }

    public int getKey()
    {
        return this.key;
    }

    @Override
    public void setContent(Map<Integer, Integer> m) {
        this.heap = (HashMap<Integer, Integer>) m;
    }

    @Override
    public Map<Integer, Integer> getContent() {
        return this.heap;
    }

    @Override
    public String toString() {
        //return "{" + key + "->" + heap.get(key) +'}';
        return String.valueOf(heap);
    }
}

