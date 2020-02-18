package Repository;

import Model.FruitTrees;

public interface Repository {
    void add(FruitTrees tree) throws RuntimeException;
    void remove(int index) throws RuntimeException;
    String filter(int age);
    FruitTrees[] getAll();
}
