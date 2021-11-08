package Class04_worktable;

public class CheckQualityPackage extends CheckQuality {
    @Override
    public void checkProductQuality(Product product) {

        if(product.getProductPackage().equals("Good conditions")) {
            System.out.println("Product's package conditions successfully approved.");
            System.out.println("\nProduct successfully registered in the system!");

        } else {
            System.out.println("Product's package conditions reproved.");

        }
    }
}
