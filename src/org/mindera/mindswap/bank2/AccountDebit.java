package org.mindera.mindswap.bank2;

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

    public ReturnValue newTransaction(TransactionType type, int value) {
        Transaction newTransaction = new Transaction(type, value, "debit transaction");
        ReturnValue returnValue = this.pushTransaction(newTransaction);
        return returnValue == ReturnValue.SUCCESS ? ReturnValue.SUCCESS : ReturnValue.GENERIC_ERROR;
    }
}
