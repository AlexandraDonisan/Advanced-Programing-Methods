package Model;

public interface IStmt {
    PrgState execute(PrgState state) throws MyException;
}
