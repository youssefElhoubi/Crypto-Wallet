package domain.repository;

import domain.entities.Transaction;
import domain.interfaces.Repository;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class TransactionRepository extends Repository<Transaction> {

    @Override
    public void Save(Transaction Object) {
        try {

        }catch (Exception e){}

    }

    @Override
    public Transaction FindById(UUID Id) {
        return null;
    }

    @Override
    public List<Transaction> FindAll() {
        return Collections.emptyList();
    }

    @Override
    public void Delete(UUID Id) {

    }
}