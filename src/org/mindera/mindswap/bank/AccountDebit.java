package org.mindera.mindswap.bank;

public class AccountDebit extends AccountBase {

    // gets

    public int getDebitBalance() {
        Transaction[] transactions = this.getTransactions();
        int balance = 0;

        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i].getType() == TransactionType.DEBIT_DEPOSIT) {
                balance += transactions[i].getValue();
            }

            if (transactions[i].getType() == TransactionType.DEBIT_WITHDRAW) {
                balance -= transactions[i].getValue();
            }

            if (transactions[i].getType() == TransactionType.DEBIT_PAYMENT) {
                balance -= transactions[i].getValue();
            }
        }

        return balance;
    }

    // sets


    // functions

    public RV newTransaction(TransactionType type, int value) {
        Transaction newTransaction = new Transaction(type, value, "debit transaction");
        RV returnValue = this.pushTransaction(newTransaction);
        return returnValue == RV.SUCCESS ? RV.SUCCESS : RV.GENERIC_ERROR;
    }
}
