package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class SampleController {
    public Label helloWorld;

    public void sayHelloWorld(ActionEvent actionEvent) {
        helloWorld.setText("Hello World!");
    }

    public void loginButtonClicked(ActionEvent actionEvent)
    {
        System.out.println("I pressed it and I'm dead!");
    }
}
