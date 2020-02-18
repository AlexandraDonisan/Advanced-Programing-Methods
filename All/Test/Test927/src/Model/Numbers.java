package Model;

public class Numbers extends Exp{
    private int number;

    public Numbers(int n)
    {
        this.number=n;
    }

    public int eval()
    {
        return this.number;
    }
}
