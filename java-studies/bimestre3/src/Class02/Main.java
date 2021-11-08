package Class02;

public class Main {
    public static void main(String[] args) {
        Funcionario funcionario = new Efetivo("Odair", "Antunes", "1234567890",
                5000, 1000, 500);

        funcionario.pagamentoSalario();

        funcionario = new Contratado("Marlene", "Peixoto", "0987654321",
                100, 80);



    }
}
