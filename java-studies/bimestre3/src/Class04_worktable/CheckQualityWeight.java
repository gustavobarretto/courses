package Class04_worktable;

public class CheckQualityWeight extends CheckQuality {
    @Override
    public void checkProductQuality(Product product) {

        if(product.getWeight() > 1200 && product.getWeight() < 1300) {
            System.out.println("Weight's product successfully approved.");
            this.getNextQualityVerification().checkProductQuality(product);
        } else {
            System.out.println("Weight's product reproved.");

        }

    }
}
