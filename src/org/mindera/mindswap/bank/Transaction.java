package org.mindera.mindswap.bank;

public class Transaction {

    public static class TransactionType {

        // debit
        public final static int DEBIT_DEPOSIT   = 100;
        public final static int DEBIT_WITHDRAW  = 101;
        public final static int DEBIT_PAYMENT   = 102;

        // credit
        public final static int CREDIT_DEPOSIT  = 200;
        public final static int CREDIT_PAYMENT  = 202;
    }

    private int type;
    private int value;
    private String description;

    // contructors

    public Transaction(int type, int value, String description) {
        this.type = type;
        this.value = value;
        this.description = description;
    }

    // gets
    public int getType() {
        return type;
    }

    public int getValue() {
        return value;
    }


    // sets

    // functions

    public void printTransaction() {
        System.out.println("Transaction type: " + this.type + " Value: " + this.value + " description: " + this.description);
    }
}
