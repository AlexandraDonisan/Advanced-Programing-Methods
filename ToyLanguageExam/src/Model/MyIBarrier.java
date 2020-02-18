package Model;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Map;

public interface MyIBarrier<K,V> {
    void add(V val);
    void update(V val,K key);
    V lookup(K key) throws MyException;
    boolean isDefined(K key);
    int size();
    void remove(K key);
    boolean isEmpty();
    V get(K key);
    int getKey();
    void setContent(Map<K,V> m);
    Map<K,V> getContent();

    ArrayList<Pair<Integer, Pair<Integer,ArrayList<Integer>>>> getAllBarrier();
}
