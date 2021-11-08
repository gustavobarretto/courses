package Class02_worktable;

public abstract class Menu {

    private double basicPrice;

    public Menu(double basicPrice) {
        this.basicPrice = basicPrice;
    }

    public abstract void mounting();

    public abstract double priceCalculator();

    public void receiptPressed() {
        mounting();
    };

    public double getBasicPrice() {
        return basicPrice;
    }
}
