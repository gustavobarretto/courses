package Class02_worktable;

public class VeggieMenu extends Menu {

    public VeggieMenu(double basicPrice) {
        super(basicPrice);
    }

    @Override
    public void mounting() {
        System.out.printf("Trata-se de um menu veggie! Coloque os condimentos e envolva o produto na embalagem veggie.\n" +
                           "O valor total é de: R$%.2f\n", priceCalculator());

    }

    @Override
    public double priceCalculator() {
        return (this.getBasicPrice() + 5) * 1.01;
    }
}
