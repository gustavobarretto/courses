package Class02_worktable;

public class AdultMenu extends Menu {

    public AdultMenu(double basicPrice) {
        super(basicPrice);
    }

    @Override
    public void mounting() {
        System.out.printf("Trata-se de um menu adulto! O valor total é de: R$%.2f\n", priceCalculator());
    }

    @Override
    public double priceCalculator() {
        return getBasicPrice();
    }
}
