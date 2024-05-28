package org.mindera.mindswap.bank2;

public class Client {

    private String name;
    private int nif;
    private Bank[] banks = new Bank[0];
    private int[] bankAccounts = new int[10];
    private Card[] cards = new Card[2];

    private int defaultBank;

    // contructors
    public Client(String name, int nif) {

        this.name = name;
        this.nif = nif;
    }

    // gets

    public int getDebitBalance() {
        return this.banks[defaultBank].getDebitBalance();
    }
    public int getCreditBalance() {

        return this.banks[defaultBank].getCreditBalance();
    }

    public int getNif() {
        return this.nif;
    }

    public int getAccountNumber() {
        return this.bankAccounts[0];
    }

    public Card getDebitCard() {
        return this.cards[0];
    }

    // sets

    // functions

    public void newBankAccount(int newBankAccountNumber) {

        for (int i = 0; i < this.bankAccounts.length; i++) {
            if (this.bankAccounts[i] == 0) {
                this.bankAccounts[i] = newBankAccountNumber;
                break;
            }
        }
    }

    public void addCard(Card newCard) {

        switch (newCard.getType()) {

            case CardTypeE.DEBIT :
                if (this.cards[0] != null) {
                    return;
                }

                this.cards[0] = newCard;
                return;
            case CardTypeE.CREDIT :
                if (this.cards[1] != null) {
                    return;
                }

                this.cards[1] = newCard;

        }

    }












    public ReturnValue newBankAccount(Bank newBank) {
        if (this.checkIfBankAlreadyExists(newBank)) {
            return ReturnValue.BANK_ALREADY_EXIST;
        }

        this.pushNewBankClient(newBank);
        return ReturnValue.SUCCESS;
    }

    // debit
    public ReturnValue newDebitCard() {
        if (this.banks.length == 0) {
            return ReturnValue.NO_BANK_EXISTS;
        }

        return this.banks[defaultBank].newDebitCard();
    }

    public ReturnValue debitDeposit(int depositValue) {
        if (this.banks.length == 0) {
            return ReturnValue.NO_BANK_EXISTS;
        }

        if (depositValue <= 0) {
            return ReturnValue.INVALID_TRANSACTION_VALUE;
        }

        return this.banks[defaultBank].debitDeposit(depositValue);
    }

    public ReturnValue withdraw(int withdrawValue) {
        if (this.banks.length == 0) {
            return ReturnValue.NO_BANK_EXISTS;
        }

        if (withdrawValue <= 0) {
            return ReturnValue.INVALID_TRANSACTION_VALUE;
        }

        return this.banks[defaultBank].withdraw(withdrawValue);
    }

    public ReturnValue debitPay(int payValue) {
        if (this.banks.length == 0) {
            return ReturnValue.NO_BANK_EXISTS;
        }

        if (payValue <= 0) {
            return ReturnValue.INVALID_TRANSACTION_VALUE;
        }

        return this.banks[defaultBank].debitPay(payValue);
    }

    // credit
    public ReturnValue newCreditCard() {
        if (this.banks.length == 0) {
            return ReturnValue.NO_BANK_EXISTS;
        }

        return this.banks[defaultBank].newCreditCard();
    }

    public ReturnValue creditDeposit(int depositValue) {
        if (this.banks.length == 0) {
            return ReturnValue.NO_BANK_EXISTS;
        }

        if (depositValue <= 0) {
            return ReturnValue.INVALID_TRANSACTION_VALUE;
        }

        return this.banks[defaultBank].creditDeposit(depositValue);
    }

    public ReturnValue creditPay(int payValue) {
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
            if (newBank.getName().equals(this.banks[i].getName())) {
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
