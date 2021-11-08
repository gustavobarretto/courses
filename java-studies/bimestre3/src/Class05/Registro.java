package Class05;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Registro implements IRegistro {
    @Override
    public void vacinar(Object[] informacoes) {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");



        System.out.println("Foi registrado " + informacoes[0] +
                " na data " + df.format(informacoes[1]) + " com a vacina " +
                informacoes[2] + " como vacinado.");
    }
}
