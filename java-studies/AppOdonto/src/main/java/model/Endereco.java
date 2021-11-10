package model;

public class Endereco {
    private Integer id;
    private String rua;

    public Endereco(Integer id, String rua) {
        this.id = id;
        this.rua = rua;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
}
