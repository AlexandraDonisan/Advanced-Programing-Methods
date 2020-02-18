package Controller;

import Model.*;
import Repository.IRepository;
import javafx.util.Pair;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Controller {
    private IRepository repo;
    private ExecutorService executor;

    public Controller(IRepository repo) {
        this.repo = repo;
    }

    private Map<Integer,Integer> conservativeGarbageCollector(Collection<Integer> symTableValues, Map<Integer, Integer> heap)
    {
        return heap.entrySet().stream()
                .filter(e->symTableValues.contains(e.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    }

    private void garbageGarbage()
    {
        MyIDictionary<String,Integer> valuesFromSymTable = new MyDictionary<>();
        repo.getPrgList().forEach(prg->prg.getSymTable().getKeys().forEach(key->valuesFromSymTable.add(key,prg.getSymTable().get(key))));

        repo.getPrgList().forEach(prg->prg.getHeap()
            .setContent(conservativeGarbageCollector(valuesFromSymTable.getContent().values(),prg.getHeap().getContent())));

    }

    private List<PrgState> removeCompletedPrg(List<PrgState> inPrgList)
    {
        return inPrgList.stream()
                .filter(PrgState::isNotCompleted)
                .collect(Collectors.toList());
    }

    private void oneStepforAllPrg(List<PrgState> prgList) throws InterruptedException {
        //prepare the list of callables
        prgList.forEach(prg->repo.logPrgStateExec(prg));

        List<Callable<PrgState>> callList = prgList.stream()
                .map((PrgState p)->(Callable<PrgState>)(p::oneStep))
                .collect(Collectors.toList());

        //start the execution of the callables
        //it returns the list of new created PrgStates (namely threads)
        List<PrgState> newPrgList = executor.invokeAll(callList).stream()
                .map(future-> {
                    try{
                        return future.get();
                    } catch (InterruptedException | ExecutionException e){
                        e.printStackTrace();
                    //System.err.println("Exception is : "+e);
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        //set unique id
        newPrgList.forEach(PrgState::setNewId);

        //add the new created threads to the list of existing threads
        prgList.addAll(newPrgList);

        garbageGarbage();

        //after the execution, print the PrgState List into the log file
        prgList.forEach(prg->repo.logPrgStateExec(prg));

        //Save the current programs in the repository
        repo.setPrgList(prgList);
        }

    public void allStep() throws InterruptedException {
        executor = Executors.newFixedThreadPool(2);
        repo.clearData();

        //remove all completed programs
        List<PrgState> prgList = removeCompletedPrg(repo.getPrgList());
        while(prgList.size()>0)
        {
            //Garbage Collector
            //prgList.forEach(prg->prg.getHeap().setContent(conservativeGarbageCollector(prg.getSymTable().getContent().values(),prg.getHeap().getContent())));

            oneStepforAllPrg(prgList);

            //remove the completed programs
            prgList = removeCompletedPrg(repo.getPrgList());
        }
        executor.shutdown();

        closeAllFiles(prgList);

        // update the repository state
        repo.setPrgList(prgList);
    }

    private void closeAllFiles(List<PrgState> prgList)
    {
        for (PrgState aPrgList : prgList) {
            MyIFileDictionary<Integer, Pair<String, BufferedReader>> tbl = aPrgList.getFileTable();

            tbl.getPairs().forEach(pair -> {
                try {
                    pair.getValue().close();
                } catch (IOException e) {
                    System.err.println("Exception is : " + e);
                }
            });

        for(Integer k: tbl.getKeys())
            tbl.remove(k);
        }
    }
}

//prg.getHeap().setContent(conservativeGarbageCollector(prg.getSymTable().getContent().values(),prg.getHeap().getContent()));