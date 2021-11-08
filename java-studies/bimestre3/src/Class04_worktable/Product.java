package Class04_worktable;

public class Product {
    private String productName;
    private int lot;
    private int weight;
    private String productPackage;

    public Product(String productName, int lot, int weight, String productPackage) {
        this.productName = productName;
        this.lot = lot;
        this.weight = weight;
        this.productPackage = productPackage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getLot() {
        return lot;
    }

    public void setLot(int lot) {
        this.lot = lot;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getProductPackage() {
        return productPackage;
    }

    public void setProductPackage(String productPackage) {
        this.productPackage = productPackage;
    }
}
