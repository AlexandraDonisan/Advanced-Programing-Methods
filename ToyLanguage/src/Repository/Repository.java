package Repository;

import Model.MyException;
import Model.PrgState;

import java.util.Arrays;

public class Repository implements IRepository{
    private PrgState prg;

    public Repository(PrgState prg) {
        this.prg = prg;
    }

    @Override
    public PrgState getCtrPrg(){
        return prg;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "prg=" + prg +
                '}';
    }
}
