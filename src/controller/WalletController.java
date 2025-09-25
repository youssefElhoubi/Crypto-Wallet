package controller;

import domain.entities.Wallet;
import domain.enums.CryptoType;
import domain.services.WalletService;
import utils.generator;

import java.time.LocalDateTime;
import java.util.UUID;

public class WalletController {
    public static void handelWalletCreation(int choice){
        switch (choice) {
            case 1:
                try{
                    UUID id = UUID.randomUUID();
                    Wallet wallet = new Wallet(id,0, CryptoType.Bitcoin.toString(), LocalDateTime.now(),LocalDateTime.now(), generator.generateBitcoinAddress());
                    WalletService ws = new WalletService();
                    ws.createWallet(wallet);
                    System.out.println("✅ Wallet created:" + wallet.getWallet_address());
                } catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case 2:
                try{
                    UUID id = UUID.randomUUID();
                    Wallet wallet = new Wallet(id,0, CryptoType.Ethereum.toString(), LocalDateTime.now(),LocalDateTime.now(), generator.generateEthereumAddress());
                    WalletService ws = new WalletService();
                    ws.createWallet(wallet);
                    System.out.println("✅ Wallet created:" + wallet.getWallet_address());
                } catch (Exception e){
                    e.printStackTrace();
                }
                break;
        }
    }
}
