package View;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Scanner;
import Controller.Controller;
import Model.*;
import Repository.IRepository;
import Repository.Repository;
import javafx.util.Pair;

public class View {

    public static void menu()
    {
        System.out.println("MENU");
        System.out.println("1.\tv=2;Print(v)");
        System.out.println("2.\ta=2+3*5;b=a+1;Print(b)");
        System.out.println("3.\ta=2-2;(If a Then v=2 Else v=3);Print(v)");
    }

    /*public static void main(String[] argv)
    {
        MyIStack<IStmt> exeStack = new MyStack<>();
        MyIDictionary<String, Integer> symTable = new MyDictionary<>();
        MyIList<Integer> out = new MyList<>();
        MyIFileDictionary<Integer, Pair<String, BufferedReader>> fileTable = new FileTable();

        //Example 1
        // v=2;Print(v)

        IStmt ex1= new CompStmt(new AssignStmt("v",new ConstExp(2)), new PrintStmt(new
                VarExp("v")));

        //Example2:
        //a=2+3*5;b=a+1;Print(b) is represented as:
        IStmt ex2 = new CompStmt(new AssignStmt("a", new ArithExp(0,new ConstExp(2),
                new ArithExp(3,new ConstExp(3), new ConstExp(5)))),
                new CompStmt(new AssignStmt("b",new ArithExp(0,new VarExp("a"),
                        new ConstExp(1))), new PrintStmt(new VarExp("b"))));

        //Example3:
        //a=2-2;(If a Then v=2 Else v=3);Print(v) is represented as
        IStmt ex3 = new CompStmt(new AssignStmt("a", new ArithExp(2,new ConstExp(2), new
                ConstExp(2))),
                new CompStmt(new IfStmt(new VarExp("a"),new AssignStmt("v",new ConstExp(2)), new
                        AssignStmt("v", new ConstExp(3))), new PrintStmt(new VarExp("v"))));

        //Example 4:
        //a=5*3/0;Print(a)

        IStmt ex4 = new CompStmt(new AssignStmt("a",new ArithExp(4,new ArithExp(3,new ConstExp(5),new ConstExp(3)),
                new ConstExp(0))),new PrintStmt(new VarExp("a")));

        //Example 5:
        //a=14/7-2*6;(If a Then v=a Else v=0);Print(v)

        IStmt ex5 = new CompStmt(new AssignStmt("a",new ArithExp(2,new ArithExp(4,new ConstExp(14),new ConstExp(7)),
                new ArithExp(3,new ConstExp(2),new ConstExp(6)))),new CompStmt(new IfStmt(new VarExp("a"),
                new AssignStmt("v",new VarExp("a")), new AssignStmt("v", new ConstExp(0))),new PrintStmt(new VarExp("v"))));

        //PrgState prg = new PrgState(exeStack, symTable, out, ex1);

        //IRepository repo = new Repository(prg);

        //Controller ctrl = new Controller(repo);

        //ctrl.allStep();

        int option=-1;
        Scanner input = new Scanner(System.in);
        while(option!=0)
        {
            menu();
            System.out.println("Choose an option: ");
            option=input.nextInt();
            HashMap<Integer,IStmt> m=new HashMap<>();
            m.put(1,ex1);
            m.put(2,ex2);
            m.put(3,ex3);

            if(m.containsKey(option))
            {
                PrgState prg = new PrgState(exeStack, symTable, out,fileTable, m.get(option));
                IRepository repo = new Repository(prg,"test.in");
                Controller ctrl = new Controller(repo);
                ctrl.allStep();
            }

        }

    }*/
}