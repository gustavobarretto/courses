public class Gato extends Felino {


    public Gato(String nome, int patas, boolean bigodes, String olhos) {
        super(nome, patas, bigodes, olhos);
    }

    @Override
    public void Ronronar() {
        System.out.println("Miau!");
    }
}
