package domain.entities;
import domain.enums.FeeLevel;
import domain.enums.TransactionStatus;
import java.time.LocalDateTime;

public class Transaction {
    private String id;
    private String sourceAddress;
    private String destinationAddress;
    private Double amount;
    private FeeLevel feeLevel;
    private TransactionStatus status;
    private LocalDateTime creationDate;
    private LocalDateTime confirmationDate;

    public Transaction(String id, String sourceAddress, String destinationAddress, Double amount,  FeeLevel feeLevel, TransactionStatus status, LocalDateTime creationDate, LocalDateTime confirmationDate, String cryptoType) {
        this.id = id;
        this.sourceAddress = sourceAddress;
        this.destinationAddress = destinationAddress;
        this.amount = amount;
        this.feeLevel = feeLevel;
        this.status = status;
        this.creationDate = creationDate;
        this.confirmationDate = confirmationDate;
        this.cryptoType = cryptoType;
    }

    public String getCryptoType() {
        return cryptoType;
    }

    public void setCryptoType(String cryptoType) {
        this.cryptoType = cryptoType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public FeeLevel getFeeLevel() {
        return feeLevel;
    }

    public void setFeeLevel(FeeLevel feeLevel) {
        this.feeLevel = feeLevel;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getConfirmationDate() {
        return confirmationDate;
    }

    public void setConfirmationDate(LocalDateTime confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    private String cryptoType;
    
}
