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

        Employee employee = new Employee();
        System.out.println("Enter the name, gross salary and tax of the employee:");
        employee.name = sc.next();
        sc.nextLine();
        employee.grossSalary = sc.nextDouble();
        employee.tax = sc.nextDouble();

        System.out.printf("Employee: %s, $ %.2f%n", employee.name, employee.netSalary());

        System.out.print("Which percentage to increase salary?: ");
        employee.getIncrease(sc.nextDouble());

        System.out.printf("Updated data: %s, $ %.2f%n", employee.name, employee.netSalary());

    }
}
