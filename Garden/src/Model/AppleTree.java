package Model;

public class AppleTree implements FruitTrees{
    private int age;
    private String type;
    private String color;

    public AppleTree(int age, String type, String color) {
        this.age = age;
        this.type = type;
        this.color = color;
    }

    public int getAge()
    {
        return this.age;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "AppleTree{" +
                "age=" + age +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                '}' + '\n';
    }
}
