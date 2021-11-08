package Class06_integrator;

import java.util.ArrayList;

public class Filme {
    private String nome;
    private String pais;
    private ArrayList<Integer> IP_MOVIE = new ArrayList<>();

    public Filme(String nome, String pais, int IP_1, int IP_2, int IP_3, int IP_4) {
        this.IP_MOVIE.add(IP_1);
        this.IP_MOVIE.add(IP_2);
        this.IP_MOVIE.add(IP_3);
        this.IP_MOVIE.add(IP_4);
        this.nome = nome;
        this.pais = pais;

    }

    public String getNome() {
        return nome;
    }

    public String initMessage() {
        return "O filme " + this.getNome() + " foi encontrado e você pode assiti-lo agora! Divirta-se!";
    }

    public ArrayList<Integer> getIP_MOVIE() {
        return IP_MOVIE;
    }
}
