package Model;

import java.io.IOException;
//switch(exp) (case exp1: stmt1) (case exp2: stmt2) (default: stmt3)
/*
It is a switch statement that executes either the statement stmt1 when
exp==exp1, or the statement stmt2 when exp==exp2 or the statement stmt3
otherwise.
Its execution on the ExeStack is the following:
- pop the statement
- create the following statement:
 if(exp==exp1) then stmt1 else (if (exp==exp2) then stmt2 else stmt3)
- push the new statement on the stack

 */

public class SwitchStmt implements IStmt {
    private Exp exp;
    private Exp exp1;
    private Exp exp2;
    private IStmt stmt1;
    private IStmt stmt2;
    private IStmt stmt3;

    public SwitchStmt(Exp exp, Exp exp1, Exp exp2,IStmt stmt1, IStmt stmt2, IStmt stmt3) {
        this.exp = exp;
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.stmt1 = stmt1;
        this.stmt2 = stmt2;
        this.stmt3 = stmt3;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException, IOException {
        MyIStack<IStmt> stk = state.getStk();
        MyIDictionary<String, Integer> tbl = state.getSymTable();
        MyIHeap<Integer, Integer> hp = state.getHeap();
        if(exp.eval(tbl,hp)==exp1.eval(tbl,hp))
            stk.push(stmt1);
        else if (exp.eval(tbl,hp)==exp2.eval(tbl,hp))
            stk.push(stmt2);
        else
            stk.push(stmt3);
        return null;
    }

    //switch(exp) (case exp1: stmt1) (case exp2: stmt2) (default: stmt3)
    public String toString()
    {
        return "switch("+exp+") (case "+exp1+": "+stmt1+") (case "+exp2+": "+stmt2+") (default: "+stmt3+")";
    }


    public Exp getExp() {
        return exp;
    }

    public void setExp(Exp exp) {
        this.exp = exp;
    }

    public Exp getExp1() {
        return exp1;
    }

    public void setExp1(Exp exp1) {
        this.exp1 = exp1;
    }

    public Exp getExp2() {
        return exp2;
    }

    public void setExp2(Exp exp2) {
        this.exp2 = exp2;
    }

    public IStmt getStmt1() {
        return stmt1;
    }

    public void setStmt1(IStmt stmt1) {
        this.stmt1 = stmt1;
    }

    public IStmt getStmt2() {
        return stmt2;
    }

    public void setStmt2(IStmt stmt2) {
        this.stmt2 = stmt2;
    }

    public IStmt getStmt3() {
        return stmt3;
    }

    public void setStmt3(IStmt stmt3) {
        this.stmt3 = stmt3;
    }
}
