package Repository;

import Model.Expr;

import java.util.ArrayList;

public class Repo implements Repository{
    private ArrayList<Expr> expressions;

    public Repo() {
        this.expressions = new ArrayList<>();
    }

    public Expr getExpr() {
        Expr result = expressions.get(0);
        expressions.remove(0);
        return result;
    }

    public Integer size() {
        return expressions.size();
    }

    @Override
    public void add(Expr ex) {
        this.expressions.add(ex);
    }
}
