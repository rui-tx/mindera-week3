package org.mindera.mindswap.bank;

public class AccountCredit extends AccountBase {

    public int getCreditBalance() {
        Transaction[] transactions = this.getTransactions();
        int balance = 0;

        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i].getType() == Transaction.TransactionType.CREDIT_DEPOSIT) {
                balance += transactions[i].getValue();
            }

            if (transactions[i].getType() == Transaction.TransactionType.CREDIT_PAYMENT) {
                balance -= transactions[i].getValue();
            }
        }

        return balance;
    }

    public int newTransaction(int type, int value) {
        Transaction newTransaction = new Transaction(type, value, "credit transaction");
        int check = this.pushTransaction(newTransaction);

        return check == ReturnValue.SUCCESS ? ReturnValue.SUCCESS : ReturnValue.GENERIC_ERROR;
    }
}