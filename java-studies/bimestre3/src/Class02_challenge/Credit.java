package Class02_challenge;

import java.text.ParseException;

public class Credit extends Card {

    private double creditLimit;
    private double balance;

    public Credit(String frontNumbers, String securityCode, String date) throws ParseException {
        super(frontNumbers, securityCode, date);
        this.creditLimit = 1000;
        this.balance = 0;

    }

    @Override
    public boolean autorization(double value) {
        return value + this.balance <= creditLimit;
    }


    @Override
    public boolean dateComparse() {
        return super.dateComparse();
    }

    @Override
    public double calculatePayment(double value) {
        return this.balance += value;
    }
}
