package Repository;

import Model.Exp;
import javafx.util.Pair;

import java.util.ArrayList;

public class Repository implements IRepository{
    private ArrayList<Exp> repo;

    public Repository()
    {
        this.repo=new ArrayList<>();
    }

    public  void add(Exp e)
    {
        repo.add(e);
    }

    public int size()
    {
        return repo.size();
    }

    public Exp getExp()
    {
     Exp result= repo.get(0);
     repo.remove(0);
     return result;
    }
}