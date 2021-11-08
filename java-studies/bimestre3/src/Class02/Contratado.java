package Class02;

public class Contratado extends Funcionario {
    public double valorHora;
    private int horas;

    public Contratado(String nome, String sobrenome, String numeroConta, double valorHora, int horas) {
        super(nome, sobrenome, numeroConta);
        this.valorHora = valorHora;
        this.horas = horas;
    }

    @Override
    public double calcularPagamento() { return valorHora * horas;}

    @Override
    public void imprimirRecibo(double quantia) {
        System.out.println("foi gerado um recibo impresso na quantia de: " + quantia);

    }
}
