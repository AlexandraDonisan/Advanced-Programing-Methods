package Model;

public interface MyIList<T> {
    void add(T elem);
    int size();
    boolean isEmpty();
    void remove(int position);
}
