package utils;

public class TransactionSummary {
    private String priority;
    private int position;
    private double fees;
    private String totalPassTime; // HH:MM:SS format from SEC_TO_TIME()

    // ✅ Constructor
    public TransactionSummary(String priority, int position, double fees, String totalPassTime) {
        this.priority = priority;
        this.position = position;
        this.fees = fees;
        this.totalPassTime = totalPassTime;
    }

    // ✅ Empty constructor
    public TransactionSummary() {}

    // ✅ Getters and Setters
    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public String getTotalPassTime() {
        return totalPassTime;
    }

    public void setTotalPassTime(String totalPassTime) {
        this.totalPassTime = totalPassTime;
    }

    @Override
    public String toString() {
        return "TransactionSummary{" +
                "priority='" + priority + '\'' +
                ", position=" + position +
                ", fees=" + fees +
                ", totalPassTime='" + totalPassTime + '\'' +
                '}';
    }
}
