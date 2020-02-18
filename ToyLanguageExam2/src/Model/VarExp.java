package Model;

public class VarExp extends Exp {
    private String id;

    public VarExp(String id) {
        this.id = id;
    }

    int eval(MyIDictionary<String,Integer> tbl,MyIHeap<Integer,Integer> hp) throws MyException {
        try {
            return tbl.lookup(id);
        }
        catch (MyException ex)
        {
            throw new MyException(""+ex);
        }
    }

    @Override
    public String toString() {
        return id;
    }
}
