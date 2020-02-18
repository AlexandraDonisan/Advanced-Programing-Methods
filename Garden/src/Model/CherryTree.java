package Model;

public class CherryTree implements FruitTrees{
    private int age;
    private int height;

    public CherryTree(int age, int height) {
        this.age = age;
        this.height = height;
    }

    public int getAge()
    {
        return this.age;
    }

    @Override
    public String toString() {
        return "CherryTree{" +
                "age=" + age +
                ", height=" + height +
                '}'+ '\n';
    }
}
