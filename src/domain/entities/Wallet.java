package domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class Wallet {
    private UUID ID;
    private double balance;
    private String walletType; // Ethereum | Bitcoin
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String wallet_address;

    public Wallet(UUID ID, double balance, String walletType, LocalDateTime createdAt, LocalDateTime updatedAt ,String wallet_address) {
        this.ID = ID;
        this.balance = balance;
        this.walletType = walletType;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.wallet_address = wallet_address;
    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getWalletType() {
        return walletType;
    }

    public void setWalletType(String walletType) {
        this.walletType = walletType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getWallet_address() {
        return wallet_address;
    }

    public void setWallet_address(String wallet_address) {
        this.wallet_address = wallet_address;
    }
}
