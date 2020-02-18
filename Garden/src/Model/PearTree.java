package Model;

public class PearTree implements FruitTrees{
    private int age;
    private int height;
    private String type;

    public PearTree(int age, int height, String type) {
        this.age = age;
        this.height = height;
        this.type = type;
    }

    public int getAge()
    {
        return this.age;
    }

    @Override
    public String toString() {
        return "PearTree{" +
                "age=" + age +
                ", height=" + height +
                ", type='" + type + '\'' +
                '}'+ '\n';
    }
}
