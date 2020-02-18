package Model;

public class ConstExp extends Exp {
    private int number;

    public ConstExp(int number) {
        this.number = number;
    }

    int eval(MyIDictionary<String,Integer> tbl) {return number;}

    @Override
    public String toString() {
        return "ConstExp{" +
                "number=" + number +
                '}';
    }
}
