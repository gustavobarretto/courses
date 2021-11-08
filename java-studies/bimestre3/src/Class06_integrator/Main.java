package Class06_integrator;

public class Main {

        /*
        Estamos desenvolvendo um aplicativo de streaming,
        estilo Netflix, com o objetivo de ser utilizado por
        usuários de t.o.d.o o mundo. No momento, estamos recebendo
        filmes apenas para Argentina, Brasil e Colômbia. Nesse caso,
        precisamos desenvolver uma funcionalidade específica:
        Como cliente, queremos que o aplicativo nos permita
        fazer um pedido com o nome do filme e nos envie o objeto
        filme que contém o link de reprodução.

        1o MÉTODO QUE RECEBE STRING E DEVOLVE OBJETO FILME ok

        Os diferentes filmes estão disponíveis em apenas
        um dos países e permitem-nos vê-los
        se estivermos no país correspondente.

        2o VERIFICAÇÃO IP_FILME COM IP_CLIENTE CORRESPONDENTE - MÉTODO DO PROXY ok

        Para saber em que país se encontra o cliente, ocorreu-nos
        utilizar o endereço IP do pedido que nos enviou. Como os
        endereços IP têm um formato definido por 4 números (de 0 a 255)
        separados por pontos, ficando como: 255.255.255.255, podemos
        pegar o primeiro número do endereço para descobrir de qual país ele vem:
        0 a 49 -> Argentina
        50 a 99 -> Brasil
        100 a 149 -> Colombia

        3o LISTA EM QUE SE PEGA O PRIMEIRO ELEMENTO PARA VERIFICAÇÃO NO PROXY ok

        Vamos criar:
        Uma Interface IGradeDeFilmes que define um método getFilme
        que recebe o nome, devolvendo um objeto filme.

        4o INTERFACE DE ACESSO AO USUÁRIO COM NOME DO FILME.

        Uma classe GradeDeFilmes que implementa a
        interface IGradeDeFilmes e devolve um filme.

        5o A CLASSE GradeDeFilmes TEM LISTA DE FILMES E DEVOLVE APENAS O FILME.

        Uma classe GradeDeFilmesProxy que possui um atributo
        IP e pede um filme à GradeDeFilmes - com getFilme e
        "filtra" de acordo com o país.

        6o O PROXY DETÉM DO IP_CLIENTE E PEGAR O FILME APÓS FILTRAGEM

        Recordar como se encontra o país pelo IP -, se não for
        possível enviar para aquele
        país, lança uma exceção do tipo FilmeNaoHabilitadoException
        criado para esse fim. As classes utilizarão:

        7o ISSO ME FODE E FICA PRO FINAL.

        Filme que possui um nome, um país e um link de reprodução —todos String—.
        IP que possui quatro inteiros (números de 0 a 255).
        No método principal (main), realizar pedidos de filmes com
        o nome e o IP fazendo com exemplos dos 3 países. Mostrar o
        link do filme se estiver habilitado. Se não, exiba “Filme
        não disponível no seu país”.
        */
    public static void main(String[] args) {

        GradeDeFilmes catalogo = new GradeDeFilmes();

        catalogo.addFilme(new Filme("Avengers","Argentina", 25, 167, 192, 255));
        catalogo.addFilme(new Filme("3%","Brasil", 77, 167, 192, 255));
        catalogo.addFilme(new Filme("Contratiempo","Colombia", 121, 167, 192, 255));

        IGradeFilmes filtro = new GradeDeFilmesProxy(47, 89, 167, 192, catalogo);

        try {
            System.out.println(filtro.getFilme("Avengers").initMessage());
        } catch (FilmeNaoHabilitadoException exception) {
            System.err.println(exception.getMessage());
        }

        try {
            System.out.println(filtro.getFilme("Contratiempo").initMessage());
        } catch (FilmeNaoHabilitadoException exception) {
            System.err.println(exception.getMessage());
        }

        filtro = new GradeDeFilmesProxy(125, 168, 192, 255, catalogo);

        try {
            System.out.println(filtro.getFilme("Contratiempo").initMessage());
        } catch (FilmeNaoHabilitadoException exception) {
            System.err.println(exception.getMessage());
        }

//      Teste com Séries

        ISerie filtroSeries = new SerieProxy(new Serie());

        try {
            System.out.println(filtroSeries.getSerie("Mindhunter"));
        } catch (SerieNaoHabilitadaException exception) {
            System.err.println(exception.getMessage());
        }

        try {
            System.out.println(filtroSeries.getSerie("Vikings"));
        } catch (SerieNaoHabilitadaException exception) {
            System.err.println(exception.getMessage());
        }

        try {
            System.out.println(filtroSeries.getSerie("Billions"));
        } catch (SerieNaoHabilitadaException exception) {
            System.err.println(exception.getMessage());
        }

        try {
            System.out.println(filtroSeries.getSerie("Maid"));
        } catch (SerieNaoHabilitadaException exception) {
            System.err.println(exception.getMessage());
        }

        try {
            System.out.println(filtroSeries.getSerie("Suits"));
        } catch (SerieNaoHabilitadaException exception) {
            System.err.println(exception.getMessage());
        }

        try {
            System.out.println(filtroSeries.getSerie("Lucifer"));
        } catch (SerieNaoHabilitadaException exception) {
            System.err.println(exception.getMessage());
        }
    }
}
