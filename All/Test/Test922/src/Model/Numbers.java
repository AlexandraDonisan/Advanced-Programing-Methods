package Model;

public class Numbers extends Exp{
    private int number;

    public Numbers(int number) {
        this.number = number;
    }

    public int eval()
    {
        return this.number;
    }
}
