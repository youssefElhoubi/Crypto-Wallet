package domain.services;

import domain.entities.Transaction;
import domain.entities.Wallet;
import domain.enums.TransactionStatus;
import domain.repository.TransactionRepository;
import domain.repository.WalletRepository;
import utils.Floger;
import utils.ValidateTransacsion;
import java.util.List;
import java.util.logging.Logger;

public class MempoolService extends Thread {
    private Logger log ;
    private TransactionRepository transactionRepo;
    private WalletRepository walletRepo;
    private Transaction firstTransaction;
    public MempoolService(){
        this.log = Floger.makelogger();
        this.transactionRepo = new TransactionRepository();
        this.walletRepo= new WalletRepository();
    }
    @Override
    public void run(){
        while(true){
            try{
                List<Transaction> transacsions;
                transacsions = transactionRepo.watingTransactions();
                this.firstTransaction = transacsions.get(0);
                ValidateTransacsion.validateTransacsion(firstTransaction);
                Wallet senderWallet = this.walletRepo.getWalletByAddress(firstTransaction.getSourceAddress());
                Wallet reseverWallet = this.walletRepo.getWalletByAddress(firstTransaction.getDestinationAddress());
                senderWallet.setBalance( senderWallet.getBalance() - firstTransaction.getFee());
                reseverWallet.setBalance( reseverWallet.getBalance() + firstTransaction.getFee());
                this.walletRepo.Update(reseverWallet);
                this.walletRepo.Update(senderWallet);
                firstTransaction.setStatus(TransactionStatus.CONFIRMED);
                transactionRepo.Update(firstTransaction);
            }catch(Exception e){
                this.firstTransaction.setStatus(TransactionStatus.REJECTED);
                throw new  RuntimeException("transaction balance is not enough");
            }
        }
    }
    public List<Transaction> mempoolList(){
        try{
            List<Transaction> transacsions;
            transacsions = transactionRepo.watingTransactions();
            return transacsions;
        }catch(Exception e){
            this.firstTransaction.setStatus(TransactionStatus.REJECTED);
            log.warning(e.getMessage());
            throw new  RuntimeException("transaction balance is not enough");
        }
    }
}