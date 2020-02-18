package GUI;

import Controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Pair;
import java.io.IOException;
import java.util.ArrayList;

public class SceneController2 {
    @FXML private Button buttonReturnToPrograms;
    @FXML private Button buttonRunOneStep;
    @FXML private TextField noOfProgramStates;
    @FXML private TableView<Pair<Integer, Integer>> heapTable;
    @FXML private TableView<Pair<Integer,String>> fileTable;
    @FXML private TableView<Pair<String,Integer>> symbolTable;
    @FXML private TableView<Pair<Integer,Pair<Integer,ArrayList<Integer>>>> barrierTable;
    @FXML private ListView<String> outList;
    @FXML private ListView<Integer> programStates;
    @FXML private ListView<String> exeStack;
    @FXML private TableColumn<Pair<Integer, Integer>,String> addressColumn;
    @FXML private TableColumn<Pair<Integer, Integer>,String> valueColumn;
    @FXML private TableColumn<Pair<Integer,String>,String> IdentifierColumn;
    @FXML private TableColumn<Pair<Integer,String>,String> fileNameColumn;
    @FXML private TableColumn<Pair<String,Integer>,String> variableNameColumn;
    @FXML private TableColumn<Pair<String,Integer>,String> symValueColumn;
    @FXML private TableColumn indexBarrierColumn;
    @FXML private TableColumn valueBarrierColumn;
    @FXML private TableColumn listBarrierColumn;
    private Controller ctrl;
    private int index=0;

    public SceneController2() { }
    @FXML private void initialize() {
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("key"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        IdentifierColumn.setCellValueFactory(new PropertyValueFactory<>("key"));
        fileNameColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        variableNameColumn.setCellValueFactory(new PropertyValueFactory<>("key"));
        symValueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        indexBarrierColumn.setCellValueFactory(new PropertyValueFactory<>("key"));
        valueBarrierColumn.setCellValueFactory(new PropertyValueFactory<>("key"));
        listBarrierColumn.setCellValueFactory(new PropertyValueFactory<>("value"));

        programStates.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                if (newValue == null)
                    programStates.getSelectionModel().select(0);
                index = programStates.getSelectionModel().getSelectedIndex();
                updateAllScenes();
            }
        });
    }

    public void setCtrl(Controller ctrl) { this.ctrl = ctrl;
        this.ctrl.startGui();
    }

    public Controller getCtrl() { return ctrl; }

    private void oneStep() throws InterruptedException {
        try {
            ctrl.oneStepGUI();
        }
        catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("The program is finished! Choose another option!");
            alert.showAndWait();
        }
    }

    @FXML
    public void handleButtonRunOneStep(MouseEvent event) throws IOException, InterruptedException {
        if(event.getSource()==buttonRunOneStep) {
            oneStep();
            update();
            //updateAllScenes();
        }
    }

    @FXML
    public void handleButtonAction(ActionEvent event) throws IOException {

        Stage stage;
        Parent root;
        if(event.getSource()==buttonReturnToPrograms) {
            //get reference to the button's stage
            stage = (Stage) buttonReturnToPrograms.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("scene1.fxml"));

            //create a new scene with root and set the stage
            Scene scene = new Scene(root, 800, 600);
            stage.setScene(scene);
            stage.show();
        }
    }

    private void updateAllScenes()
    {
        if(!ctrl.getNumberOfPrograms().equals("0"))
        {
            ArrayList<Pair<Integer, Integer>> heapTableN = ctrl.getHeapTableGUI(index);
            ObservableList<Pair<Integer, Integer>> heap = FXCollections.observableArrayList(heapTableN);
            heapTable.setItems(heap);

            ArrayList<String> exeStackN = ctrl.getExeStackGUI(index);
            ObservableList<String> exe = FXCollections.observableArrayList(exeStackN);
            exeStack.setItems(exe);

            ArrayList<Pair<String,Integer>> symbolTableN = ctrl.getSymbolTableGUI(index);
            ObservableList<Pair<String,Integer>> symbol = FXCollections.observableArrayList(symbolTableN);
            symbolTable.setItems(symbol);

            ArrayList<String> outListN = ctrl.getOutTableGUI(index);
            ObservableList<String> outL = FXCollections.observableArrayList(outListN);
            outList.setItems(outL);

            ArrayList<Pair<Integer,String>> fileTableN = ctrl.getFileTableGUI(index);
            ObservableList<Pair<Integer,String>> file =  FXCollections.observableArrayList(fileTableN);
            fileTable.setItems(file);

           ArrayList<Pair<Integer,Pair<Integer,ArrayList<Integer>>>> barrierN = ctrl.getBarrierGUI(index);
           ObservableList<Pair<Integer,Pair<Integer,ArrayList<Integer>>>> bar = FXCollections.observableArrayList(barrierN);
           barrierTable.setItems(bar);

            noOfProgramStates.setText(ctrl.getNumberOfPrograms());
        }
    }

    public void update()
    {
        ArrayList<Integer> programStatesN = ctrl.getProgramStatesGUI();
        ObservableList<Integer> program = FXCollections.observableArrayList(programStatesN);
        programStates.setItems(program);

        updateAllScenes();
    }

}




/*
// Event Listener on Button[#button1].onAction
    @FXML
    public void handleButtonAction(ActionEvent event) throws IOException{

        Stage stage;
        Parent root;
        if(event.getSource()==button1){
            //get reference to the button's stage
            stage=(Stage) button1.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        }
        else{
            stage=(Stage) button2.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        }
        //create a new scene with root and set the stage
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }
 */