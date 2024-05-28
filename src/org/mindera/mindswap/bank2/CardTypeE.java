package org.mindera.mindswap.bank2;

public enum CardTypeE {
    DEBIT (0, "Debit"),
    CREDIT (1, "Credit");

    private final int id;
    private final String prettyName;

    CardTypeE(int id, String prettyName) {
        this.id = id;
        this.prettyName = prettyName;
    }

    public int getId() {
        return id;
    }

    public String getPrettyName() {
        return prettyName;
    }


}
