package UI;

import domain.entities.Transaction;
import domain.enums.CryptoType;
import domain.enums.FeeLevel;
import domain.enums.TransactionStatus;
import domain.services.FeeCalculator;
import domain.services.MempoolService;
import utils.TransactionSummary;
import utils.Validator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Menu {
    private static final Scanner sc = new Scanner(System.in);

    public static void mainMenu() {
        System.out.println("\n=== CRYPTO WALLET SIMULATOR ===");
        System.out.println("1. Create a Wallet");
        System.out.println("2. Create a Transaction");
        System.out.println("3. View My Position in the Mempool");
        System.out.println("4. Compare Fee Levels");
        System.out.println("5. View Mempool State");
        System.out.println("0. Exit");
        System.out.print("👉 Enter your choice: ");
    }

    public static void choseWalletType() {
        System.out.println("\n=== CRYPTO WALLET TYPE ===");
        System.out.println("1. Bitcoin ");
        System.out.println("3. Ethereum");
    }

    public static void choseTransactionType() {
        System.out.println("\n=== CRYPTO TRANSACTION TYPE ===");
        System.out.println("1. Bitcoin ");
        System.out.println("3. Ethereum");
    }

    public static void transferWallet() {
        System.out.println("\n=== Enter wallet address");
    }

    public static Transaction createTransactionFromUserInput(CryptoType CT, String sender, String resever) {
        System.out.println("=== Create New Transaction ===");

        UUID id = UUID.randomUUID(); // auto-generated

        // Crypto type
        String cryptoType = CT.toString();

        String sourceAddress = sender;

        String destinationAddress = resever;

        // Amount
        System.out.println("please enter the amount you want to transfer");
        double amount = Validator.askPositiveDouble("");

        // Fee Level
        System.out.println("Select fee level: 1. ECONOMIC  2. STANDARD  3. RAPID");
        int feeChoice = Validator.isBetween(1, 3);
        FeeLevel feeLevel;
        switch (feeChoice) {
            case 1:
                feeLevel = FeeLevel.ECONOMIQUE;
                break;
            case 2:
                feeLevel = FeeLevel.STANDARD;
                break;
            case 3:
                feeLevel = FeeLevel.RAPIDE;
                break;
            default:
                feeLevel = FeeLevel.STANDARD;
                break;
        }


        // Status
        System.out.println("Select transaction status: 1. PENDING  2. CONFIRMED  3. FAILED");

        TransactionStatus status = TransactionStatus.PENDING;

        double fee = FeeCalculator.calculateFee(amount, feeLevel);

        // Dates
        LocalDateTime creationDate = LocalDateTime.now();
        LocalDateTime confirmationDate = (status == TransactionStatus.CONFIRMED) ? LocalDateTime.now() : null;
        LocalDateTime passTime = LocalDateTime.now();
        switch (feeLevel) {
            case ECONOMIQUE:
                passTime.plusMinutes(5);
                break;
            case STANDARD:
                passTime.plusMinutes(2);
                break;
            case RAPIDE:
                passTime.plusMinutes(1);
                break;
        }
        // Build Transaction
        return new Transaction(id, fee, sourceAddress, destinationAddress, amount, feeLevel, status, creationDate, confirmationDate, cryptoType, passTime);
    }

    public static void placeInMempool(String walletAddress) {
        List<Transaction> pendingTransactions = new MempoolService().mempoolList();
        String top = "┌──────────────────────────────────┬────────┐";
        String header = "│ Transaction (autres utilisateurs) │ Frais  │";
        String separator = "├──────────────────────────────────┼────────┤";
        String bottom = "└──────────────────────────────────┴────────┘";

        System.out.println(top);
        System.out.println(header);
        System.out.println(separator);
        for (Transaction tx : pendingTransactions) {
            String address = tx.getSourceAddress();
            String shortAddr = address.length() > 8 ? address.substring(0, 8) + "..." : address;

            String label;
            if (tx.getSourceAddress().toString().equals(walletAddress)) {
                label = ">>> VOTRE TX: " + shortAddr;
            } else {
                label = shortAddr + " (anonyme)";
            }

            System.out.printf("│ %-32s │ %6.2f$ │%n", label, tx.getFee());
        }

        System.out.println(bottom);
    }
    public static void printTransactionSummaries(List<TransactionSummary> summaries) {
        if (summaries == null || summaries.isEmpty()) {
            System.out.println("⚠️ No transaction summaries found.");
            return;
        }

        // Table header
        System.out.printf("%-15s %-10s %-10s %-15s%n", "Priority", "Position", "Fees", "Total Pass Time");
        System.out.println("------------------------------------------------------------");

        // Table rows
        for (TransactionSummary summary : summaries) {
            System.out.printf("%-15s %-10d %-10.2f %-15s%n",
                    summary.getPriority(),
                    summary.getPosition(),
                    summary.getFees(),
                    summary.getTotalPassTime());
        }
    }
}
