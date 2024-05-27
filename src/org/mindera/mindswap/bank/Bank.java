package org.mindera.mindswap.bank;

public class Bank {

    private String name;
    private AccountDebit debitAccount;
    private AccountCredit creditAccount;
    private int maxCreditAllowed = 100;
    private int negativeCreditTransationFee = 2;


    // constructors
    public Bank(String name) {
        this.name = name;
    }

    // gets

    public String getName() {
        return this.name;
    }

    // WARNING! conflict with return values and balance! CHANGE THIS!
    public int getDebitBalance() {
        if (this.debitAccount == null) {
            return ReturnValue.NO_DEBIT_CARD_FOUND;
        }

        return this.debitAccount.getDebitBalance();
    }

    // WARNING! conflict with return values and balance! CHANGE THIS!
    public int getCreditBalance() {
        if (this.creditAccount == null) {
            return ReturnValue.NO_CREDIT_CARD_FOUND;
        }

        return this.creditAccount.getCreditBalance();
    }

    //sets


    // functions

    public int newDebitCard() {
        if (this.debitAccount != null) {
            return ReturnValue.DEBIT_CARD_ALREADY_EXIST;
        }

        int check = this.initDebitAccount();
        return check == ReturnValue.SUCCESS ? ReturnValue.SUCCESS : ReturnValue.GENERIC_ERROR;
    }

    public int debitDeposit(int value) {
        if (this.debitAccount == null) {
            return ReturnValue.NO_DEBIT_CARD_FOUND;
        }

        int check = this.debitAccount.newTransaction(Transaction.TransactionType.DEBIT_DEPOSIT, value);
        return check == ReturnValue.SUCCESS ? ReturnValue.SUCCESS : ReturnValue.DEBIT_DEPOSIT_ERROR;
    }

    public int widthdraw(int value) {
        if (this.debitAccount == null) {
            return ReturnValue.NO_DEBIT_CARD_FOUND;
        }

        if ((this.getDebitBalance() - value) < 0) {
            return ReturnValue.NO_DEBIT_BALANCE;
        }

        int check = this.debitAccount.newTransaction(Transaction.TransactionType.DEBIT_WITHDRAW, value);
        return check == ReturnValue.SUCCESS ? ReturnValue.SUCCESS : ReturnValue.DEBIT_WIDTHDRAW_ERROR;
    }

    public int debitPay(int value) {
        if (this.debitAccount == null) {
            return ReturnValue.NO_DEBIT_CARD_FOUND;
        }

        if ((this.getDebitBalance() - value) < 0) {
            return ReturnValue.NO_DEBIT_BALANCE;
        }

        int check = this.debitAccount.newTransaction(Transaction.TransactionType.DEBIT_PAYMENT, value);
        return check == ReturnValue.SUCCESS ? ReturnValue.SUCCESS : ReturnValue.DEBIT_PAYMENT_ERROR;
    }

    private int initDebitAccount() {
        this.debitAccount = new AccountDebit();
        return ReturnValue.SUCCESS;
    }

    public int printDebitTransactions() {
        if (this.debitAccount == null) {
            return ReturnValue.NO_DEBIT_CARD_FOUND;
        }

        this.debitAccount.printTransactions();
        return ReturnValue.SUCCESS;
    }

    public int newCreditCard() {
        if (this.creditAccount != null) {
            return ReturnValue.CREDIT_CARD_ALREADY_EXIST;
        }

        this.initCreditAccount();
        return ReturnValue.SUCCESS;
    }

    public int creditDeposit(int value) {
        if (this.creditAccount == null) {
            return ReturnValue.NO_CREDIT_CARD_FOUND;
        }

        int check = this.creditAccount.newTransaction(Transaction.TransactionType.CREDIT_DEPOSIT, value);
        return check == ReturnValue.SUCCESS ? ReturnValue.SUCCESS : ReturnValue.CREDIT_DEPOSIT_ERROR;
    }

    public int creditPay(int value) {
        if (this.creditAccount == null) {
            return ReturnValue.NO_CREDIT_CARD_FOUND;
        }

        if ((this.getCreditBalance() - value) < 0) {
            if ((this.getCreditBalance() - value) < -this.maxCreditAllowed) {
                return ReturnValue.NO_CREDIT_BALANCE;
            }

            // apply negative credit tax
            value = value + negativeCreditTransationFee;
        }

        int check = this.creditAccount.newTransaction(Transaction.TransactionType.CREDIT_PAYMENT, value);
        return check == ReturnValue.SUCCESS ? ReturnValue.SUCCESS : ReturnValue.CREDIT_PAYMENT_ERROR;
    }

    private int initCreditAccount() {
        this.creditAccount = new AccountCredit();
        return ReturnValue.SUCCESS;
    }

    public int printCreditTransactions() {
        if (this.creditAccount == null) {
            return ReturnValue.NO_CREDIT_CARD_FOUND;
        }

        this.creditAccount.printTransactions();
        return ReturnValue.SUCCESS;
    }
}