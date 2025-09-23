import domain.repository.dataBaseConnection;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        try{
            Connection connection = dataBaseConnection.getInstence();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Welcome to Crypto-Wallet");
    }
}