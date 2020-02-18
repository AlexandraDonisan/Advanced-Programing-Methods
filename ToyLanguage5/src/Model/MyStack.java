package Model;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class MyStack<T> implements MyIStack<T> {
    //Type<T> stack;    //a field whose type Type is an appropriate generic java library collection
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
