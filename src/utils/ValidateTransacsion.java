package utils;

import domain.entities.Transaction;
import domain.entities.Wallet;
import domain.repository.WalletRepository;

public class ValidateTransacsion {
    public static void validateTransacsion(Transaction tx) throws Exception{
        try {
            String senderAddres = tx.getSourceAddress();
            Wallet senderWallet = new WalletRepository().getWalletByAddress(senderAddres);
            if (senderWallet.getBalance() < tx.getAmount()) {
                throw new Exception("Insufficient funds");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
