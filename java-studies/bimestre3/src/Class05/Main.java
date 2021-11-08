package Class05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formato.parse("21/10/2021");

        Pessoa pessoa = new Pessoa("Carlos", "Alberto", "123321",
                "Pfizer", new Date());

        IRegistro registro = new RegistroVacinaProxy();
        registro.vacinar(pessoa.informacoes());

        pessoa = new Pessoa("Carlos", "Alberto", "123321",
                "Pfizer", date);
        registro.vacinar(pessoa.informacoes());


    }
}
