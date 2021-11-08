package Class06_integrator;

public interface IGradeFilmes {
    public abstract Filme getFilme(String nomeDoFilme) throws FilmeNaoHabilitadoException;
}
