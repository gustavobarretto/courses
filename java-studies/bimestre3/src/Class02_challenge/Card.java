package Class02_challenge;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public abstract class Card {

    private String frontNumbers;
    private String securityCode;
    private Date validateDate;
    private Date actualDate;

    public Card(String frontNumbers, String securityCode, String date) throws ParseException {
        SimpleDateFormat stringDateFormat = new SimpleDateFormat("MM/yy");
        this.frontNumbers = frontNumbers;
        this.securityCode = securityCode;
        this.validateDate = stringDateFormat.parse(date);
        this.actualDate = stringDateFormat.parse("10/21");

    }

    public abstract boolean autorization(double value);

    public void paymentProcessing(double value) {
        if(autorization(value) && dateComparse()) {
            calculatePayment(value);
            System.out.println("Pagamento realizado com sucesso.");
        } else {
            System.out.println("Valor acima do permitido!");
        }
    }

    public boolean dateComparse() {
        return validateDate.compareTo(actualDate) >= 0;
    }

    public abstract double calculatePayment(double value);



}
