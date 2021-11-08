package Class01;

public class FachadaDesconto implements IFachadaDesconto {

    private ApiCartao apiCartao;
    private ApiProduto apiProduto;
    private ApiQuantidade apiQuantidade;

    public FachadaDesconto() {
        this.apiCartao = new ApiCartao();
        this.apiProduto = new ApiProduto();
        this.apiQuantidade = new ApiQuantidade();
    }

    public int desconto(Cartao cartao, Produto produto, int quantidade) {
        return     apiQuantidade.desconto(quantidade)
                 + apiCartao.desconto(cartao)
                 + apiProduto.desconto(produto);

    }


}
