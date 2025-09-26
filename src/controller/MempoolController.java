package controller;
import UI.Menu;
import utils.WalletValidator;

import java.util.Scanner;

public class MempoolController {
    public static void  posetioInMempool(String address){
        try {
            if (WalletValidator.isValidEthereumAddress(address)|| WalletValidator.isValidEthereumAddress(address)){
                Menu.placeInMempool(address);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
