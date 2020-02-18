package Main;

import Controller.Controller;
import Model.*;
import Repository.Repo;
import Repository.Repository;

public class Main {
    public static void main(String[] args) {

        Repository repo = new Repo();
        Controller ctr = new Controller(repo);

        Expr ifpos = new IfPosExpr(new Numbers(-2), new Numbers(-28));
        Expr ifneg = new IfNegExpr(new Numbers(-20), ifpos);

        Expr ifpos2 = new IfPosExpr(new Numbers(2), new Abs(new Numbers(28)));
        Expr ifneg2 = new IfNegExpr(new Numbers(-20), ifpos2);

        repo.add(ifneg);
        repo.add(ifneg2);
        ctr.allStep();
    }
}
