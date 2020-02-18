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
        MyIStack<IStmt> exeStack = new MyStack<>();
        MyIDictionary<String, Integer> symTable = new MyDictionary<>();
        MyIList<Integer> out = new MyList<>();
        MyIFileDictionary<Integer, Pair<String, BufferedReader>> fileTable = new FileTable();

        MyIStack<IStmt> exeStack2 = new MyStack<>();
        MyIDictionary<String, Integer> symTable2 = new MyDictionary<>();
        MyIList<Integer> out2 = new MyList<>();
        MyIFileDictionary<Integer, Pair<String, BufferedReader>> fileTable2 = new FileTable();

        MyIStack<IStmt> exeStack3 = new MyStack<>();
        MyIDictionary<String, Integer> symTable3 = new MyDictionary<>();
        MyIList<Integer> out3 = new MyList<>();
        MyIFileDictionary<Integer, Pair<String, BufferedReader>> fileTable3 = new FileTable();

        //Example 1
        // v=2;Print(v)
        IStmt ex1= new CompStmt(new AssignStmt("v",new ConstExp(2)), new PrintStmt(new
                VarExp("v")));
        PrgState prg1 = new PrgState(exeStack, symTable, out,fileTable, ex1);
        IRepository repo1 = new Repository(prg1,"log1.txt");
        Controller ctrl1 = new Controller(repo1);

        //Example2:
        //a=2+3*5;b=a+1;Print(b) is represented as:
        IStmt ex2 = new CompStmt(new AssignStmt("a", new ArithExp(1,new ConstExp(2),
                new ArithExp(3,new ConstExp(3), new ConstExp(5)))),
                new CompStmt(new AssignStmt("b",new ArithExp(1,new VarExp("a"),
                        new ConstExp(1))), new PrintStmt(new VarExp("b"))));
        PrgState prg2 = new PrgState(exeStack2,symTable2,out2,fileTable2,ex2);
        IRepository repo2 = new Repository(prg2,"log2.txt");
        Controller ctrl2 = new Controller(repo2);

        //Example3:
        //a=2-2;(If a Then v=2 Else v=3);Print(v) is represented as
        IStmt ex3 = new CompStmt(new AssignStmt("a", new ArithExp(2,new ConstExp(2), new
                ConstExp(2))),
                new CompStmt(new IfStmt(new VarExp("a"),new AssignStmt("v",new ConstExp(2)), new
                        AssignStmt("v", new ConstExp(3))), new PrintStmt(new VarExp("v"))));
        PrgState prg3 = new PrgState(exeStack3,symTable3,out3,fileTable3,ex3);
        IRepository repo3 = new Repository(prg3,"log3.txt");
        Controller ctrl3 = new Controller(repo3);

        //Example 4:
        /*
        openRFile(var_f,"test.in");
        readFile(var_f,var_c);print(var_c);
        (if var_c then readFile(var_f,var_c);print(var_c)
        else print(0));
        closeRFile(var_f)
         */
        MyIStack<IStmt> exeStack4 = new MyStack<>();
        MyIDictionary<String, Integer> symTable4 = new MyDictionary<>();
        MyIList<Integer> out4 = new MyList<>();
        MyIFileDictionary<Integer, Pair<String, BufferedReader>> fileTable4 = new FileTable();

        IStmt ex4 = new CompStmt(new openRFile("var_f","test.txt"),new CompStmt( new readFile(new VarExp("var_f"),"var_c"),
                new CompStmt(new PrintStmt(new VarExp("var_c")),new CompStmt(new IfStmt(new VarExp("var_c"),
                        new CompStmt(new readFile(new VarExp("var_f"),"var_c"),new PrintStmt(new VarExp("var_c"))),
                        new PrintStmt(new ConstExp(0))),new closeRFile(new VarExp("var_f"))))));
        //IStmt ex4 = new openRFile("var_f","test.txt");
        PrgState prg4 = new PrgState(exeStack4,symTable4,out4,fileTable4,ex4);
        IRepository repo4 = new Repository(prg4,"log4.txt");
        Controller ctrl4 = new Controller(repo4);

        //Example 5:
        /*
        openRFile(var_f,"test.in");
        readFile(var_f+2,var_c);print(var_c);
        (if var_c then readFile(var_f,var_c);print(var_c)
        else print(0));
        closeRFile(var_f)
         */
        MyIStack<IStmt> exeStack5 = new MyStack<>();
        MyIDictionary<String, Integer> symTable5 = new MyDictionary<>();
        MyIList<Integer> out5 = new MyList<>();
        MyIFileDictionary<Integer, Pair<String, BufferedReader>> fileTable5 = new FileTable();

        IStmt ex5 = new CompStmt(new openRFile("var_f","test.txt"),new CompStmt( new readFile(new ArithExp(1,new VarExp("var_f"),new ConstExp(2)),"var_c"),
                new CompStmt(new PrintStmt(new VarExp("var_c")),new CompStmt(new IfStmt(new VarExp("var_c"),
                        new CompStmt(new readFile(new VarExp("var_f"),"var_c"),new PrintStmt(new VarExp("var_c"))),
                        new PrintStmt(new ConstExp(0))),new closeRFile(new VarExp("var_f"))))));
        PrgState prg5 = new PrgState(exeStack5,symTable5,out5,fileTable5,ex5);
        IRepository repo5 = new Repository(prg5,"log5.txt");
        Controller ctrl5 = new Controller(repo5);



        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0","Exit"));
        menu.addCommand(new RunExample("1",ex1.toString(),ctrl1));
        menu.addCommand(new RunExample("2",ex2.toString(),ctrl2));
        menu.addCommand(new RunExample("3",ex3.toString(),ctrl3));
        menu.addCommand(new RunExample("4",ex4.toString(),ctrl4));
        menu.addCommand(new RunExample("5",ex5.toString(),ctrl5));
        menu.show();
    }
}
