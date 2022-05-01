public class Felino {

    String nome;
    int patas = 4;
    boolean bigodes = true;
    String olhos;

    public Felino(String nome, int patas, boolean bigodes, String olhos) {
        this.nome = nome;
        this.patas = patas;
        this.bigodes = bigodes;
        this.olhos = olhos;
    }

    public void Ronronar () {
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

    public String getOlhos() {
        return olhos;
    }

    public void setOlhos(String olhos) {
        this.olhos = olhos;
    }
}
