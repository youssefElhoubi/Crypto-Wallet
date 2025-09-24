package utils;

import domain.entities.Wallet;

public class WalletValidator {
    public static void validateWalletType(Wallet sender ,Wallet receiver){
        String walletSender = sender.getWalletType();
        String walletReceiver = receiver.getWalletType();
        if(!walletSender.equals(walletReceiver)){
            throw new RuntimeException("Wallets don't match can not made this transaction");
        }
    }
    public static boolean isValidEthereumAddress(String address) {
        if (address == null) return false;
        return address.matches("^0x[0-9a-fA-F]{40}$");
    }

    public static boolean isValidBitcoinAddress(String address) {
        if (address == null) return false;
        return address.matches("^(1|3)[a-km-zA-HJ-NP-Z1-9]{25,34}$")   // Legacy + P2SH
                || address.matches("^(bc1)[a-z0-9]{25,39}$");              // Bech32
    }
}
