package domain.services;

import domain.entities.Wallet;
import domain.repository.WalletRepository;
import utils.Floger;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

public class WalletService {
    private final WalletRepository repo;
    private final Logger log;

    public WalletService() {
        this.repo = new WalletRepository();
        this.log = Floger.makelogger();
    }

    // Save wallet
    public void createWallet(Wallet wallet) {
        try {
            repo.Save(wallet);
        } catch (Exception e) {
            log.warning("Failed to save wallet: " + e.getMessage());
        }
    }

    // Find wallet by ID
    public Wallet getWalletById(UUID id) {
        try {
            return repo.FindById(id);
        } catch (Exception e) {
            log.warning("Failed to fetch wallet with id " + id + ": " + e.getMessage());
            return null;
        }
    }
    public Wallet getWalletByAddress(String address) {
        try{
            return repo.getWalletByAddress(address);
        }
        catch (Exception e){
            log.warning("Failed to fetch wallet by address " + address + ": " + e.getMessage());
            return null;
        }
    }

    // Find all wallets
    public List<Wallet> getAllWallets() {
        try {
            return repo.FindAll();
        } catch (Exception e) {
            log.warning("Failed to fetch all wallets: " + e.getMessage());
            return null;
        }
    }

    // Delete wallet
    public boolean deleteWallet(UUID id) {
        try {
            repo.Delete(id);
            return true;
        } catch (Exception e) {
            log.warning("Failed to delete wallet with id " + id + ": " + e.getMessage());
            return false;
        }
    }

    // Update wallet
    public boolean updateWallet(Wallet wallet) {
        try {
            repo.Update(wallet);
            return true;
        } catch (Exception e) {
            log.warning("Failed to update wallet with id " + wallet.getID() + ": " + e.getMessage());
            return false;
        }
    }
}
