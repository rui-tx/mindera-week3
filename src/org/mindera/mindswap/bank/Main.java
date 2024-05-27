package org.mindera.mindswap.bank;

public class Main {
    public static void main(String[] args) {

        //debitTest();
        creditTest();

    }

    public static void creditTest() {
        Client client1 = new Client("Rui");
        Bank bank1 = new Bank("CGD");
        int check;

        check = client1.newBankAccount(bank1);
        if (check != ReturnValue.SUCCESS) {
            ReturnValue.printCode(check);
            return;
        } else {
            System.out.println("Welcome to " + bank1.getName() + "!");
        }

        check = client1.newCreditCard();
        if (check != ReturnValue.SUCCESS) {
            ReturnValue.printCode(check);
            return;
        } else {
            System.out.println("New credit card created on " + bank1.getName() + ", in the name of 'client name'");
        }

        check = client1.creditDeposit(-50);
        if (check != ReturnValue.SUCCESS) {
            ReturnValue.printCode(check);
            return;
        } else {
            System.out.println("Credit deposit made with success!");
        }

        check = client1.creditPay(40);
        if (check != ReturnValue.SUCCESS) {
            ReturnValue.printCode(check);
            return;
        } else {
            System.out.println("Credit payment made with success!");
        }

        check = client1.creditPay(70);
        if (check != ReturnValue.SUCCESS) {
            ReturnValue.printCode(check);
            return;
        } else {
            System.out.println("Credit payment made with success!");
        }

        check = client1.creditPay(70);
        if (check != ReturnValue.SUCCESS) {
            ReturnValue.printCode(check);

        } else {
            System.out.println("Credit payment made with success!");
        }

        client1.debugPrint();
    }

    public static void debitTest() {
        Client client1 = new Client("Rui");
        Bank bank1 = new Bank("CGD");
        int check;

        check = client1.newBankAccount(bank1);
        if (check != ReturnValue.SUCCESS) {
            ReturnValue.printCode(check);
            return;
        } else {
            System.out.println("Welcome to " + bank1.getName() + "!");
        }

        check = client1.newDebitCard();
        if (check != ReturnValue.SUCCESS) {
            ReturnValue.printCode(check);
            return;
        } else {
            System.out.println("New debit card created on " + bank1.getName() + ", in the name of 'client name'");
        }

        check = client1.debitDeposit(30);
        if (check != ReturnValue.SUCCESS) {
            ReturnValue.printCode(check);
            return;
        } else {
            System.out.println("Deposit made with success!");
        }

        check = client1.widthdraw(10);
        if (check != ReturnValue.SUCCESS) {
            ReturnValue.printCode(check);
            return;
        } else {
            System.out.println("Withdraw of made with success!");
        }

        check = client1.debitPay(10);
        if (check != ReturnValue.SUCCESS) {
            ReturnValue.printCode(check);
            return;
        } else {
            System.out.println("Payment made with success!");
        }

        client1.debugPrint();
    }
}
