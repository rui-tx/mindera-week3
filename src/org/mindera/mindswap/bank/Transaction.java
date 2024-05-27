package org.mindera.mindswap.bank;

public class Transaction {

    private TransactionType type;
    private int value;
    private String description;

    // contructors

    public Transaction(TransactionType type, int value, String description) {
        this.type = type;
        this.value = value;
        this.description = description;
    }

    // gets
    public TransactionType getType() {
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
