package Model;

import java.util.ArrayList;

public interface MyIStack<T> {
    T pop();
    void push(T v);
    T top();
    boolean isEmpty();
    int size();

    ArrayList<String> getAllStack();
}
