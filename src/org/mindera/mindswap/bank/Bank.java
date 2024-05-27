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
            return RV.NO_DEBIT_CARD_FOUND.getCode();
        }

        return this.debitAccount.getDebitBalance();
    }

    // WARNING! conflict with return values and balance! CHANGE THIS!
    public int getCreditBalance() {
        if (this.creditAccount == null) {
            return RV.NO_CREDIT_CARD_FOUND.getCode();
        }

        return this.creditAccount.getCreditBalance();
    }

    //sets


    // functions

    public RV newDebitCard() {
        if (this.debitAccount != null) {
            return RV.DEBIT_CARD_ALREADY_EXIST;
        }

        RV returnValue = this.initDebitAccount();
        return returnValue == RV.SUCCESS ? RV.SUCCESS : RV.GENERIC_ERROR;
    }

    public RV debitDeposit(int value) {
        if (this.debitAccount == null) {
            return RV.NO_DEBIT_CARD_FOUND;
        }

        RV returnValue = this.debitAccount.newTransaction(TransactionType.DEBIT_DEPOSIT, value);
        return returnValue == RV.SUCCESS ? RV.SUCCESS : RV.DEBIT_DEPOSIT_ERROR;
    }

    public RV withdraw(int value) {
        if (this.debitAccount == null) {
            return RV.NO_DEBIT_CARD_FOUND;
        }

        if ((this.getDebitBalance() - value) < 0) {
            return RV.NO_DEBIT_BALANCE;
        }

        RV returnValue = this.debitAccount.newTransaction(TransactionType.DEBIT_WITHDRAW, value);
        return returnValue == RV.SUCCESS ? RV.SUCCESS : RV.DEBIT_WITHDRAW_ERROR;
    }

    public RV debitPay(int value) {
        if (this.debitAccount == null) {
            return RV.NO_DEBIT_CARD_FOUND;
        }

        if ((this.getDebitBalance() - value) < 0) {
            return RV.NO_DEBIT_BALANCE;
        }

        RV returnValue = this.debitAccount.newTransaction(TransactionType.DEBIT_PAYMENT, value);
        return returnValue == RV.SUCCESS ? RV.SUCCESS : RV.DEBIT_PAYMENT_ERROR;
    }

    private RV initDebitAccount() {
        this.debitAccount = new AccountDebit();
        return RV.SUCCESS;
    }

    public RV printDebitTransactions() {
        if (this.debitAccount == null) {
            return RV.NO_DEBIT_CARD_FOUND;
        }

        this.debitAccount.printTransactions();
        return RV.SUCCESS;
    }

    public RV newCreditCard() {
        if (this.creditAccount != null) {
            return RV.CREDIT_CARD_ALREADY_EXIST;
        }

        this.initCreditAccount();
        return RV.SUCCESS;
    }

    public RV creditDeposit(int value) {
        if (this.creditAccount == null) {
            return RV.NO_CREDIT_CARD_FOUND;
        }

        RV returnValue = this.creditAccount.newTransaction(TransactionType.CREDIT_DEPOSIT, value);
        return returnValue == RV.SUCCESS ? RV.SUCCESS : RV.CREDIT_DEPOSIT_ERROR;
    }

    public RV creditPay(int value) {
        if (this.creditAccount == null) {
            return RV.NO_CREDIT_CARD_FOUND;
        }

        if ((this.getCreditBalance() - value) < 0) {
            if ((this.getCreditBalance() - value) < -this.maxCreditAllowed) {
                return RV.NO_CREDIT_BALANCE;
            }

            // apply negative credit tax
            value += negativeCreditTransationFee;
        }

        RV returnValue = this.creditAccount.newTransaction(TransactionType.CREDIT_PAYMENT, value);
        return returnValue == RV.SUCCESS ? RV.SUCCESS : RV.CREDIT_PAYMENT_ERROR;
    }

    private RV initCreditAccount() {
        this.creditAccount = new AccountCredit();
        return RV.SUCCESS;
    }

    public RV printCreditTransactions() {
        if (this.creditAccount == null) {
            return RV.NO_CREDIT_CARD_FOUND;
        }

        this.creditAccount.printTransactions();
        return RV.SUCCESS;
    }
}