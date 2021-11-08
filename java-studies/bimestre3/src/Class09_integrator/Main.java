package Class09_integrator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /*
    Suponha que temos uma produção de roupas e temos que exibir diferentes listas de roupas:
        ● Lista Tamanho XS;
        ● Lista Tamanho S;
        ● Lista Tamanho M;
        ● Lista Roupas Importadas;
        ● Lista Roupas em Más Condições.
    Em grupo, utilizando o padrão flyweight, devemos fazer um projeto para gerar o cliente
    roupa, com os seguintes atributos:
        ● Tamanho: é uma string.
        ● Tipo: é uma string que descreve o tipo de vestuário. Exemplo: calça.
        ● eNovo: flag (bandeira) para saber se é uma vestimenta nova ou não.
        ● importada: flag (bandeira) para saber se é uma vestimenta nacional ou internacional.
    Em seguida, devemos gerar dois testes: um para verificar se a fábrica retorna o item que
    precisamos e outro, que mede o tamanho da fábrica e mostra que é menor que o número de
    pedidos. Por exemplo, se encomendarmos cinco calças e duas camisas, o tamanho da fábrica
    deve ser dois.
     */

    public static void main(String[] args) {

        ClothingFactory factory = new ClothingFactory();

        Clothing clothing1 = factory.getClothing("XS", "pants", true, true);
        System.out.println(clothing1.getClass());
        System.out.println("Teste".getClass());
        }
}
