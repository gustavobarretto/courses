import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Ex 01
        /*Faça um programa para ler dois valores inteiros, e depois mostrar na tela a soma desses números com uma
        mensagem explicativa, conforme exemplos.*/
        {
            int x, y;
            Scanner sc = new Scanner(System.in);

            System.out.println("Escreva dois números inteiros: ");
            x = sc.nextInt();
            y = sc.nextInt();
            int result = x + y;
            System.out.printf("A soma dos valores %d e %d é %d%n", x, y, result);
        }
        // Ex 02
        /*Faça um programa para ler o valor do raio de um círculo, e depois mostrar o valor da área deste círculo com quatro
        casas decimais conforme exemplos.
        Fórmula da área: area = π . raio2
        Considere o valor de π = 3.14159*/
        {
            double pi, raio, area;
            pi = 3.14159;
            Scanner sc = new Scanner(System.in);
            System.out.println("Escreva o raio do círculo: ");


        }
    }

}
