import UI.Menu;
import controller.TransactionController;
import controller.WalletController;
import utils.Validator;

public class Main {

    public static void main(String[] args) {
        int choice;
        System.out.println("Welcome to Crypto-Wallet");
        while (true) {
            Menu.mainMenu();
            choice = Validator.isBetween(1, 5);
            switch (choice) {
                case 1:
                    Menu.choseWalletType();
                    choice = Validator.isBetween(1, 2);
                    WalletController.handelWalletCreation(choice);
                    break;
                case 2:
                    TransactionController.handleTransactionCreation();

                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    return;
            }
        }

    }
}