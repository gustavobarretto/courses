package Class01;

public class Main {

    public static void main(String[] args) {

        IFachadaDesconto fachada = new FachadaDesconto();

        Cartao cartao = new Cartao("1223124123", "Star Bank");
        Produto produto = new Produto("Ervilhas", "Latas");

        System.out.println("Desconto: " + fachada.desconto(cartao, produto, 13));

    }

}
