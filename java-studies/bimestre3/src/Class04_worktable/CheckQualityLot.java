package Class04_worktable;

public class CheckQualityLot extends CheckQuality {
    @Override
    public void checkProductQuality(Product product) {

        if(product.getLot() > 1000 && product.getLot() < 2000) {
            System.out.println("Serial number of the lot successfully approved.");
            this.getNextQualityVerification().checkProductQuality(product);
        } else {
            System.out.println("Product's quality lot reproved.");

        }

    }
}
