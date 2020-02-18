package Model;

import java.util.Map;

public interface MyIHeap<K,V> {
    void add(V val);
    void update(K key,V val);
    V lookup(K key) throws MyException;
    boolean isDefined(K key);
    int size();
    void remove(K key);
    boolean isEmpty();
    V get(K key);
    int getKey();
    void setContent(Map<K,V> m);
    Map<K,V> getContent();
}
