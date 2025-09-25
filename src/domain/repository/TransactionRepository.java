package domain.repository;

import domain.entities.Transaction;
import domain.enums.FeeLevel;
import domain.enums.TransactionStatus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TransactionRepository extends Repository<Transaction> {
    @Override
    public void Save(Transaction T) throws Exception {
        String sql =  Insert + " Transactions  (id, sourceAddress, destinationAddress, amount, feeLevel, transaction_status, creationDate, confirmationDate, cryptoType ,fee)  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)" ;
        try(PreparedStatement stm = Instance.prepareStatement(sql)) {
            stm.setString(1,T.getId().toString());
            stm.setString(2,T.getSourceAddress());
            stm.setString(3,T.getDestinationAddress());
            stm.setDouble(4,T.getAmount());
            stm.setString(5,T.getFeeLevel().name());  // store enum as text
            stm.setString(6,T.getStatus().name());    // store enum as text
            stm.setObject(7,T.getCreationDate());     // works with MySQL 8+ and JDBC 4.2
            stm.setObject(8,T.getConfirmationDate());
            stm.setString(9,T.getCryptoType());
            stm.setObject(10,T.getFee());
            stm.execute();
        }catch (Exception e){
            throw new SQLException(e);
        }

    }

    @Override
    public Transaction FindById(UUID Id) {
        String sql = Select+" WHERE ID = ?";
        try(PreparedStatement stm =Instance.prepareStatement(sql);
        ) {
            stm.setString(1, Id.toString());
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {

            return new Transaction(
                    UUID.fromString(rs.getString("id")),
                    rs.getDouble("fee"),
                    rs.getString("sourceAddress"),
                    rs.getString("destinationAddress"),
                    rs.getDouble("amount"),
                    FeeLevel.valueOf(rs.getString("feeLevel")),            // map enum
                    TransactionStatus.valueOf(rs.getString("transaction_status")), // map enum
                    rs.getTimestamp("creationDate") != null ? rs.getTimestamp("creationDate").toLocalDateTime() : null,
                    rs.getTimestamp("confirmationDate") != null ? rs.getTimestamp("confirmationDate").toLocalDateTime() : null,
                    rs.getString("cryptoType")
            );
            }
        } catch (Exception e) {
            throw new RuntimeException("Error fetching transaction with id " + Id, e);
        }
        return null;
    }
    @Override
    public List<Transaction> FindAll() {
        List<Transaction> list = new ArrayList<>();
        String sql = Select + " form Transactions"; // base SELECT statement like: "SELECT * FROM transactions"

        try (PreparedStatement stm = Instance.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                Transaction obj = new Transaction();
                obj.setId(rs.getString("ID"));
                obj.setSourceAddress(rs.getString("sourceAddress"));
                obj.setDestinationAddress(rs.getString("destinationAddress"));
                obj.setAmount(rs.getDouble("amount"));
                obj.setFee(rs.getDouble("fee"));
                obj.setFeeLevel(FeeLevel.valueOf(rs.getString("feeLevel"))); // could also use an enum in Java
                obj.setStatus(TransactionStatus.valueOf(rs.getString("transaction_status"))); // also could be an enum
                obj.setCreationDate(rs.getTimestamp("creationDate").toLocalDateTime());
                list.add(obj);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public void Delete(UUID Id) {
        String sql = Delete+ " transactions WHERE id = ?";
        try (PreparedStatement stm = Instance.prepareStatement(sql)) {
            stm.setString(1, Id.toString());
            stm.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void Update(Transaction tx) {
        String sql = "UPDATE Transactions SET sourceAddress = ?, destinationAddress = ?, amount = ?, fee = ?, feeLevel = ?, transaction_status = ?, creationDate = ?, confirmationDate = ?, cryptoType = ? WHERE id = ?";

        try (PreparedStatement stm = Instance.prepareStatement(sql)) {
            stm.setString(1, tx.getSourceAddress());
            stm.setString(2, tx.getDestinationAddress());
            stm.setDouble(3, tx.getAmount());
            stm.setDouble(4, tx.getFee());
            stm.setString(5, tx.getFeeLevel().name());
            stm.setString(6, tx.getStatus().name());
            stm.setObject(7, tx.getCreationDate());
            stm.setObject(8, tx.getConfirmationDate());
            stm.setString(9, tx.getCryptoType());
            stm.setString(10, tx.getId().toString());

            stm.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Error updating transaction with id " + tx.getId(), e);
        }
    }

}