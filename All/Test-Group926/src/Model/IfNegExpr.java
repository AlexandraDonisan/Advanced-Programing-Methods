package Model;

public class IfNegExpr extends Expr {
    private Expr expression1;
    private Expr expression2;

    public IfNegExpr(Expr expression1, Expr expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public Integer eval() {
        if(expression1.eval() < 0)
            return expression2.eval();
        return expression1.eval();
    }
}
