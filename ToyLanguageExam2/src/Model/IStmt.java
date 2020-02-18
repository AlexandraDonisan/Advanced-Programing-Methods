package Model;

import java.io.IOException;

public interface IStmt {
    PrgState execute(PrgState state) throws MyException, IOException;
}
