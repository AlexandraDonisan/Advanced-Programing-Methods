package Repository;

import Model.Exp;

public interface IRepository{
    void add(Exp e);
    int size();
    Exp getExp();
}