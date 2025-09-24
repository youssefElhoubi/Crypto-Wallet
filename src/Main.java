import UI.Menu;
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
                    
                    break;
                case 2:
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