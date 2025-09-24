package domain.repository;

import domain.entities.Wallet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class WalletRepository extends Repository<Wallet> {
    private Wallet wallet;
    public WalletRepository(Wallet wallet) {
        this.wallet = wallet;
    }
    @Override
    public void Save() throws Exception {
        Insert.concat("wallet (id, balence, wallet_type, created_at, Updated_at) VALUES (?, ?, ?, ?, ?)");

        try (PreparedStatement stm = Instance.prepareStatement(Insert)) {
            stm.setString(1, this.wallet.getID().toString());
            stm.setDouble(2, this.wallet.getBalance());
            stm.setString(3, this.wallet.getWalletType());
            stm.setObject(4, this.wallet.getCreatedAt());
            stm.setObject(5, this.wallet.getUpdatedAt());
            stm.execute();
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }

    @Override
    public Wallet FindById(UUID Id) {
        Select.concat("WHERE id = ?");
        try (PreparedStatement stm = Instance.prepareStatement(Select)) {
            stm.setString(1, Id.toString());
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                return new Wallet(
                        UUID.fromString(rs.getString("id")),
                        rs.getDouble("balence"),
                        rs.getString("wallet_type"),
                        rs.getTimestamp("created_at") != null ? rs.getTimestamp("created_at").toLocalDateTime() : null,
                        rs.getTimestamp("Updated_at") != null ? rs.getTimestamp("Updated_at").toLocalDateTime() : null
                );
            }
        } catch (Exception e) {
            throw new RuntimeException("Error fetching wallet with id " + Id, e);
        }
        return null;
    }

    @Override
    public List<Wallet> FindAll() {
        List<Wallet> list = new ArrayList<>();
        String sql = Select.concat("FROM wallet");

        try (PreparedStatement stm = Instance.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                Wallet wallet = new Wallet(
                        UUID.fromString(rs.getString("id")),
                        rs.getDouble("balence"),
                        rs.getString("wallet_type"),
                        rs.getTimestamp("created_at") != null ? rs.getTimestamp("created_at").toLocalDateTime() : null,
                        rs.getTimestamp("Updated_at") != null ? rs.getTimestamp("Updated_at").toLocalDateTime() : null
                );
                list.add(wallet);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void Delete(UUID Id) {
        String sql = Delete.concat("wallet WHERE id = ?");
        try (PreparedStatement stm = Instance.prepareStatement(sql)) {
            stm.setString(1, Id.toString());
            stm.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void Update(Wallet wallet) {
        String sql = "UPDATE wallet SET balence = ?, wallet_type = ?, created_at = ?, Updated_at = ? WHERE id = ?";

        try (PreparedStatement stm = Instance.prepareStatement(sql)) {
            stm.setDouble(1, wallet.getBalance());
            stm.setString(2, wallet.getWalletType());
            stm.setObject(3, wallet.getCreatedAt());
            stm.setObject(4, wallet.getUpdatedAt());
            stm.setString(5, wallet.getID().toString());

            stm.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Error updating wallet with id " + wallet.getID(), e);
        }
    }

}
