package Model;

import java.io.IOException;

public class ForStmt implements IStmt {
    private String variableName;
    private Exp expr1;
    private Exp expr2;
    private Exp expr3;
    private IStmt stmt;

    public ForStmt(String varName,Exp expr1, Exp expr2, Exp expr3, IStmt s) {
        this.expr1 = expr1;
        this.expr2 = expr2;
        this.expr3 = expr3;
        this.variableName = varName;
        this.stmt =s;
    }


    @Override
    public PrgState execute(PrgState state) throws MyException, IOException {
        //v=exp1;(while(v<exp2) stmt;v=exp3)
        MyIStack<IStmt> stk = state.getStk();
        AssignStmt assign=new AssignStmt(variableName,expr1);
        AssignStmt assign2 = new AssignStmt(variableName,expr3);
        CompStmt newStmt = new CompStmt(stmt,assign2);
        WhileStmt wh = new WhileStmt(new BooleanExp(new VarExp(variableName),expr2,"<"),newStmt);

        IStmt forStmt= new CompStmt(assign,wh);


        //stk.push(new CompStmt(wh,assign2));
        //stk.push(assign);

        IStmt whileStmt = new CompStmt(new AssignStmt(variableName,expr1),
                new WhileStmt(
                        new BooleanExp(new VarExp(variableName),expr2,"<"),
                        new CompStmt(stmt,new AssignStmt(variableName,expr3))));

        //stk.push(forStmt);
        stk.push(whileStmt);
        return null;
    }

    public String toString()
    {
        return "for("+variableName+"="+expr1+"; "+variableName+"<"+expr2+"; "+variableName+"="+expr3+")"+"{"+stmt +"}";

    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public Exp getExpr1() {
        return expr1;
    }

    public void setExpr1(Exp expr1) {
        this.expr1 = expr1;
    }

    public Exp getExpr2() {
        return expr2;
    }

    public void setExpr2(Exp expr2) {
        this.expr2 = expr2;
    }

    public Exp getExpr3() {
        return expr3;
    }

    public void setExpr3(Exp expr3) {
        this.expr3 = expr3;
    }

    public IStmt getStmt() {
        return stmt;
    }

    public void setStmt(IStmt stmt) {
        this.stmt = stmt;
    }
}
