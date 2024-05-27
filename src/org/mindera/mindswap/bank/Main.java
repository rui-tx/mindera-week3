package org.mindera.mindswap.bank;

public class Main {
    public static void main(String[] args) {

        Client client1 = new Client("Rui");
        Bank bank1 = new Bank("CGD");
        RV returnValue;

        returnValue = client1.newBankAccount(bank1);
        if (returnValue != RV.SUCCESS) {
            returnValue.printCode();
            return;
        } else {
            System.out.println("Welcome to " + bank1.getName() + "!");
        }

        returnValue = client1.newDebitCard();
        if (returnValue != RV.SUCCESS) {
            returnValue.printCode();
            return;
        }

        returnValue = client1.newCreditCard();
        if (returnValue != RV.SUCCESS) {
            returnValue.printCode();
            return;
        }

        returnValue = client1.debitDeposit(10);
        if (returnValue != RV.SUCCESS) {
            returnValue.printCode();
            return;
        }

        returnValue = client1.creditDeposit(10);
        if (returnValue != RV.SUCCESS) {
            returnValue.printCode();
            return;
        }

        returnValue = client1.creditPay(20);
        if (returnValue != RV.SUCCESS) {
            returnValue.printCode();
            return;
        }


        client1.debugPrint();
    }


}
