package domain.entities;

import domain.enums.FeeLevel;
import domain.enums.TransactionStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    private UUID id;
    private String sourceAddress;
    private String destinationAddress;
    private Double amount;
    private FeeLevel feeLevel;
    private TransactionStatus status;
    private LocalDateTime creationDate;
    private LocalDateTime confirmationDate;
    private Double fee;
    private LocalDateTime passTime;


    public Transaction(UUID id, Double fee, String sourceAddress, String destinationAddress, Double amount, FeeLevel feeLevel, TransactionStatus status, LocalDateTime creationDate, LocalDateTime confirmationDate, String cryptoType, LocalDateTime passTime) {
        this.id = id;
        this.sourceAddress = sourceAddress;
        this.destinationAddress = destinationAddress;
        this.amount = amount;
        this.fee = fee;
        this.feeLevel = feeLevel;
        this.status = status;
        this.creationDate = creationDate;
        this.confirmationDate = confirmationDate;
        this.cryptoType = cryptoType;
        this.passTime = passTime;
    }

    public Transaction() {
    }

    public Transaction(UUID id, double fee, String sourceAddress, String destinationAddress, double amount, FeeLevel feeLevel, TransactionStatus transactionStatus, LocalDateTime localDateTime, LocalDateTime localDateTime1, String cryptoType, LocalDateTime localDateTime2, Object o) {
    }

    public Double getFee() {
        return fee;
    }

    public LocalDateTime getPassTime() {
        return passTime;
    }

    public void setPassTime(LocalDateTime passTime) {
        this.passTime = passTime;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCryptoType() {
        return cryptoType;
    }

    public void setCryptoType(String cryptoType) {
        this.cryptoType = cryptoType;
    }

    public UUID getId() {
        return id;
    }

    public void setId(String id) {
        this.id = UUID.fromString(id);
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
