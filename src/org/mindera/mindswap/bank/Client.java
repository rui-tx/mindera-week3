package org.mindera.mindswap.bank;

public class Client {

    private String name;
    private Bank[] banks = new Bank[0];
    private int defaultBank;

    // contructors
    public Client(String name) {
        this.name = name;
    }

    // gets

    public int getDebitBalance() {
        return this.banks[defaultBank].getDebitBalance();
    }

    public int getCreditBalance() {
        return this.banks[defaultBank].getCreditBalance();
    }

    // sets

    // functions


    public int newBankAccount (Bank newBank){
        if (this.checkIfBankAlreadyExists(newBank)) {
            return ReturnValue.BANK_ALREADY_EXIST;
        }

        this.pushNewBankClient(newBank);
        return ReturnValue.SUCCESS;
    }

    // debit
    public int newDebitCard() {
        if (this.banks.length == 0) {
            return ReturnValue.NO_BANK_EXISTS;
        }

        return this.banks[defaultBank].newDebitCard();
    }

    public int debitDeposit(int depositValue) {
        if (this.banks.length == 0) {
            return ReturnValue.NO_BANK_EXISTS;
        }

        if (depositValue <= 0) {
            return ReturnValue.INVALID_TRANSACTION_VALUE;
        }

        return this.banks[defaultBank].debitDeposit(depositValue);
    }

    public int widthdraw(int widthdrawValue) {
        if (this.banks.length == 0) {
            return ReturnValue.NO_BANK_EXISTS;
        }

        if (widthdrawValue <= 0) {
            return ReturnValue.INVALID_TRANSACTION_VALUE;
        }

        return this.banks[defaultBank].widthdraw(widthdrawValue);
    }

    public int debitPay(int payValue) {
        if (this.banks.length == 0) {
            return ReturnValue.NO_BANK_EXISTS;
        }

        if (payValue <= 0) {
            return ReturnValue.INVALID_TRANSACTION_VALUE;
        }

        return this.banks[defaultBank].debitPay(payValue);
    }

    // credit
    public int newCreditCard() {
        if (this.banks.length == 0) {
            return ReturnValue.NO_BANK_EXISTS;
        }

        return this.banks[defaultBank].newCreditCard();
    }

    public int creditDeposit(int depositValue) {
        if (this.banks.length == 0) {
            return ReturnValue.NO_BANK_EXISTS;
        }

        if (depositValue <= 0) {
            return ReturnValue.INVALID_TRANSACTION_VALUE;
        }

        return this.banks[defaultBank].creditDeposit(depositValue);
    }

    public int creditPay(int payValue) {
        if (this.banks.length == 0) {
            return ReturnValue.NO_BANK_EXISTS;
        }

        if (payValue <= 0) {
            return ReturnValue.INVALID_TRANSACTION_VALUE;
        }

        return this.banks[defaultBank].creditPay(payValue);
    }

    private boolean checkIfBankAlreadyExists(Bank newBank) {
        for (int i = 0; i < this.banks.length; i++) {
            if(newBank.getName().equals(this.banks[i].getName())) {
                return true;
            }
        }

        return false;
    }

    private void pushNewBankClient(Bank newBank) {

        // create new array with 1 more position
        Bank[] newBankList = new Bank[this.banks.length + 1];

        // copy old values
        for (int i = 0; i < this.banks.length; i++) {
            newBankList[i] = this.banks[i];
        }

        // push value to last position
        newBankList[newBankList.length - 1] = newBank;

        // update client with the new bank list
        this.banks = newBankList;
    }

    public void debugPrint() {

        System.out.println("\n>>> Debug <<<");
        System.out.println("Client first created bank: " + this.banks[defaultBank].getName());
        System.out.println("Debit Transactions of " + this.name + ": ");
        this.banks[defaultBank].printDebitTransactions();
        //System.out.println("Debit account balance: " + this.getDebitBalance());

        System.out.println("Credit Transactions of " + this.name + ": ");
        this.banks[defaultBank].printCreditTransactions();
        System.out.println("Credit account balance: " + this.getCreditBalance());

        System.out.println();
        //this.banks[defaultBank].debugDebitAccount();
    }

}
