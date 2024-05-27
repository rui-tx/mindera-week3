package org.mindera.mindswap.bank;

public class AccountDebit extends AccountBase {

    // gets

    public int getDebitBalance() {
        Transaction[] transactions = this.getTransactions();
        int balance = 0;

        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i].getType() == Transaction.TransactionType.DEBIT_DEPOSIT) {
                balance += transactions[i].getValue();
            }

            if (transactions[i].getType() == Transaction.TransactionType.DEBIT_WITHDRAW) {
                balance -= transactions[i].getValue();
            }

            if (transactions[i].getType() == Transaction.TransactionType.DEBIT_PAYMENT) {
                balance -= transactions[i].getValue();
            }
        }

        return balance;
    }

    // sets


    // functions

    public int newTransaction(int type, int value) {
        Transaction newTransaction = new Transaction(type, value, "debit transaction");
        int check = this.pushTransaction(newTransaction);

        return check == ReturnValue.SUCCESS ? ReturnValue.SUCCESS : ReturnValue.GENERIC_ERROR;
    }
}
