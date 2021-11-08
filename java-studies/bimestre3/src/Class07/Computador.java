package Class07;

public class Computador {
    private int ram;
    private int hd;
    private int id;
    private static int contador;

    public Computador(int ram, int hd, int id) {
        this.ram = ram;
        this.hd = hd;
        this.id = id;
        contador++;
        System.out.println("Contador: " + contador);
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHd() {
        return hd;
    }

    public void setHd(int hd) {
        this.hd = hd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Computador.contador = contador;
    }

    @Override
    public String toString() {
        return "Computador{" +
                "ram=" + ram +
                ", hd=" + hd +
                ", id=" + id +
                '}';
    }
}
