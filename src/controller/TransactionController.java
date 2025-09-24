package controller;

import utils.Floger;
import utils.WalletValidator;

import java.util.Scanner;
import java.util.logging.Logger;

public class TransactionController {
    private static final Logger log = Floger.makelogger();

    private static Scanner sc = new Scanner(System.in);
    public static void handleTransactionCreation(){
        try {
            String sender = sc.nextLine();
            String receiver = sc.nextLine();
            if(WalletValidator.isValidBitcoinAddress(sender) && WalletValidator.isValidBitcoinAddress(receiver)){

            } else if (WalletValidator.isValidEthereumAddress( sender ) && WalletValidator.isValidEthereumAddress(receiver)) {

            }
        }catch(Exception e){
            log.warning("Failed to handle transaction creation"+e.getMessage());
        }
    }
}
