package org.mindera.mindswap.bank2;

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

    public ReturnValue newTransaction(TransactionType type, int value) {
        Transaction newTransaction = new Transaction(type, value, "credit transaction");
        ReturnValue returnValue = this.pushTransaction(newTransaction);

        return returnValue == ReturnValue.SUCCESS ? ReturnValue.SUCCESS : ReturnValue.GENERIC_ERROR;
    }
}