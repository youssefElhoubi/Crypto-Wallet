package domain.services;

import domain.entities.Transaction;
import domain.repository.TransactionRepository;
import utils.Floger;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

public class TransactionService {
    private static Logger log = Floger.makelogger();
    private final TransactionRepository repo;

    public TransactionService(TransactionRepository repo) {
        this.repo = repo;
    }

    public void makeTransaction(Transaction t){
        try {
            repo.Save(t);
        }catch(Exception e){
            log.warning(e.getMessage());
        }
    }
    public Transaction getTransactionById(UUID id) {
        try {
            return repo.FindById(id);
        } catch (Exception e) {
            log.warning("Failed to fetch transaction with id " + id + ": " + e.getMessage());
            return null;
        }
    }
    public List<Transaction> getAllTransactions() {
        try {
            return repo.FindAll();
        } catch (Exception e) {
            log.warning("Failed to fetch all transactions: " + e.getMessage());
            return null;
        }
    }

    public boolean deleteTransaction(UUID id) {
        try {
            repo.Delete(id);
            return true;
        } catch (Exception e) {
            log.warning("Failed to delete transaction with id " + id + ": " + e.getMessage());
            return false;
        }
    }
    
    public boolean updateTransaction(Transaction tx) {
        try {
            repo.Update(tx);
            return true;
        } catch (Exception e) {
            log.warning("Failed to update transaction with id " + tx.getId() + ": " + e.getMessage());
            return false;
        }
    }



}