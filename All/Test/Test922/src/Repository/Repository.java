package Repository;

import Model.Exp;

import java.util.ArrayList;

public class Repository implements IRepository {
    private ArrayList<Exp> repo;

    public Repository()
    {
        this.repo = new ArrayList<>();
    }

    @Override
    public void add(Exp e) {
        repo.add(e);
    }

    @Override
    public int size() {
        return repo.size();
    }

    @Override
    public Exp getExp() {
        Exp res = repo.get(0);
        repo.remove(0);
        return res;
    }
}
