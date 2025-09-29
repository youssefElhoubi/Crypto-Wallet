package controller;
import UI.Menu;
import utils.WalletValidator;


public class MempoolController {
    public static void  posetioInMempool(String address){
        try {
            if (WalletValidator.isValidEthereumAddress(address) || WalletValidator.isValidBitcoinAddress(address)){
                Menu.placeInMempool(address);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void mempooleStatuc(){
        try {
            Menu.memPoolStatus();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
