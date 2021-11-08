package Class13;

public class Medicamento {
    private int id;
    private int codigoNumerico;
    private String nome;
    private String laboratorio;
    private int quantidade;
    private double preco;

    public Medicamento(int codigoNumerico, String nome, String laboratorio, int quantidade, double preco) {
        this.codigoNumerico = codigoNumerico;
        this.nome = nome;
        this.laboratorio = laboratorio;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Medicamento(int id, int codigoNumerico, String nome, String laboratorio, int quantidade, double preco) {
        this.id = id;
        this.codigoNumerico = codigoNumerico;
        this.nome = nome;
        this.laboratorio = laboratorio;
        this.quantidade = quantidade;
        this.preco = preco;
    }




}
