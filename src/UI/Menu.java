package UI;

public class Menu {
    public static void mainMenu(){
        System.out.println("\n=== CRYPTO WALLET SIMULATOR ===");
        System.out.println("1. Create a Wallet");
        System.out.println("2. Create a Transaction");
        System.out.println("3. View My Position in the Mempool");
        System.out.println("4. Compare Fee Levels");
        System.out.println("5. View Mempool State");
        System.out.println("0. Exit");
        System.out.print("👉 Enter your choice: ");
    }
    public static void choseWalletType(){
        System.out.println("\n=== CRYPTO WALLET TYPE ===");
        System.out.println("1. Bitcoin ");
        System.out.println("3. Ethereum");
    }
    public static void choseTransactionType(){
        System.out.println("\n=== CRYPTO TRANSACTION TYPE ===");
        System.out.println("1. Bitcoin ");
        System.out.println("3. Ethereum");
    }
    public static void transferWallet(){
        System.out.println("\n=== Enter wallet address");
    }


}
