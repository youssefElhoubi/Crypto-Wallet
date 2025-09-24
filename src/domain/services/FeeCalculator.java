package domain.services;

import domain.entities.Transaction;
import domain.enums.FeeLevel;

import static domain.enums.FeeLevel.ECONOMIQUE;
import static domain.enums.FeeLevel.RAPIDE;
import static domain.enums.FeeLevel.STANDARD;

public class FeeCalculator {
    public static float feePersentage;
    public static double feeAmount;

    public static Transaction calculateFee(Transaction t) {
        FeeLevel feeLevel = t.getFeeLevel();
        switch (feeLevel) {
            case ECONOMIQUE:
                feePersentage = 5;
                break;
            case RAPIDE:
                feePersentage = 6;
                break;
            case STANDARD:
                feePersentage = 3;
                break;
        }
        feeAmount = t.getAmount() * feePersentage / 100;

        t.setFee(feeAmount);

        return t;
    }

}