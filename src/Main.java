import UI.Menu;
import controller.TransactionController;
import controller.WalletController;
import domain.entities.Mempool;
import domain.services.MempoolService;
import utils.Validator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        Thread mempoolThread = new Thread(new MempoolService());
        mempoolThread.start();
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
                    System.out.println("please enter your wallet address:");
                    String address  = sc.nextLine() ;
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