package utils;

import java.security.SecureRandom;

public class generator {
    private static final String HEX_CHARS = "0123456789abcdef";
    private static final SecureRandom random = new SecureRandom();

    /**
     * Generates a random Ethereum address.
     * Format: 0x + 40 hex characters
     */
    public static String generateEthereumAddress() {
        StringBuilder sb = new StringBuilder("0x");
        for (int i = 0; i < 40; i++) {
            sb.append(HEX_CHARS.charAt(random.nextInt(HEX_CHARS.length())));
        }
        return sb.toString();
    }

    /**
     * Generates a random Bitcoin address.
     * Format: Starts with "1", "3", or "bc1"
     */
    public static String generateBitcoinAddress() {
        String prefix;
        int pick = random.nextInt(3);
        if (pick == 0) {
            prefix = "1";
        } else if (pick == 1) {
            prefix = "3";
        } else {
            prefix = "bc1";
        }

        // Bitcoin addresses are usually 26–35 chars long (simplified here)
        String chars = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz"; // Base58
        StringBuilder sb = new StringBuilder(prefix);
        int length = 25 + random.nextInt(10); // 25–34 chars
        for (int i = prefix.length(); i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }
}
