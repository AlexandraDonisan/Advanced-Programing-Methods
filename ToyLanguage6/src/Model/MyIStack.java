package Model;

public interface MyIStack<T> {
    T pop();
    void push(T v);
    T top();
    boolean isEmpty();
    int size();
}
