package Class10;

import org.apache.log4j.Logger;

public class Tigre {
    private static final Logger logger = Logger.getLogger(Tigre.class);
    private String nome;
    private int idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void correr() {
        logger.info("O tigre está correndo");
    }
}
