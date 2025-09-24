package utils;

import domain.entities.Wallet;

import java.util.logging.Logger;

public class WalletValidator {
    private static final Logger log  = Floger.makelogger();
    public static boolean isValidEthereumAddress(String address) {
        return address.matches("^0x[0-9a-fA-F]{40}$");
    }

    public static boolean isValidBitcoinAddress(String address) {
        return address.matches("^(1|3)[a-km-zA-HJ-NP-Z1-9]{25,34}$")   // Legacy + P2SH
                || address.matches("^(bc1)[a-z0-9]{25,39}$");              // Bech32
    }
}
