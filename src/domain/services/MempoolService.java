package domain.services;

import domain.entities.Transaction;
import domain.entities.Wallet;
import domain.enums.TransactionStatus;
import domain.repository.TransactionRepository;
import domain.repository.WalletRepository;
import utils.Floger;
import utils.ValidateTransacsion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

public class MempoolService extends Thread {
    private Logger log;
    private TransactionRepository transactionRepo;
    private WalletRepository walletRepo;
    private Transaction firstTransaction;

    public MempoolService() {
        this.log = Floger.makelogger();
        this.transactionRepo = new TransactionRepository();
        this.walletRepo = new WalletRepository();
    }

    @Override
    public void run() {
        while (true) {
            try {
                List<Transaction> transactions = transactionRepo.watingTransactions();

                if (transactions.isEmpty()) {
                    Thread.sleep(1000);
                    continue;
                }

                this.firstTransaction = transactions.get(0);

                ValidateTransacsion.validateTransacsion(firstTransaction);

                Wallet senderWallet = this.walletRepo.getWalletByAddress(firstTransaction.getSourceAddress());
                Wallet receiverWallet = this.walletRepo.getWalletByAddress(firstTransaction.getDestinationAddress());

                senderWallet.setBalance(senderWallet.getBalance() - firstTransaction.getFee());
                receiverWallet.setBalance(senderWallet.getBalance());

                this.walletRepo.Update(receiverWallet);
                this.walletRepo.Update(senderWallet);

                firstTransaction.setStatus(TransactionStatus.CONFIRMED);
                firstTransaction.setConfirmationDate(LocalDateTime.now());
                transactionRepo.Update(firstTransaction);

                Thread.sleep(1000);

            } catch (Exception e) {
                if (this.firstTransaction != null) {
                    this.firstTransaction.setStatus(TransactionStatus.REJECTED);
                    transactionRepo.Update(this.firstTransaction);
                }
                // instead of throwing -> just sleep & continue
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                }
                continue;
            }
        }
    }

    public List<Transaction> mempoolList() {
        try {
            List<Transaction> transacsions;
            transacsions = transactionRepo.watingTransactions();
            return transacsions;
        } catch (Exception e) {
            this.firstTransaction.setStatus(TransactionStatus.REJECTED);
            log.warning(e.getMessage());
            throw new RuntimeException("transaction balance is not enough");
        }
    }
    public List<Transaction> mempoolStatus() throws Exception{
        try {
            return this.transactionRepo.memPooleStatus();
        } catch (Exception e) {
            throw new Exception("transaction balance is not enough" + e.getMessage());
        }
    }
}