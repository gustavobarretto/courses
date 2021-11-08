package Class10;


import org.apache.log4j.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Leao leao = new Leao();
        leao.setIdade(4);
        leao.setNome("Simba");
        leao.seteAlfa(true);
        leao.correr();

        try {
            leao.eMaior10EAlfa();
        }   catch (Exception e){
            logger.error("A idade do leão " + leao.getNome() + " está incorreta", e);
        }

        Leao leao2 = new Leao();
        leao2.setIdade(-1);
        leao2.setNome("Mufasa");
        leao2.seteAlfa(false);
        leao2.correr();

        try {
            leao2.eMaior10EAlfa();
        }   catch (Exception e){
            logger.error("A idade do leão " + leao2.getNome() + " está incorreta", e);
        }

        Tigre tigre = new Tigre();
        tigre.setNome("Tito");
        tigre.setIdade(8);
        tigre.correr();

    }


}
