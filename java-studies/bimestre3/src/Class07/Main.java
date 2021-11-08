package Class07;

public class Main {

    public static void main(String[] args) {
        ComputadorFactory computador = new ComputadorFactory();

        Computador mac = computador.getComputador(8, 500, 1);
        Computador janela = computador.getComputador(16, 128, 2);
        Computador mac2 = computador.getComputador(8, 500, 3);
        Computador janela2 = computador.getComputador(16, 128, 2);

        System.out.println(mac.toString());
        System.out.println(janela.toString());
        System.out.println(mac2.toString());
        System.out.println(janela2.toString());

    }

}
