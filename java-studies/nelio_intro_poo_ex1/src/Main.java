import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Rectangle rectangle = new Rectangle();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rectangle width and height: ");
        rectangle.width = sc.nextDouble();
        rectangle.height = sc.nextDouble();

        System.out.println("AREA = " + rectangle.getArea());
        System.out.println("PERIMETER = " + rectangle.getPerimeter());
        System.out.println("DIAGONAL = " + rectangle.getDiagonal());

    }
}
