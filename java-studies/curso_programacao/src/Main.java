import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int y = 32;
        double x = 10.35784;

        String nome = "Maria";
        int idade = 31;
        double renda = 4000.0;
        Locale.setDefault(Locale.US);

        System.out.printf("%s tem %d anos e ganha R$ %.2f reais%n", nome, idade, renda);
    }
}
