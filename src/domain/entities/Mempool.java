package domain.entities;

import java.util.ArrayList;
import java.util.List;

public class Mempool {
    // List of pending transactions
    private List<Transaction> pendingTransactions = new ArrayList<>();

    // Optional: maximum capacity of mempool (simulate network congestion)
    private int maxCapacity;

    // Optional: name/id of the blockchain (Bitcoin, Ethereum)
    private String blockchainType;

    public Mempool(String blockchainType, int maxCapacity) {
        this.blockchainType = blockchainType;
        this.maxCapacity = maxCapacity;
    }

    public List<Transaction> getPendingTransactions() {
        return pendingTransactions;
    }

    public void setPendingTransactions(List<Transaction> pendingTransactions) {
        this.pendingTransactions = pendingTransactions;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getBlockchainType() {
        return blockchainType;
    }

    public void setBlockchainType(String blockchainType) {
        this.blockchainType = blockchainType;
    }
}
