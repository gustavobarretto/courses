package Class06_integrator;

import java.util.ArrayList;

public class GradeDeFilmes implements IGradeFilmes{

    private ArrayList<Filme> MOVIES;

    public GradeDeFilmes() {
        this.MOVIES = new ArrayList<>();
    }

    public void addFilme(Filme filme) {
        this.MOVIES.add(filme);
    }

    @Override
    public Filme getFilme(String nomeDoFilme) throws FilmeNaoHabilitadoException {
        return MOVIES.stream().filter( obj -> obj.getNome()
                .equals(nomeDoFilme)).findFirst().orElse(null);

    }
}
