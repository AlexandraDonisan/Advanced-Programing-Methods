package GUI;

import Controller.Controller;
import Model.*;
import Repository.IRepository;
import Repository.Repository;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {

    @FXML
    private ListView<IStmt> optionList;

    public SceneController() {
    }

    @FXML
    public void initialize()
    {
        optionList.setItems(getOptions());
        optionList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        //optionList.getSelectionModel().selectIndices(1); //item at index 1
        //optionList.getFocusModel().focus(2); //focus


        optionList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<IStmt>(){
            @Override
            public void changed(ObservableValue<? extends IStmt> observable, IStmt oldValue, IStmt newValue) {
                Stage stage = (Stage)optionList.getScene().getWindow();
                try {
                    PrgState prg = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(),new FileTable(),new Heap(),new MyBarrier(),newValue);
                    IRepository repo = new Repository("logFXML.txt");
                    Controller initialCtrl = new Controller(repo);
                    repo.addPrgState(prg);
                    //Parent root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("scene2.fxml"));
                    Parent root = loader.load();

                    SceneController2 ctrlScene2 = loader.getController();
                    ctrlScene2.setCtrl(initialCtrl);


                    Scene scene = new Scene(root, 800, 600);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                //} catch (InterruptedException e) {
                //    e.printStackTrace();
                    }
            }
        });
    }

    private ObservableList<IStmt> getOptions()
    {
        IStmt ex1= new CompStmt(new AssignStmt("v",new ConstExp(2)), new PrintStmt(new VarExp("v")));
        IStmt ex2 = new CompStmt(new AssignStmt("a", new ArithExp(1,new ConstExp(2), new ArithExp(3,new ConstExp(3), new ConstExp(5)))),
                new CompStmt(new AssignStmt("b",new ArithExp(1,new VarExp("a"), new ConstExp(1))), new PrintStmt(new VarExp("b"))));
        IStmt ex3 = new CompStmt(new AssignStmt("a", new ArithExp(2,new ConstExp(2), new
                ConstExp(2))), new CompStmt(new IfStmt(new VarExp("a"),new AssignStmt("v",new ConstExp(2)), new
                        AssignStmt("v", new ConstExp(3))), new PrintStmt(new VarExp("v"))));
        IStmt ex4 = new CompStmt(new openRFile("var_f","test.txt"),new CompStmt( new readFile(new VarExp("var_f"),"var_c"),
                new CompStmt(new PrintStmt(new VarExp("var_c")),new CompStmt(new IfStmt(new VarExp("var_c"),
                        new CompStmt(new readFile(new VarExp("var_f"),"var_c"),new PrintStmt(new VarExp("var_c"))),
                        new PrintStmt(new ConstExp(0))),new closeRFile(new VarExp("var_f"))))));
        IStmt ex5 = new CompStmt(new openRFile("var_f","test.txt"),new CompStmt( new readFile(new ArithExp(1,new VarExp("var_f"),new ConstExp(2)),"var_c"),
                new CompStmt(new PrintStmt(new VarExp("var_c")),new CompStmt(new IfStmt(new VarExp("var_c"),
                        new CompStmt(new readFile(new VarExp("var_f"),"var_c"),new PrintStmt(new VarExp("var_c"))),
                        new PrintStmt(new ConstExp(0))),new closeRFile(new VarExp("var_f"))))));
        IStmt ex6 = new CompStmt(new AssignStmt("v",new ConstExp(10)),new CompStmt(new NewStmt("v",new ConstExp(20)),new CompStmt(new NewStmt("a",new ConstExp(22)),new PrintStmt(new VarExp("v")))));
        IStmt ex7 = new CompStmt(new AssignStmt("v",new ConstExp(10)),new CompStmt(new NewStmt("v",new ConstExp(20)),
                new CompStmt(new NewStmt("a",new ConstExp(22)),
                        new CompStmt(new PrintStmt(new ArithExp(1,new ConstExp(100), new heapReadingExp("v"))),
                                new PrintStmt(new ArithExp(1,new ConstExp(100),new heapReadingExp("a")))))));
        IStmt ex8 = new CompStmt(new AssignStmt("v",new ConstExp(10)),new CompStmt(new NewStmt("v",new ConstExp(20)),new CompStmt(new NewStmt("a",new ConstExp(22)),
                new CompStmt(new heapWritingExp("a",new ConstExp(30)),new CompStmt(new PrintStmt(new VarExp("a")),new PrintStmt(new heapReadingExp("a")))))));
        IStmt ex9 = new CompStmt(new AssignStmt("v",new ConstExp(10)),new CompStmt(new NewStmt("v",new ConstExp(20)),
                new CompStmt(new NewStmt("a",new ConstExp(22)),new CompStmt(new heapWritingExp("a",new ConstExp(30)),
                        new CompStmt(new PrintStmt(new VarExp("a")),new CompStmt(new PrintStmt(new heapReadingExp("a")),new AssignStmt("a",new ConstExp(0))))))));
        IStmt ex10 = new PrintStmt(new ArithExp(1,new ConstExp(10),new BooleanExp(new ConstExp(2),new ConstExp(6),"<")));
        IStmt ex11 = new PrintStmt(new BooleanExp(new ArithExp(1,new ConstExp(10),new ConstExp(2)),new ConstExp(6),"<"));
        IStmt ex12 = new CompStmt(new AssignStmt("v",new ConstExp(6)),new CompStmt(new WhileStmt(
                new ArithExp(2,new VarExp("v"),new ConstExp(4)),new CompStmt(new PrintStmt(new VarExp("v")),
                new AssignStmt("v",new ArithExp(2,new VarExp("v"),new ConstExp(1))))),new PrintStmt(new VarExp("v"))));
        IStmt ex13 = new openRFile("var_f","test.txt");
        IStmt ex14 = new CompStmt(new AssignStmt("v",new ConstExp(10)),new CompStmt(new NewStmt("a",new ConstExp(22)),
                new CompStmt(new ForkStmt(new CompStmt(new heapWritingExp("a",new ConstExp(30)),
                        new CompStmt(new AssignStmt("v",new ConstExp(32)),new CompStmt(new PrintStmt(new VarExp("v")),
                                new PrintStmt(new heapReadingExp("a")))))),new CompStmt(new PrintStmt(new VarExp("v")),
                        new PrintStmt(new heapReadingExp("a"))))));


        IStmt forkFor = new ForkStmt(new CompStmt(new PrintStmt(new VarExp("v")),
                new AssignStmt("v",new ArithExp(1,new VarExp("v"),new ConstExp(1)))));

        IStmt ex17 = new CompStmt(new AssignStmt("v",new ConstExp(20)),
                new CompStmt(new ForStmt("v",new ConstExp(0),
                        new ConstExp(3),new ArithExp(1,new VarExp("v"),
                        new ConstExp(1)),forkFor),
                        new PrintStmt(new ArithExp(3,new VarExp("v"),new ConstExp(10)))));


        /*
        a=1;b=2;c=5;
        switch(a*10)
            (case (b*c) print(a);print(b))
            (case (10) print(100);print(200))
            (default print(300));
        print(300)
         The final Out should be {1,2,300}
         */


        IStmt a = new CompStmt(new AssignStmt("a",new ConstExp(1)),
                new CompStmt(new AssignStmt("b",new ConstExp(2)),new AssignStmt("c",new ConstExp(5))));

        IStmt case1 = new CompStmt(new PrintStmt(new VarExp("a")),new PrintStmt(new VarExp("b")));
        IStmt case2 = new CompStmt(new PrintStmt(new ConstExp(100)),new PrintStmt(new ConstExp(200)));
        IStmt caseDef = new PrintStmt(new ConstExp(300));
        IStmt switchSt = new SwitchStmt(new ArithExp(3,new VarExp("a"),new ConstExp(10)),
                new ArithExp(3,new VarExp("b"),new VarExp("c")),new ConstExp(10),case1,case2,caseDef);

        IStmt ex18 = new CompStmt(a,new CompStmt(switchSt, new PrintStmt(new ConstExp(300))));

        //v=1;fork(v=2);fork(v=3)
        IStmt ex19 = new CompStmt(new AssignStmt("v",new ConstExp(1)),
                new CompStmt(new ForkStmt(new AssignStmt("v",new ConstExp(2))),
                        new ForkStmt(new AssignStmt("v",new ConstExp(3)))));

        /*
        new(v1,2);new(v2,3);new(v3,4);newBarrier(cnt,rH(v2));
        fork(await(cnt);wh(v1,rh(v1)*10));print(rh(v1)));
        fork(await(cnt);wh(v2,rh(v2)*10));wh(v2,rh(v2)*10));print(rh(v2)));
        await(cnt);
        print(rH(v3))

         */

        NewStmt new1 = new NewStmt("v1",new ConstExp(2));
        NewStmt new2 = new NewStmt("v2",new ConstExp(3));
        NewStmt new3 = new NewStmt("v3", new ConstExp(4));

        NewBarrier newBar = new NewBarrier("cnt",new heapReadingExp("v2"));
        CompStmt body1 = new CompStmt(new Await("cnt"),
                new heapWritingExp("v1",new ArithExp(3,new heapReadingExp("v1"),new ConstExp(10))));
        ForkStmt fork1 = new ForkStmt(body1);
        PrintStmt prt1 = new PrintStmt(new heapReadingExp("v1"));
        CompStmt body2 = new CompStmt(new Await("cnt"),
                new heapWritingExp("v2",new ArithExp(3,new heapReadingExp("v2"),new ConstExp(10))));
        ForkStmt fork2 = new ForkStmt(body2);
        IStmt ex20 = new CompStmt(new1,new CompStmt(new2,new CompStmt(new3,new CompStmt(newBar,new CompStmt(fork1,new CompStmt(prt1,
                new CompStmt(fork2,
                        new CompStmt(new heapWritingExp("v2",new ArithExp(3,new heapReadingExp("v2"),
                                new ConstExp(10))),
                                new CompStmt(new PrintStmt(new heapReadingExp("v2")),
                                        new CompStmt(new Await("cnt"),new PrintStmt(new heapReadingExp("v3"))))))))))));

        return FXCollections.observableArrayList(ex1,ex2,ex3,ex4,ex5, ex6,ex7,ex8,ex9,ex10,ex11,ex12,ex13,ex14,ex17,ex18, ex19, ex20);


    }

}
