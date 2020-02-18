package Repository;

import Model.FruitTrees;

public class Repo implements Repository {
    private FruitTrees[] trees;
    private int position;

    public Repo(int size) {
        this.trees = new FruitTrees[size];
    }

    public void add(FruitTrees t) {
        if (position == trees.length)
            throw new RuntimeException("Capacity exceeded");
        else {
            trees[position] = t;
            position++;
        }
    }

    public void remove(int index) {
        if (index > position)
            throw new RuntimeException("Index out of range!");
        if (position - 1 - index >= 0) {
            System.arraycopy(trees, index + 1, trees, index, position - 1 - index);
            position--;
        }
    }

    public String filter(int age) {
        StringBuilder result = new StringBuilder();
        //for (FruitTrees t : trees) {
        //if (t.getAge() > age)
        //result.append(t.toString());
        //}
        for (int i = 0; i < position; i++) {
            if (trees[i].getAge() > age)
                result.append(trees[i].toString());
        }
        return result.toString();
    }

    public FruitTrees[] getAll() {
        FruitTrees[] t = new FruitTrees[position];
        System.arraycopy(this.trees, 0, t, 0, position);
        return t;
    }
}
