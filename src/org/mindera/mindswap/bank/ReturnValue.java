package org.mindera.mindswap.bank;

public class ReturnValue {

    // General return values
    public final static int SUCCESS       = 0;
    public final static int GENERIC_ERROR = -1;

    // Client return values
    public final static int BANK_ALREADY_EXIST          = 100;
    public final static int NO_BANK_EXISTS              = 101;
    public final static int INVALID_TRANSACTION_VALUE   = 102;

    //Bank return values
    public final static int NO_DEBIT_CARD_FOUND         = 200;
    public final static int DEBIT_CARD_ALREADY_EXIST    = 201;
    public final static int NO_CREDIT_CARD_FOUND        = 202;
    public final static int CREDIT_CARD_ALREADY_EXIST   = 203;
    public final static int NO_DEBIT_BALANCE            = 204;
    public final static int NO_CREDIT_BALANCE           = 205;

    //Transaction return values
    public final static int DEBIT_DEPOSIT_ERROR     = 300;
    public final static int DEBIT_WIDTHDRAW_ERROR   = 301;
    public final static int DEBIT_PAYMENT_ERROR     = 302;
    public final static int CREDIT_DEPOSIT_ERROR    = 303;
    public final static int CREDIT_PAYMENT_ERROR    = 304;


    public static void printCode(int code) {
        String message = "";
        switch (code) {

            // General
            case (ReturnValue.SUCCESS):
                message = "Operation made with success!";
                break;
            case (ReturnValue.GENERIC_ERROR):
                message = "Something went wrong...";
                break;

            // Client
            case (ReturnValue.BANK_ALREADY_EXIST):
                message = "Client already has account on this bank. Only 1 account allowed per customer.";
                break;
            case (ReturnValue.NO_BANK_EXISTS):
                message = "No banks found on this client. Please make a new account on at least 1 bank.";
                break;
            case (ReturnValue.INVALID_TRANSACTION_VALUE):
                message = "Please enter a valid number. Only numbers higher than 0 are allowed.";
                break;

            //Bank
            case (ReturnValue.NO_DEBIT_CARD_FOUND):
                message = "No debit card / account found. Before making a transaction, create a card.";
                break;
            case (ReturnValue.DEBIT_CARD_ALREADY_EXIST):
                message = "Debit card / account already exist. Only 1 card allowed per customer.";
                break;
            case (ReturnValue.NO_CREDIT_CARD_FOUND):
                message = "No credit card / account found. Before making a transaction, create a card.";
                break;
            case (ReturnValue.CREDIT_CARD_ALREADY_EXIST):
                message = "Credit card / account already exist. Only 1 card allowed per customer.";
                break;
            case (ReturnValue.NO_DEBIT_BALANCE):
                message = "No debit balance. Try deposit some money first.";
                break;
            case (ReturnValue.NO_CREDIT_BALANCE):
                message = "No credit balance. Try deposit some money first.";
                break;

            //Transaction
            case (ReturnValue.DEBIT_DEPOSIT_ERROR):
                message = "Error making the debit deposit.";
                break;
            case (ReturnValue.DEBIT_WIDTHDRAW_ERROR):
                message = "Error making the debit widthdraw.";
                break;
            case (ReturnValue.DEBIT_PAYMENT_ERROR):
                message = "Error making the debit payment.";
                break;
            case (ReturnValue.CREDIT_DEPOSIT_ERROR):
                message = "Error making the credit deposit.";
                break;
            case (ReturnValue.CREDIT_PAYMENT_ERROR):
                message = "Error making the credit payment.";
                break;
        }
        System.out.println("Error ["+ code + "]: " + message);
    }
}