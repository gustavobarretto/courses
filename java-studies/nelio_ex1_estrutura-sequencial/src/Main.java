import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
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
            raio = sc.nextDouble();
            area = pi * Math.pow(raio, 2);
            System.out.printf("A área desse é %.4f.%n", area);
        }
        // Ex 03
        /*Fazer um programa para ler quatro valores inteiros A, B, C e D. A seguir, calcule e mostre a diferença do produto
        de A e B pelo produto de C e D segundo a fórmula: DIFERENCA = (A * B - C * D).*/
        int diferenca, A, B, C, D;
        Scanner sc = new Scanner(System.in);
        System.out.println("Escreva quatro números para:");
        System.out.println("A:");
        A = sc.nextInt();
        sc.nextLine();
        System.out.println("B:");
        B = sc.nextInt();
        sc.nextLine();
        System.out.println("C:");
        C = sc.nextInt();
        sc.nextLine();
        System.out.println("D:");
        D = sc.nextInt();
        sc.nextLine();

        diferenca = (A * B) - (C * D);
        System.out.println("A diferença é: " + diferenca);
    }

    {
        // Ex 04
        /*Fazer um programa que leia o número de um funcionário, seu número de horas trabalhadas, o valor que recebe por
        hora e calcula o salário desse funcionário. A seguir, mostre o número e o salário do funcionário, com duas casas
        decimais*/
        double salario, horaTrabalhada, valorHora;
        System.out.println("Insira o valor recebido por hora de trabalho");

    }

}
