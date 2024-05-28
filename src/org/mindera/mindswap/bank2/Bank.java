package org.mindera.mindswap.bank2;

public class Bank {

    private String name;
    private AccountDebit debitAccount;
    private AccountCredit creditAccount;
    private int maxCreditAllowed = 100;
    private int negativeCreditTransationFee = 2;

    private ClientAccount[] clientAccounts = new ClientAccount[100];
    private int lastClientAccountNumber = -1;


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
            return ReturnValue.NO_DEBIT_CARD_FOUND.getCode();
        }

        return this.debitAccount.getDebitBalance();
    }

    // WARNING! conflict with return values and balance! CHANGE THIS!
    public int getCreditBalance() {
        if (this.creditAccount == null) {
            return ReturnValue.NO_CREDIT_CARD_FOUND.getCode();
        }

        return this.creditAccount.getCreditBalance();
    }

    //sets


    // functions

    public int createAccount(int nif) {

        this.clientAccounts[++lastClientAccountNumber] = new ClientAccount(nif, lastClientAccountNumber);
        return this.lastClientAccountNumber;
    }

    public Card createCard(int accountNumber, CardTypeE type) {

        // needs checks

        if (type.equals(CardTypeE.DEBIT)) {
            return new Card(accountNumber, CardTypeE.DEBIT);
        }

        return new Card(accountNumber, CardTypeE.CREDIT);
    }



    public void deposit(Card clientCard, int amount) {

        //this.clientAccounts[clientCard.getAccountNumber()]


        System.out.println(this.clientAccounts[clientCard.getAccountNumber()]);
    }











    public ReturnValue newDebitCard() {
        if (this.debitAccount != null) {
            return ReturnValue.DEBIT_CARD_ALREADY_EXIST;
        }

        ReturnValue returnValue = this.initDebitAccount();
        return returnValue == ReturnValue.SUCCESS ? ReturnValue.SUCCESS : ReturnValue.GENERIC_ERROR;
    }

    public ReturnValue debitDeposit(int value) {
        if (this.debitAccount == null) {
            return ReturnValue.NO_DEBIT_CARD_FOUND;
        }

        ReturnValue returnValue = this.debitAccount.newTransaction(TransactionType.DEBIT_DEPOSIT, value);
        return returnValue == ReturnValue.SUCCESS ? ReturnValue.SUCCESS : ReturnValue.DEBIT_DEPOSIT_ERROR;
    }

    public ReturnValue withdraw(int value) {
        if (this.debitAccount == null) {
            return ReturnValue.NO_DEBIT_CARD_FOUND;
        }

        if ((this.getDebitBalance() - value) < 0) {
            return ReturnValue.NO_DEBIT_BALANCE;
        }

        ReturnValue returnValue = this.debitAccount.newTransaction(TransactionType.DEBIT_WITHDRAW, value);
        return returnValue == ReturnValue.SUCCESS ? ReturnValue.SUCCESS : ReturnValue.DEBIT_WITHDRAW_ERROR;
    }

    public ReturnValue debitPay(int value) {
        if (this.debitAccount == null) {
            return ReturnValue.NO_DEBIT_CARD_FOUND;
        }

        if ((this.getDebitBalance() - value) < 0) {
            return ReturnValue.NO_DEBIT_BALANCE;
        }

        ReturnValue returnValue = this.debitAccount.newTransaction(TransactionType.DEBIT_PAYMENT, value);
        return returnValue == ReturnValue.SUCCESS ? ReturnValue.SUCCESS : ReturnValue.DEBIT_PAYMENT_ERROR;
    }

    private ReturnValue initDebitAccount() {
        this.debitAccount = new AccountDebit();
        return ReturnValue.SUCCESS;
    }

    public ReturnValue printDebitTransactions() {
        if (this.debitAccount == null) {
            return ReturnValue.NO_DEBIT_CARD_FOUND;
        }

        this.debitAccount.printTransactions();
        return ReturnValue.SUCCESS;
    }

    public ReturnValue newCreditCard() {
        if (this.creditAccount != null) {
            return ReturnValue.CREDIT_CARD_ALREADY_EXIST;
        }

        this.initCreditAccount();
        return ReturnValue.SUCCESS;
    }

    public ReturnValue creditDeposit(int value) {
        if (this.creditAccount == null) {
            return ReturnValue.NO_CREDIT_CARD_FOUND;
        }

        ReturnValue returnValue = this.creditAccount.newTransaction(TransactionType.CREDIT_DEPOSIT, value);
        return returnValue == ReturnValue.SUCCESS ? ReturnValue.SUCCESS : ReturnValue.CREDIT_DEPOSIT_ERROR;
    }

    public ReturnValue creditPay(int value) {
        if (this.creditAccount == null) {
            return ReturnValue.NO_CREDIT_CARD_FOUND;
        }

        if ((this.getCreditBalance() - value) < 0) {
            if ((this.getCreditBalance() - value) < -this.maxCreditAllowed) {
                return ReturnValue.NO_CREDIT_BALANCE;
            }

            // apply negative credit tax
            value += negativeCreditTransationFee;
        }

        ReturnValue returnValue = this.creditAccount.newTransaction(TransactionType.CREDIT_PAYMENT, value);
        return returnValue == ReturnValue.SUCCESS ? ReturnValue.SUCCESS : ReturnValue.CREDIT_PAYMENT_ERROR;
    }

    private ReturnValue initCreditAccount() {
        this.creditAccount = new AccountCredit();
        return ReturnValue.SUCCESS;
    }

    public ReturnValue printCreditTransactions() {
        if (this.creditAccount == null) {
            return ReturnValue.NO_CREDIT_CARD_FOUND;
        }

        this.creditAccount.printTransactions();
        return ReturnValue.SUCCESS;
    }
}