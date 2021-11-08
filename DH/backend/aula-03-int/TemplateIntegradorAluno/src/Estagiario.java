public class Estagiario extends Vendedor {

    public Estagiario(String nome){
        super.nome = nome;
        super.PONTOS_POR_VENDA = 5;
    }

    @Override
    public String mostrarCategoria() {
        int pontosCategoriaEstagiario = calcularPontos();
        if(pontosCategoriaEstagiario < 50) return "Estagiário: " + this.getNome() + "\nTotal de Pontos: " + pontosCategoriaEstagiario  + "\nCategoria: Novato\n";
        else return "Estagiário: " + this.getNome() + "\nTotal de Pontos: " + pontosCategoriaEstagiario  + "\nCategoria: Experiente\n";
    }

    @Override
    public void vender(int qtdVendas) {
        super.vender(qtdVendas);
    }

    @Override
    public int calcularPontos() {
        return this.vendas * this.PONTOS_POR_VENDA;
    }
}
