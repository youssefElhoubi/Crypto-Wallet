package domain.entities;

import java.time.LocalTime;
import java.util.UUID;

public class Wallet {
    private UUID ID;
    private String address;
    private double balance;
    private LocalTime createdAt;
    public Wallet(UUID ID, String address, double balance, LocalTime createdAt) {
        this.ID = ID;
        this.address = address;
        this.balance = balance;
        this.createdAt = createdAt;
    }
    public UUID getID() {
        return this.ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalTime createdAt) {
        this.createdAt = createdAt;
    }
}
