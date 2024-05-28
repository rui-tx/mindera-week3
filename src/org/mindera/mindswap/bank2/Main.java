package org.mindera.mindswap.bank2;

public class Main {
    public static void main(String[] args) {

        Client client1 = new Client("Rui", 123456789);
        Bank bank1 = new Bank("CGD");

        int accountNumber = bank1.createAccount(client1.getNif());
        client1.newBankAccount(accountNumber);

        Card debitCard = bank1.createCard(client1.getAccountNumber(), CardTypeE.DEBIT);

        client1.addCard(debitCard);

        bank1.deposit(client1.getDebitCard(), 1000);


    }


}
