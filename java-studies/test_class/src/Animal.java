public class Animal {

    String nome;
    int patas;
    boolean bigodes;

    public Animal(String nome, int patas, boolean bigodes) {
        this.nome = nome;
        this.patas = patas;
        this.bigodes = bigodes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPatas() {
        return patas;
    }

    public void setPatas(int patas) {
        this.patas = patas;
    }

    public boolean isBigodes() {
        return bigodes;
    }

    public void setBigodes(boolean bigodes) {
        this.bigodes = bigodes;
    }
}
