package org.mindera.mindswap.bank2;

public abstract class AccountBase {

    private Transaction[] transactions = new Transaction[0];

    // gets

    public Transaction[] getTransactions() {
        return transactions;
    }

    public void printTransactions() {
        for (int i = 0; i < this.transactions.length; i++) {
            this.transactions[i].printTransaction();
        }
    }

    // sets


    // functions

    public ReturnValue pushTransaction(Transaction transaction) {
        // create new array with 1 more position
        Transaction[] newTransactionList = new Transaction[transactions.length + 1];

        // copy old values
        for (int i = 0; i < transactions.length; i++) {
            newTransactionList[i] = transactions[i];
        }

        // push value to last position
        newTransactionList[newTransactionList.length - 1] = transaction;

        transactions = newTransactionList;

        return ReturnValue.SUCCESS;
    }
}
