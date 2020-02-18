package Model;

import javafx.util.Pair;

import java.io.BufferedReader;

public interface MyIFileDictionary<K,V> {
    boolean isDefined(K id);

    void update(K id, V val);

    void add(V val);

    V lookup(K id) throws MyException;

    int size();

    void remove(K key);

    boolean isEmpty();

    int getKey();

    V get(K key);
}
