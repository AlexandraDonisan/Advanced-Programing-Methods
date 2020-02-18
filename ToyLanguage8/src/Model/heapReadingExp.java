package Model;

public class heapReadingExp extends Exp {
    private String variableName;

    public heapReadingExp(String variableName) {
        this.variableName = variableName;
    }

    @Override
    int eval(MyIDictionary<String, Integer> tbl, MyIHeap<Integer, Integer> hp) throws MyException {
        try{
            int heapAddress = tbl.lookup(variableName);
            return hp.lookup(heapAddress);
        }
        catch (MyException ex)
        {
            throw new MyException(""+ex);
        }
    }

    @Override
    public String toString() {
        return "rH(" + variableName +')';
    }
}
