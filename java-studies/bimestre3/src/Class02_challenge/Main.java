package Class02_challenge;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {

        Card credit1 = new Credit("123", "321", "12/21");

        credit1.paymentProcessing(500);

        credit1.paymentProcessing(500);

        credit1.paymentProcessing(500);

        credit1.paymentProcessing(500);

        credit1 = new Debit("123", "321", "12/21", 1000);

        credit1.paymentProcessing(500);

        credit1.paymentProcessing(500);

        credit1.paymentProcessing(500);

        credit1.paymentProcessing(500);


    }
}
