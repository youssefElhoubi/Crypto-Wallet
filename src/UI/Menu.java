package UI;

public class Menu {
    public void mainMenu(){
        System.out.println("\n=== CRYPTO WALLET SIMULATOR ===");
        System.out.println("1. Create a Wallet");
        System.out.println("2. Create a Transaction");
        System.out.println("3. View My Position in the Mempool");
        System.out.println("4. Compare Fee Levels");
        System.out.println("5. View Mempool State");
        System.out.println("0. Exit");
        System.out.print("👉 Enter your choice: ");
    }

    public void handleChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println("🔐 [Create Wallet selected]");
                break;
            case 2:
                System.out.println("💸 [Create Transaction selected]");
                break;
            case 3:
                System.out.println("📊 [View Position in Mempool selected]");
                break;
            case 4:
                System.out.println("⚖️ [Compare Fee Levels selected]");
                break;
            case 5:
                System.out.println("📜 [View Mempool State selected]");
                break;
            case 0:
                System.out.println("👋 Exiting... Goodbye!");
                break;
            default:
                System.out.println("⚠️ Invalid option. Try again.");
        }
    }

}
