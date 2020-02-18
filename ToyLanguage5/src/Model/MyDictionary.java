package Model;
import java.util.HashMap;
import java.util.Map;

public class MyDictionary<K, V> implements MyIDictionary<K, V> {
    private HashMap<K, V> dict;

    public MyDictionary() {
        this.dict = new HashMap<>();
    }

    @Override
    public boolean isEmpty() {
        return dict.size()==0;
    }

    @Override
    public int size() {
        return dict.size();
    }

    @Override
    public V get(K key) {
        return dict.get(key);
    }

    @Override
    public Map<K, V> getContent() {
        return this.dict;
    }

    @Override
    public void remove(K key) {
        dict.remove(key);
    }

    @Override
    public boolean isDefined(K id) {
        return dict.containsKey(id);
    }

    @Override
    public void add(K id, V val) {
        dict.put(id,val);
    }

    @Override
    public void update(K id, V val) {
        dict.put(id,val);
    }

    @Override
    public V lookup(K id) throws MyException {
        if(isDefined(id))
            return get(id);
        else
        {
            throw new MyException("variable " + id +" is not defined");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(dict);
    }
}
