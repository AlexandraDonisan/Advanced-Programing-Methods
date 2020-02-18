package Model;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.util.ArrayList;

public interface MyIFileDictionary<K,V> {
    boolean isDefined(K id);

    void update(K id, V val);

    void add(V val);

    V lookup(K id) throws MyException;

    int size();

    void remove(K key);

    boolean isEmpty();

    int getKey();

    ArrayList<Pair<String, BufferedReader>> getPairs();

    ArrayList<Pair<Integer,String>> getAllPairsWithoutBF();

    ArrayList<Integer> getKeys();

    V get(K key);
}
