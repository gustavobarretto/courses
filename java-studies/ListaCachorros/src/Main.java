import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<Cachorro> cachorroList = new ArrayList<>();

        Cachorro cachorro1 = new Cachorro();
        cachorro1.setNome("Rex");
        cachorro1.setIdade(3);

        Cachorro cachorro2 = new Cachorro();
        cachorro2.setNome("Lady");
        cachorro2.setIdade(1);

        cachorroList.add(cachorro1);
        cachorroList.add(cachorro2);

        FileOutputStream fo = null;

        try {
            fo = new FileOutputStream("OutputFile.txt");
            ObjectOutputStream object = new ObjectOutputStream(fo);

            object.writeObject(cachorroList);

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Arquivo não encontrado!");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        List<Cachorro> cachorroList1 = null;
        FileInputStream fi = null;

        try {
            fi = new FileInputStream("OutputFile.txt");
            ObjectInputStream object = new ObjectInputStream(fi);

            cachorroList1 = (ArrayList) object.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Arquivo não encontrado!");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        for(Cachorro cachorro : cachorroList1) {
            System.out.println(cachorro.getNome() + ": " + cachorro.getIdade());
        }

        cachorroList1.forEach( cachorro -> {
            System.out.println(cachorro.getNome() + ": " + cachorro.getIdade());
        });

        for(int i = 0; i<cachorroList1.size(); i++) {
            Cachorro cachorro = cachorroList1.get(i);
            System.out.println(cachorro.getNome() + ": " + cachorro.getIdade());
        }

    }



}
