package org.mindera.mindswap.bank;

public class AccountCredit extends AccountBase {

    public int getCreditBalance() {
        Transaction[] transactions = this.getTransactions();
        int balance = 0;

        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i].getType() == TransactionType.CREDIT_DEPOSIT) {
                balance += transactions[i].getValue();
            }

            if (transactions[i].getType() == TransactionType.CREDIT_PAYMENT) {
                balance -= transactions[i].getValue();
            }
        }

        return balance;
    }

    public RV newTransaction(TransactionType type, int value) {
        Transaction newTransaction = new Transaction(type, value, "credit transaction");
        RV returnValue = this.pushTransaction(newTransaction);

        return returnValue == RV.SUCCESS ? RV.SUCCESS : RV.GENERIC_ERROR;
    }
}