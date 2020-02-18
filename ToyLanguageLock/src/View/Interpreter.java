package View;

import Controller.Controller;
import Model.*;
import Repository.IRepository;
import Repository.Repository;
import javafx.util.Pair;
import java.io.BufferedReader;

public class Interpreter {

    public static void main(String[] args)
    {
        /*
        MyIStack<IStmt> exeStack = new MyStack<>();
        MyIDictionary<String, Integer> symTable = new MyDictionary<>();
        MyIList<Integer> out = new MyList<>();
        MyIFileDictionary<Integer, Pair<String, BufferedReader>> fileTable = new FileTable();
        MyIHeap<Integer,Integer> heap = new Heap();


        //Example 1
        // v=2;Print(v)
        IStmt ex1= new CompStmt(new AssignStmt("v",new ConstExp(2)), new PrintStmt(new
                VarExp("v")));
        PrgState prg1 = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(),new FileTable(),new Heap(),new  ex1);
        //IRepository repo1 = new Repository(prg1,"log1.txt");
        IRepository repo1 = new Repository("log1.txt");
        Controller ctrl1 = new Controller(repo1);
        repo1.addPrgState(prg1);


        //Example2:
        //a=2+3*5;b=a+1;Print(b) is represented as:
        IStmt ex2 = new CompStmt(new AssignStmt("a", new ArithExp(1,new ConstExp(2),
                new ArithExp(3,new ConstExp(3), new ConstExp(5)))),
                new CompStmt(new AssignStmt("b",new ArithExp(1,new VarExp("a"),
                        new ConstExp(1))), new PrintStmt(new VarExp("b"))));
        PrgState prg2 = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(),new FileTable(),new Heap(),ex2);
        IRepository repo2 = new Repository("log2.txt");
        Controller ctrl2 = new Controller(repo2);
        repo2.addPrgState(prg2);

        //Example3:
        //a=2-2;(If a Then v=2 Else v=3);Print(v) is represented as
        IStmt ex3 = new CompStmt(new AssignStmt("a", new ArithExp(2,new ConstExp(2), new
                ConstExp(2))),
                new CompStmt(new IfStmt(new VarExp("a"),new AssignStmt("v",new ConstExp(2)), new
                        AssignStmt("v", new ConstExp(3))), new PrintStmt(new VarExp("v"))));
        PrgState prg3 = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(),new FileTable(),new Heap(),ex3);
        IRepository repo3 = new Repository("log3.txt");
        Controller ctrl3 = new Controller(repo3);
        repo3.addPrgState(prg3);

        //Example 4:

        //openRFile(var_f,"test.in");
        //readFile(var_f,var_c);print(var_c);
        //(if var_c then readFile(var_f,var_c);print(var_c)
        //else print(0));
        //closeRFile(var_f)



        IStmt ex4 = new CompStmt(new openRFile("var_f","test.txt"),new CompStmt( new readFile(new VarExp("var_f"),"var_c"),
                new CompStmt(new PrintStmt(new VarExp("var_c")),new CompStmt(new IfStmt(new VarExp("var_c"),
                        new CompStmt(new readFile(new VarExp("var_f"),"var_c"),new PrintStmt(new VarExp("var_c"))),
                        new PrintStmt(new ConstExp(0))),new closeRFile(new VarExp("var_f"))))));
        //IStmt ex4 = new openRFile("var_f","test.txt");
        PrgState prg4 = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(),new FileTable(),new Heap(),ex4);
        IRepository repo4 = new Repository("log4.txt");
        Controller ctrl4 = new Controller(repo4);
        repo4.addPrgState(prg4);

        //Example 5:

        //openRFile(var_f,"test.in");
        //readFile(var_f+2,var_c);print(var_c);
        //(if var_c then readFile(var_f,var_c);print(var_c)
        //else print(0));
        //closeRFile(var_f)

        IStmt ex5 = new CompStmt(new openRFile("var_f","test.txt"),new CompStmt( new readFile(new ArithExp(1,new VarExp("var_f"),new ConstExp(2)),"var_c"),
                new CompStmt(new PrintStmt(new VarExp("var_c")),new CompStmt(new IfStmt(new VarExp("var_c"),
                        new CompStmt(new readFile(new VarExp("var_f"),"var_c"),new PrintStmt(new VarExp("var_c"))),
                        new PrintStmt(new ConstExp(0))),new closeRFile(new VarExp("var_f"))))));
        PrgState prg5 = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(),new FileTable(),new Heap(),ex5);
        IRepository repo5 = new Repository("log5.txt");
        Controller ctrl5 = new Controller(repo5);
        repo5.addPrgState(prg5);

        //Example 6

        //   v=10;new(v,20);new(a,22);print(v)

        IStmt ex6 = new CompStmt(new AssignStmt("v",new ConstExp(10)),new CompStmt(new NewStmt("v",new ConstExp(20)),new CompStmt(new NewStmt("a",new ConstExp(22)),new PrintStmt(new VarExp("v")))));
        PrgState prg6 = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(),new FileTable(),new Heap(),ex6);
        IRepository repo6 = new Repository("log6.txt");
        Controller ctrl6 = new Controller(repo6);
        repo6.addPrgState(prg6);

        //Example 7

        //v=10;new(v,20);new(a,22);print(100+rH(v));print(100+rH(a))

        IStmt ex7 = new CompStmt(new AssignStmt("v",new ConstExp(10)),new CompStmt(new NewStmt("v",new ConstExp(20)),
                new CompStmt(new NewStmt("a",new ConstExp(22)),
                new CompStmt(new PrintStmt(new ArithExp(1,new ConstExp(100), new heapReadingExp("v"))),
                        new PrintStmt(new ArithExp(1,new ConstExp(100),new heapReadingExp("a")))))));
        PrgState prg7 = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(),new FileTable(),new Heap(),ex7);
        IRepository repo7 = new Repository("log7.txt");
        Controller ctrl7 = new Controller(repo7);
        repo7.addPrgState(prg7);

        //Example 8

        //v=10;new(v,20);new(a,22);wH(a,30);print(a);print(rH(a))

        IStmt ex8 = new CompStmt(new AssignStmt("v",new ConstExp(10)),new CompStmt(new NewStmt("v",new ConstExp(20)),new CompStmt(new NewStmt("a",new ConstExp(22)),
                new CompStmt(new heapWritingExp("a",new ConstExp(30)),new CompStmt(new PrintStmt(new VarExp("a")),new PrintStmt(new heapReadingExp("a")))))));
        PrgState prg8 = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(),new FileTable(),new Heap(),ex8);
        IRepository repo8 = new Repository("log8.txt");
        Controller ctrl8 = new Controller(repo8);
        repo8.addPrgState(prg8);

        //Example 9

        //    v=10;new(v,20);new(a,22);wH(a,30);print(a);print(rH(a));a=0

        IStmt ex9 = new CompStmt(new AssignStmt("v",new ConstExp(10)),new CompStmt(new NewStmt("v",new ConstExp(20)),
                new CompStmt(new NewStmt("a",new ConstExp(22)),new CompStmt(new heapWritingExp("a",new ConstExp(30)),
                        new CompStmt(new PrintStmt(new VarExp("a")),new CompStmt(new PrintStmt(new heapReadingExp("a")),new AssignStmt("a",new ConstExp(0))))))));
        PrgState prg9 = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(),new FileTable(),new Heap(),ex9);
        IRepository repo9 = new Repository("log9.txt");
        Controller ctrl9 = new Controller(repo9);
        repo9.addPrgState(prg9);

        //Example 10

        //     10 + (2<6) evaluates to 11

        IStmt ex10 = new PrintStmt(new ArithExp(1,new ConstExp(10),new BooleanExp(new ConstExp(2),new ConstExp(6),"<")));
        PrgState prg10 = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(),new FileTable(),new Heap(),ex10);
        IRepository repo10 = new Repository("log10.txt");
        Controller ctrl10 = new Controller(repo10);
        repo10.addPrgState(prg10);

        //Example 11

        //    (10+2)<6 evaluates to 0

        IStmt ex11 = new PrintStmt(new BooleanExp(new ArithExp(1,new ConstExp(10),new ConstExp(2)),new ConstExp(6),"<"));
        PrgState prg11 = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(),new FileTable(),new Heap(),ex11);
        IRepository repo11 = new Repository("log11.txt");
        Controller ctrl11 = new Controller(repo11);
        repo11.addPrgState(prg11);

        //Example 12

        //    v=6; (while (v-4) print(v);v=v-1);print(v)

        IStmt ex12 = new CompStmt(new AssignStmt("v",new ConstExp(6)),new CompStmt(new WhileStmt(
                new ArithExp(2,new VarExp("v"),new ConstExp(4)),new CompStmt(new PrintStmt(new VarExp("v")),
                new AssignStmt("v",new ArithExp(2,new VarExp("v"),new ConstExp(1))))),new PrintStmt(new VarExp("v"))));
        PrgState prg12 = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(),new FileTable(),new Heap(),ex12);
        IRepository repo12 = new Repository("log12.txt");
        Controller ctrl12 = new Controller(repo12);
        repo12.addPrgState(prg12);

        //Example 13

        //openRFile(var_f,"test.in");


        IStmt ex13 = new openRFile("var_f","test.txt");
        PrgState prg13 = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(),new FileTable(),new Heap(),ex13);
        IRepository repo13 = new Repository("log13.txt");
        Controller ctrl13 = new Controller(repo13);
        repo13.addPrgState(prg13);

        //Example 14

         //v=10;new(a,22);
         //fork(wH(a,30);v=32;print(v);print(rH(a)));
         //print(v);print(rH(a))

        IStmt ex14 = new CompStmt(new AssignStmt("v",new ConstExp(10)),new CompStmt(new NewStmt("a",new ConstExp(22)),
                new CompStmt(new ForkStmt(new CompStmt(new heapWritingExp("a",new ConstExp(30)),
                        new CompStmt(new AssignStmt("v",new ConstExp(32)),new CompStmt(new PrintStmt(new VarExp("v")),
                                new PrintStmt(new heapReadingExp("a")))))),new CompStmt(new PrintStmt(new VarExp("v")),
                        new PrintStmt(new heapReadingExp("a"))))));
        PrgState prg14 = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(),new FileTable(),new Heap(),ex14);
        IRepository repo14 = new Repository("logThread.txt");
        Controller ctrl14 = new Controller(repo14);
        repo14.addPrgState(prg14);

        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0","Exit"));
        menu.addCommand(new RunExample("1",ex1.toString(),ctrl1));
        menu.addCommand(new RunExample("2",ex2.toString(),ctrl2));
        menu.addCommand(new RunExample("3",ex3.toString(),ctrl3));
        menu.addCommand(new RunExample("4",ex4.toString(),ctrl4));
        //menu.addCommand(new RunExample("5",ex5.toString(),ctrl5));
        //menu.addCommand(new RunExample("6",ex6.toString(),ctrl6));
        //menu.addCommand(new RunExample("7",ex7.toString(),ctrl7));
        //menu.addCommand(new RunExample("8",ex8.toString(),ctrl8));
        menu.addCommand(new RunExample("5",ex9.toString(),ctrl9));
        menu.addCommand(new RunExample("6",ex10.toString(),ctrl10));
        menu.addCommand(new RunExample("7",ex11.toString(),ctrl11));
        menu.addCommand(new RunExample("8",ex12.toString(),ctrl12));
        //menu.addCommand(new RunExample("9",ex13.toString(),ctrl13));
        menu.addCommand(new RunExample("9",ex14.toString(),ctrl14));
        menu.show();

        */
    }
}
