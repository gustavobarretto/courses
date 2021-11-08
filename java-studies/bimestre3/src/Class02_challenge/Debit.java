package Class02_challenge;

import java.text.ParseException;

public class Debit extends Card {

    private double balance;

    public Debit(String frontNumbers, String securityCode, String date, int deposit) throws ParseException {
        super(frontNumbers, securityCode, date);
        this.balance = deposit;
    }

    @Override
    public boolean autorization(double value) {
        return value <= this.balance;
    }


    @Override
    public boolean dateComparse() {
        return super.dateComparse();
    }

    @Override
    public double calculatePayment(double value) {
        return this.balance -= value;
    }
}
