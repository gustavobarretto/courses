public class Afiliado extends Vendedor{

    public Afiliado(String nome){
        super.nome = nome;
        super.PONTOS_POR_VENDA = 15;
    }

    @Override
    public int calcularPontos() {
        return this.vendas * PONTOS_POR_VENDA;
    }
}
