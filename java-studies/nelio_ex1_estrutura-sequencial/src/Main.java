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
            double pi, radius, area;
            pi = 3.14159;
            Scanner sc = new Scanner(System.in);
            System.out.println("Escreva o raio do círculo: ");
            radius = sc.nextDouble();
            area = pi * Math.pow(radius, 2);
            System.out.printf("A área desse é %.4f.%n", area);
        }
        {
            // Ex 03
        /*Fazer um programa para ler quatro valores inteiros A, B, C e D. A seguir, calcule e mostre a diferença do produto
        de A e B pelo produto de C e D segundo a fórmula: DIFERENCA = (A * B - C * D).*/
            int difference, A, B, C, D;
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

            difference = (A * B) - (C * D);
            System.out.println("A diferença é: " + difference);
        }
        {
            // Ex 04
            /*Fazer um programa que leia o número de um funcionário, seu número de horas trabalhadas, o valor que recebe por
            hora e calcula o salário desse funcionário. A seguir, mostre o número e o salário do funcionário, com duas casas
            decimais*/
            double salary, workHour, valueHour;
            int number;
            Scanner sc = new Scanner(System.in);
            System.out.println("Insira o número do funcionário: ");
            number = sc.nextInt();
            sc.nextLine();
            System.out.println("Insira o valor recebido por hora de trabalho:");
            valueHour = sc.nextDouble();
            sc.nextLine();
            System.out.println("Insira o horário trabalhado");
            workHour = sc.nextDouble();
            sc.nextLine();
            salary = valueHour * workHour;
            System.out.println("NUMBER = " + number);
            System.out.printf("SALARY = U$ %.2f%n", salary);
        }
        {
            //Ex 05
            /*Fazer um programa para ler o código de uma peça 1, o número de peças 1, o valor unitário de cada peça 1, o
            código de uma peça 2, o número de peças 2 e o valor unitário de cada peça 2. Calcule e mostre o valor a ser pago.*/
            int firstPiece, sndPiece, firstPieceQnt, sndPieceQnt;
            double fstPieceValue, sndPieceValue;
            Scanner sc = new Scanner(System.in);
            System.out.println("Diga o código da primeira peça: ");
            firstPiece = sc.nextInt();
            sc.nextLine();
            System.out.println("Diga a quantidade da primeira peça: ");
            firstPieceQnt = sc.nextInt();
            sc.nextLine();
            System.out.println("Diga o valor da primeira peça: ");
            fstPieceValue = sc.nextDouble();
            sc.nextLine();

            System.out.println("Diga o código da segunda peça: ");
            sndPiece = sc.nextInt();
            sc.nextLine();
            System.out.println("Diga a quantidade da segunda peça: ");
            sndPieceQnt = sc.nextInt();
            sc.nextLine();
            System.out.println("Diga o valor da segunda peça: ");
            sndPieceValue = sc.nextDouble();
            sc.nextLine();

            System.out.printf("VALOR A PAGAR: R$ %.2f", ((firstPieceQnt * fstPieceValue) + (sndPieceQnt * sndPieceValue)));

        }
    }



}
