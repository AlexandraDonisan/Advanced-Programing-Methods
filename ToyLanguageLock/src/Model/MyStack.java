package Model;

import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EmptyStackException;

public class MyStack<T> implements MyIStack<T> {
    private ArrayList<T> stack;

    public MyStack() {
        this.stack = new ArrayList<T>();
    }

    @Override
    public T pop() {
        if(!isEmpty())
        {
            return stack.remove(size()-1);
        }
        else
            throw new EmptyStackException();

    }

    @Override
    public void push(T v) {
        stack.add(v);
    }

    @Override
    public boolean isEmpty() {
        return (stack.size() == 0);
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public ArrayList<String> getAllStack() {
        ArrayList<String> arr = new ArrayList<>();
        stack.forEach(el->arr.add(el.toString()));
        Collections.reverse(arr);
        return arr;
    }

    @Override
    public T top() {
        if(!isEmpty())
            return stack.get(stack.size()-1);
        else
            throw new EmptyStackException();
    }

    @Override
    public String toString() {
        return String.valueOf(stack);
    }
}
