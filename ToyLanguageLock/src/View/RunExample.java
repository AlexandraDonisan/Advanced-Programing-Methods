package View;

import Controller.Controller;
import Model.MyException;

public class RunExample extends Command {
    private Controller ctrl;

    public RunExample(String key, String description, Controller ctrl) {
        super(key, description);
        this.ctrl = ctrl;
    }

    @Override
    public void execute() {
        try{
            ctrl.allStep();
        }
        catch (RuntimeException | InterruptedException ex) //CAUTION HERE
        {
            System.err.println("Error: "+ex.toString());
        }
    }
}
