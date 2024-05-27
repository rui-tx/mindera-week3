package org.mindera.mindswap.bank;

public enum RV {

    //General return values
    SUCCESS(0, "Operation made with success!"),
    GENERIC_ERROR(-1, "Something went wrong..."),

    // Client return values
    BANK_ALREADY_EXIST(100, "Client already has account on this bank. Only 1 account allowed per customer."),
    NO_BANK_EXISTS(101, "No banks found on this client. Please make a new account on at least 1 bank."),
    INVALID_TRANSACTION_VALUE(102, "Please enter a valid number. Only numbers higher than 0 are allowed."),

    // Bank return values
    NO_DEBIT_CARD_FOUND(200, "No debit card / account found. Before making a transaction, create a card."),
    DEBIT_CARD_ALREADY_EXIST(201, "Debit card / account already exist. Only 1 card allowed per customer."),
    NO_CREDIT_CARD_FOUND(202, "No credit card / account found. Before making a transaction, create a card."),
    CREDIT_CARD_ALREADY_EXIST(203, "Credit card / account already exist. Only 1 card allowed per customer."),
    NO_DEBIT_BALANCE(204, "No debit balance. Try deposit some money first."),
    NO_CREDIT_BALANCE(205, "No credit balance. Try deposit some money first."),

    // Transaction return values
    DEBIT_DEPOSIT_ERROR(300, "Error making the debit deposit."),
    DEBIT_WITHDRAW_ERROR(301, "Error making the debit withdraw."),
    DEBIT_PAYMENT_ERROR(302, "Error making the debit payment."),
    CREDIT_DEPOSIT_ERROR(303, "Error making the credit deposit."),
    CREDIT_PAYMENT_ERROR(304, "Error making the credit payment.");


    private final int code;
    private final String message;

    // constructors
    RV(int code, String message) {
        this.code = code;
        this.message = message;
    }

    // gets
    public int getCode() {
        return this.code;
    }

    public String getCodeMessage() {
        return this.message;
    }

    public String getError() {
        return "Error [" + this.code + "]: " + this.message;
    }

    public void printCode() {
        System.out.println("Error [" + this.code + "]: " + this.message);
    }

}
