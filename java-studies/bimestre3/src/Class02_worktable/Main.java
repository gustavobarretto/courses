package Class02_worktable;

public class Main {
    public static void main(String[] args) {
        Menu produto1 = new AdultMenu(10);
        Menu produto2 = new VeggieMenu(10);
        Menu produto3 = new KidsMenu(10);

        produto1.receiptPressed();
        produto2.receiptPressed();
        produto3.receiptPressed();


    }
}
