package controller;

import UI.Menu;
import domain.entities.Transaction;
import domain.entities.Wallet;
import domain.enums.CryptoType;
import domain.repository.TransactionRepository;
import domain.services.TransactionService;
import domain.services.WalletService;
import utils.Floger;
import utils.WalletValidator;

import java.util.Scanner;
import java.util.logging.Logger;

public class TransactionController {
    private static final Logger log = Floger.makelogger();
    private static WalletService walletService = new WalletService();

    private static Scanner sc = new Scanner(System.in);
    public static void handleTransactionCreation(){
        try {
            String sender = sc.nextLine();
            String receiver = sc.nextLine();
            TransactionService transaction = new TransactionService(new TransactionRepository());
            if(WalletValidator.isValidBitcoinAddress(sender) && WalletValidator.isValidBitcoinAddress(receiver)){
                Wallet senderWallet = walletService.getWalletByAddress(sender);
                Wallet reserverWallet = walletService.getWalletByAddress(receiver);
                Transaction t =   Menu.createTransactionFromUserInput(CryptoType.Bitcoin, senderWallet.getWallet_address() , reserverWallet.getWallet_address());
                transaction.makeTransaction(t);
            } else if (WalletValidator.isValidEthereumAddress( sender ) && WalletValidator.isValidEthereumAddress(receiver)) {
                Wallet senderWallet = walletService.getWalletByAddress(sender);
                Wallet reserverWallet = walletService.getWalletByAddress(receiver);
                Transaction t =   Menu.createTransactionFromUserInput(CryptoType.Bitcoin, senderWallet.getWallet_address() , reserverWallet.getWallet_address());
                transaction.makeTransaction(t);
            }
        }catch(Exception e){
            log.warning("Failed to handle transaction creation"+e.getMessage());
        }
    }
}
