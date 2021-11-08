package model;

public class Medicamento {
    private Integer id;
    private Integer codigoNumerico;
    private String nome;
    private String laboratorio;
    private Integer quantidade;
    private double preco;

    public Medicamento(Integer codigoNumerico, String nome, String laboratorio, Integer quantidade, double preco) {
        this.codigoNumerico = codigoNumerico;
        this.nome = nome;
        this.laboratorio = laboratorio;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Medicamento(Integer id, Integer codigoNumerico, String nome, String laboratorio, Integer quantidade, double preco) {
        this.id = id;
        this.codigoNumerico = codigoNumerico;
        this.nome = nome;
        this.laboratorio = laboratorio;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigoNumerico() {
        return codigoNumerico;
    }

    public void setCodigoNumerico(Integer codigoNumerico) {
        this.codigoNumerico = codigoNumerico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Medicamento{" +
                "id=" + id +
                ", codigoNumerico=" + codigoNumerico +
                ", nome='" + nome + '\'' +
                ", laboratorio='" + laboratorio + '\'' +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                '}';
    }
}
