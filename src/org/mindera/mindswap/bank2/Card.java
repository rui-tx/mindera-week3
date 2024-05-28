package org.mindera.mindswap.bank2;

public class Card {
    private int accountNumber;
    private CardTypeE type;

    public Card(int accountNumber, CardTypeE type ) {
        this.accountNumber = accountNumber;
        this.type = type;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public CardTypeE getType () {
        return this.type;
    }
}
