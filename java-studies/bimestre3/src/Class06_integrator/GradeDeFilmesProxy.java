package Class06_integrator;

import java.util.ArrayList;

public class GradeDeFilmesProxy implements IGradeFilmes {

    private ArrayList<Integer> IP_CLIENT = new ArrayList<>();
    private GradeDeFilmes MOVIES;


    public GradeDeFilmesProxy(int IP_1, int IP_2, int IP_3, int IP_4, GradeDeFilmes MOVIES) {
        this.IP_CLIENT.add(IP_1);
        this.IP_CLIENT.add(IP_2);
        this.IP_CLIENT.add(IP_3);
        this.IP_CLIENT.add(IP_4);
        this.MOVIES = MOVIES;
    }

    @Override
    public Filme getFilme(String nomeDoFilme) throws FilmeNaoHabilitadoException {
        Filme filme = MOVIES.getFilme(nomeDoFilme);

        String localizacaoFilme = verificationIP(filme.getIP_MOVIE().get(0));
        String localizacaoCliente = verificationIP(this.IP_CLIENT.get(0));

        if(localizacaoCliente.equals(localizacaoFilme)) {
            return filme;
        } else {
            throw new FilmeNaoHabilitadoException("Seu país de origem não permite assistir este filme!");
        }
    }

    public String verificationIP(int ip) {
        if(ip < 50) {
            return "Argentina";
        } else if (ip < 100) {
            return "Brasil";
        } else if (ip < 150) {
            return "Colombia";
        } else {
            return "Região não autorizada";
        }
    }

    public ArrayList<Integer> getIP_CLIENT() {
        return IP_CLIENT;
    }

    public GradeDeFilmes getMOVIES() {
        return MOVIES;
    }
}
