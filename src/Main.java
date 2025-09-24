import UI.Menu;
import domain.entities.Wallet;
import domain.repository.WalletRepository;
import domain.services.WalletService;
import utils.Validator;

import java.time.LocalDateTime;
import java.util.UUID;
import domain.enums.CryptoType;
import utils.generator;

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
                    switch (choice) {
                        case 1:
                            try{
                                UUID id = UUID.randomUUID();
                                Wallet wallet = new Wallet(id,0,CryptoType.Bitcoin.toString(), LocalDateTime.now(),LocalDateTime.now(),generator.generateBitcoinAddress());
                                WalletService ws = new WalletService();
                                ws.createWallet(wallet);
                            } catch (Exception e){
                                e.printStackTrace();
                            }
                            break;
                        case 2:
                            break;
                    }
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