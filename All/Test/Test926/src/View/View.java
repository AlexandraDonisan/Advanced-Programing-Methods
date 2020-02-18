package View;

import Controller.Controller;
import Model.*;
import Model.Number;
import Repository.IRepository;
import Repository.Repository;

public class View{
    public static void main(String[] args)
    {
        IRepository repo = new Repository();
        Controller ctrl = new Controller(repo);

        Exp ifpos = new IfPosExp(new Number(-2),new Number(-28));
        Exp ifneg = new IfNegExp(new Number(-20),ifpos);

        Exp ifpos2 = new IfPosExp(new Number(2),new Abs(new Number(28)));
        Exp ifneg2 = new IfNegExp(new Number(-20),ifpos2);

        repo.add(ifneg);
        repo.add(ifneg2);

        ctrl.allStep();
    }
}