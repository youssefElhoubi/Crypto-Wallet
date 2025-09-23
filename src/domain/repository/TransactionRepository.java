package domain.repository;

import domain.entities.Transaction;
import domain.interfaces.Repository;

import java.sql.PreparedStatement;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class TransactionRepository extends Repository<Transaction> {

    @Override
    public void Save(Transaction Object) throws Exception {
        Insert.concat("Transactions  (id, sourceAddress, destinationAddress, amount, feeLevel, transaction_status, creationDate, confirmationDate, cryptoType)  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)" );
        try(PreparedStatement stm = Instance.prepareStatement(Insert)) {
            stm.setString(1, Object.getId());
            stm.setString(2, Object.getSourceAddress());
            stm.setString(3, Object.getDestinationAddress());
            stm.setDouble(4, Object.getAmount());
            stm.setString(5, Object.getFeeLevel().name());  // store enum as text
            stm.setString(6, Object.getStatus().name());    // store enum as text
            stm.setObject(7, Object.getCreationDate());     // works with MySQL 8+ and JDBC 4.2
            stm.setObject(8, Object.getConfirmationDate());
            stm.setString(9, Object.getCryptoType());
            stm.execute();
        }catch (Exception e){
            throw new RuntimeException(e);
        }

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