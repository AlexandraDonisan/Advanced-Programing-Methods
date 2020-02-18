package Repository;

import Model.MyException;
import Model.PrgState;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface IRepository {
    void addPrgState(PrgState prg);
    List<PrgState> getPrgList();
    void setPrgList(List<PrgState> p);
    void logPrgStateExec(PrgState p);
    void clearData();
}
