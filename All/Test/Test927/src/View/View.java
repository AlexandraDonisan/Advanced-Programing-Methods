package View;

import Controller.Controller;
import Model.*;
import Repository.IRepository;
import Repository.Repository;

import java.util.Collections;

public class View {
    public static void main(String[] args)
    {
        IRepository repo = new Repository();
        Controller ctrl =new Controller(repo);

        Exp or = new Disjunction(new Numbers(0),new Numbers(1));
        Exp and = new Conjunction(new Numbers(0), new Numbers(1));
        Exp not = new Negation(new Numbers(1));

        Exp or2 = new Disjunction(new Numbers(1), new Numbers(1));
        Exp and2 = new Conjunction(or,or2);

        Exp or3 = new Disjunction(new Numbers(0), new Numbers(0));
        Exp and3 = new Conjunction(or,or3);
        Exp not2 = new Negation(and3);

        repo.add(or);
        repo.add(and);
        repo.add(not);

        repo.add(and2);
        repo.add(not2);

        ctrl.allStep();
    }
}
