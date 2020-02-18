package Repository;

import Model.MyException;
import Model.PrgState;

import java.io.IOException;

public interface IRepository {
    PrgState getCtrPrg();
    void logPrgStateExec();
    void clearData();
}
