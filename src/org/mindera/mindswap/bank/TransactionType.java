package org.mindera.mindswap.bank;

public enum TransactionType {

    DEBIT_DEPOSIT(100),
    DEBIT_WITHDRAW(101),
    DEBIT_PAYMENT(102),
    CREDIT_DEPOSIT(200),
    CREDIT_PAYMENT(202);

    private final int code;

    TransactionType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
