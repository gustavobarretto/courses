package Class04_worktable;

public class CheckingProduct {

    private CheckQuality firstCheck;

    public CheckingProduct() {
        this.firstCheck = new CheckQualityLot();
        CheckQuality aprovedLot = new CheckQualityWeight();
        CheckQuality aprovedLotAndWeight = new CheckQualityPackage();

        firstCheck.setNextQualityVerification(aprovedLot);
        aprovedLot.setNextQualityVerification(aprovedLotAndWeight);
    }

    public void checkProductQuality(Product product) {
        System.out.println("\nChecking the quality of the " + product.getProductName() + " for registration in the system...");
        this.firstCheck.checkProductQuality(product);
    }
}
