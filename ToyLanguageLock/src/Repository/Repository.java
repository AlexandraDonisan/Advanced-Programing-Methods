package Repository;

import Model.MyException;
import Model.PrgState;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Repository implements IRepository{
    //private PrgState prg;
    private List<PrgState> prgL;
    private String logFilePath;
    private int id=0;


    public Repository(String logFilePath) {
        this.prgL = new ArrayList<>();
        this.logFilePath = logFilePath;
    }

    @Override
    public void addPrgState(PrgState prg) {
        this.prgL.add(prg);
        prg.setId(id);
        this.id++;
    }

    @Override
    public List<PrgState> getPrgList() {
        return prgL;
    }

    @Override
    public void setPrgList(List<PrgState> p) {
        this.prgL = p;
    }

    @Override
    public void logPrgStateExec(PrgState p) {
        PrintWriter logFile = null;
        try {
            logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));

            logFile.println("Program State(id):");
            logFile.println("\t"+p.toString());
            logFile.println("ExeStack:");
            logFile.println("\t"+p.getStk().toString());
            logFile.println("SymTable:");
            logFile.println("\t"+p.getSymTable().toString());
            logFile.println("Out:");
            logFile.println("\t"+p.getOut().toString());
            logFile.println("File Table:");
            logFile.println("\t"+p.getFileTable().toString());
            logFile.println("Heap:");
            logFile.println("\t"+p.getHeap().toString());
            logFile.println();
            logFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getIdRepo() {
        return new AtomicInteger(id++).intValue();
        //return id++;
    }

    public void setIdRepo() {
        this.id = id+1;
    }
    /*
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
    */

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
    public String getNumberOfProgramsRepo() {
        return String.valueOf(prgL.size());
    }

    @Override
    public ArrayList<Integer> getIdPrgState() {
        ArrayList<Integer> arr = new ArrayList<>();
        prgL.forEach(el->arr.add(el.getId()));
        return arr;
    }

    @Override
    public int getIndexId(int index) {
        for (int i=0;i<prgL.size();i++)
            if(prgL.get(i).getId() == index)
                return i;
        return 0;
        //return prgL.get(index);
    }
}
