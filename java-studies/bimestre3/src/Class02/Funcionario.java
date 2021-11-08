package Class02;

public abstract class Funcionario {
    private String nome;
    private String sobrenome;
    private String numeroConta;

    public Funcionario(String nome, String sobrenome, String numeroConta) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numeroConta = numeroConta;
    }

    public void pagamentoSalario() {
        double quantia;
        quantia = calcularPagamento();
        imprimirRecibo(quantia);
        depoistar(quantia);

    }

    public abstract double calcularPagamento();
    public abstract void imprimirRecibo(double quantia);
    public void depoistar(double quantia) {
        System.out.println("Foi gerado um recibo impresso na quantia de: " + quantia + " na conta " + numeroConta);
    };

}
