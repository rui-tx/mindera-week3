package org.mindera.mindswap.bank2;


public class ClientAccount {

    private int nif;
    private int accountNumber;
    private AccountBase[] accounts;

    public ClientAccount(int nif, int accountNumber) {
        this.nif = nif;
        this.accountNumber = accountNumber;
        this.accounts = new AccountBase[2]; // 0 debit, 1 credit
    }

    public void deposit(int amount) {

        ReturnValue returnValue = this.newTransaction(TransactionType.DEBIT_DEPOSIT, amount);
        return;
    }

    private ReturnValue newTransaction(TransactionType type, int value) {
        Transaction newTransaction = new Transaction(type, value, "debit transaction");
        ReturnValue returnValue = this.accounts[0].pushTransaction(newTransaction);
        return returnValue == ReturnValue.SUCCESS ? ReturnValue.SUCCESS : ReturnValue.GENERIC_ERROR;
    }


    @Override
    public String toString() {
        return "Client nif: " + nif + " account number: " + accountNumber;
    }
}
