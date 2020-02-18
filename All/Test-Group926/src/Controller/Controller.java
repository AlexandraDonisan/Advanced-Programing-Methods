package Controller;

import Model.Expr;
import Repository.Repository;

public class Controller {
    private Repository repo;

    public Controller(Repository repo) {
        this.repo = repo;
    }

    private void oneStep() {
        Expr expression = this.repo.getExpr();
        System.out.println(expression);
        Integer result = expression.eval();
        System.out.println(result);
    }

    public void allStep() {
        while(repo.size() != 0)
            oneStep();
    }
}
