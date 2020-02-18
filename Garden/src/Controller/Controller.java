package Controller;

import Model.FruitTrees;
import Repository.Repo;

public class Controller {
    private Repo repo;

    public Controller(Repo repo) {
        this.repo = repo;
    }

    public void addTree(FruitTrees ft) {
        repo.add(ft);
    }

    public void cutTree(int index) {
        repo.remove(index);
    }

    public String TreesOlderThan(int age) {
        return repo.filter(age);
    }
}
