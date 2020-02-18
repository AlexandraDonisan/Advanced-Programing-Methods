package Model;

public class Number extends Exp{
    private int number;

    public Number(int n)
    {
        this.number=n;
    }

    public int eval()
    {
        return this.number;
    }
}