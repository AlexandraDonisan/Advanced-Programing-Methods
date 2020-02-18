package View;

import Controller.Controller;
import Model.*;
import Repository.IRepository;
import Repository.Repository;

public class View {
    public static void main(String[] args)
    {
        IRepository repo = new Repository();
        Controller ctrl = new Controller(repo);

        Exp add = new Addition(new Numbers(2),new Numbers(10));
        Exp mul = new Multiplication(new Numbers(3),new Numbers(8));
        Exp mod = new Modulo(new Numbers(2));

        Exp mul2 = new Multiplication(new Numbers(7), new Numbers(4));
        Exp add2 = new Addition(add, mul2);

        repo.add(add);
        repo.add(mul);
        repo.add(mod);
        repo.add(add2);

        ctrl.allStep();


    }
}
