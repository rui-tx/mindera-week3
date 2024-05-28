package org.mindera.mindswap.bank2;

public class ClientAccount {

    private int nif;
    private int accountNumber;


    public ClientAccount(int nif, int accountNumber) {
        this.nif = nif;
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "Client nif: " + nif + " account number: " + accountNumber;
    }
}
