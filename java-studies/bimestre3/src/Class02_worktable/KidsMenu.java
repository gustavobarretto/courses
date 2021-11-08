package Class02_worktable;

public class KidsMenu extends Menu {

    public KidsMenu(double basicPrice) {
        super(basicPrice);
    }

    @Override
    public void mounting() {
        System.out.printf("Trata-se de um menu infantil! Coloque o brinquedo e o valor total é de: R$%.2f\n", priceCalculator());

    }

    @Override
    public double priceCalculator() {
        return this.getBasicPrice() + 10.99;
    }
}
