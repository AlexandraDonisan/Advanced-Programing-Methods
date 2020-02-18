package Model;

import java.util.ArrayList;
import java.util.List;

public class MyList<T> implements MyIList<T> {
    private ArrayList<T> list;

    public MyList() {
        this.list = new ArrayList<>();
    }

    @Override
    public void add(T elem) {
        list.add(elem);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public void remove(int position) {
        list.remove(position);
    }

    @Override
    public ArrayList<String> getOutList() {
        ArrayList<String> getOut = new ArrayList<>();
        list.forEach(el->getOut.add(el.toString()));
        return getOut;
    }

    public List<T> getList() {
        return list;
    }

    @Override
    public String toString() {
        return String.valueOf(list);
    }
}
