package Class09;

import java.util.HashMap;
import java.util.Map;

public class TrianguloFactory {
    public static final Map<String, Triangulo> TRIANGULO_MAP = new HashMap<>();

    public static Triangulo obterTriangulo(String cor, int tamanho) {
        Triangulo triangulo = TRIANGULO_MAP.get(cor);
        if(triangulo == null) {
            triangulo = new Triangulo(cor, tamanho);
            TRIANGULO_MAP.put(cor, triangulo);
        }
        return triangulo;
    }
}
