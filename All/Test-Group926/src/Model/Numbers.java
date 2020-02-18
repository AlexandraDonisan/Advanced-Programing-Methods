package Model;

public class Numbers extends Expr {
    private Integer number;

    public Numbers(Integer number) {
        this.number = number;
    }

    @Override
    public Integer eval() {
        return number;
    }
}
