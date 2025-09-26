package domain.services;
import domain.entities.Transaction;
import domain.repository.TransactionRepository;
import utils.Floger;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MinerService extends Thread {
    Logger log ;
    TransactionRepository repo;
    public MinerService(){
        this.log = Floger.makelogger();
        this.repo = new TransactionRepository();
    }
    @Override
    public void run(){
        try{
            List<Transaction> transacsions = new ArrayList<>();
            transacsions = repo.watingTransactions();
            Transaction firstTransaction = transacsions.get(0);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}