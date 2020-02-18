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
        Exp res = repo.getExp();
        int result = res.eval();
        System.out.println(result);
    }

    public void allStep()
    {
        while(repo.size()!=0)
            oneStep();
    }
}
