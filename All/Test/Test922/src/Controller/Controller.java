package Controller;

import Model.Exp;
import Repository.IRepository;

public class Controller {
    private IRepository repo;

    public Controller(IRepository repo) {
        this.repo = repo;
    }

    public void oneStep()
    {
        Exp e = repo.getExp();
        System.out.println(e.toString());
        int res = e.eval();
        System.out.println(res);
    }

    public void allStep()
    {
        while(repo.size()!=0)
            oneStep();
    }
}
