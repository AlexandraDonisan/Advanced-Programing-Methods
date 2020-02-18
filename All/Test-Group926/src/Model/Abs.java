package Model;

public class Abs extends Expr {
    private Expr expression;

    public Abs(Expr expression) {
        this.expression = expression;
    }

    @Override
    public Integer eval() {
        return Math.abs(expression.eval());
    }
}
