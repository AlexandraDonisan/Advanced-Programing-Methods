package Repository;

import Model.Expr;

public interface Repository {
    Expr getExpr();
    Integer size();
    void add(Expr ex);
}
