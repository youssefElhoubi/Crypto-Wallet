package UI;

import domain.entities.Transaction;
import domain.enums.CryptoType;
import domain.enums.FeeLevel;
import domain.enums.TransactionStatus;
import utils.Validator;

import java.time.LocalDateTime;
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

    public static Transaction createTransactionFromUserInput() {
        System.out.println("=== Create New Transaction ===");

        UUID id = UUID.randomUUID(); // auto-generated

        // Crypto type
        System.out.println("Select crypto type: 1. Bitcoin  2. Ethereum");
        int cryptoChoice = Validator.isBetween(1, 2);
        String cryptoType = (cryptoChoice == 1) ? CryptoType.Bitcoin.toString() : CryptoType.Ethereum.toString();

        // Source Address
        System.out.print("Enter source address: ");
        String sourceAddress = sc.nextLine();

        // Destination Address
        System.out.print("Enter destination address: ");
        String destinationAddress = sc.nextLine();

        // Amount
        double amount = -1;
        while (amount <= 0) {
            System.out.print("Enter amount: ");
            if (sc.hasNextDouble()) {
                amount = sc.nextDouble();
                if (amount <= 0) {
                    System.out.println("⚠️ Amount must be greater than 0.");
                }
            } else {
                System.out.println("⚠️ Invalid input. Enter a number.");
                sc.next(); // discard
            }
        }

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
        } ;

        // Fee (user can provide manually)
        double fee = -1;
        while (fee < 0) {
            System.out.print("Enter fee: ");
            if (sc.hasNextDouble()) {
                fee = sc.nextDouble();
            } else {
                System.out.println("⚠️ Invalid input. Enter a number.");
                sc.next();
            }
        }

        sc.nextLine(); // clear buffer

        // Status
        System.out.println("Select transaction status: 1. PENDING  2. CONFIRMED  3. FAILED");
        int statusChoice = Validator.isBetween(1, 3);
        TransactionStatus status;
        switch (statusChoice) {
            case 1:
                status = TransactionStatus.PENDING;
                break;
            case 2:
                status = TransactionStatus.CONFIRMED;
                break;
            case 3:
                status = TransactionStatus.REJECTED;
                break;
            default:
                status = TransactionStatus.PENDING;
                break;
        }
        ;

        // Dates
        LocalDateTime creationDate = LocalDateTime.now();
        LocalDateTime confirmationDate = (status == TransactionStatus.CONFIRMED) ? LocalDateTime.now() : null;

        // Build Transaction
        return new Transaction(id, fee, sourceAddress, destinationAddress, amount, feeLevel, status, creationDate, confirmationDate, cryptoType);
    }


}
