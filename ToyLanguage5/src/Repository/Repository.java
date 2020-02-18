package Repository;

import Model.MyException;
import Model.PrgState;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Repository implements IRepository{
    private PrgState prg;
    private String logFilePath;

    public Repository(PrgState prg, String logFilePath) {
        this.prg = prg;
        this.logFilePath = logFilePath;
    }

    /*public Repository(PrgState prg) {
        this.prg = prg;
    }*/

    @Override
    public PrgState getCtrPrg(){
        return prg;
    }

    @Override
    public void logPrgStateExec(){
        PrintWriter logFile = null;
        try {
            logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));
            logFile.println("ExeStack:");
            logFile.println("\t"+prg.getStk().toString());
            logFile.println("SymTable:");
            logFile.println("\t"+prg.getSymTable().toString());
            logFile.println("Out:");
            logFile.println("\t"+prg.getOut().toString());
            logFile.println("File Table:");
            logFile.println("\t"+prg.getFileTable().toString());
            logFile.println("Heap:");
            logFile.println("\t"+prg.getHeap().toString());
            logFile.println();
            logFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clearData() {
        try {
            PrintWriter logFile = new PrintWriter(new BufferedWriter((new FileWriter(logFilePath,false))));
            logFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Repository{" +
                "prg=" + prg +
                '}';
    }
}
