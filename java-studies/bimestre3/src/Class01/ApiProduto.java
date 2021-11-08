package Class01;

public class ApiProduto {
    public int desconto(Produto produto) {
        if (produto.getTipo().compareTo("Latas") == 0) {
            return 10;
        }
        return 0;
    }
}
