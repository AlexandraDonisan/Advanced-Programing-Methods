package Model;

import java.util.Map;
import java.util.Set;

public interface MyIDictionary<K,V> {
    boolean isDefined(K id);

    void update(K id, V val);

    void add(K id, V val);

    V lookup(K id) throws MyException;

    int size();

    void remove(K key);

    boolean isEmpty();

    V get(K key);

    Map<K,V> getContent();

    Set<K> getKeys();
}
