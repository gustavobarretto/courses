package Class09_integrator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.List;

public class ClothingTest {

    List<Clothing> pedidos = new ArrayList<>();
    ClothingFactory factory = new ClothingFactory();

    @AfterEach
    void getCleanClothingMap() {
        factory.CLOTHING_MAP.clear();
    }

    @Test
    void getClothingObject() {

        Clothing clothing1 = factory.getClothing("XS", "pants", true, true);
        Clothing clothing2 = factory.getClothing("XS", "t-shirt", true, true);
        Clothing clothing3 = factory.getClothing("XS", "underwear", true, true);
        Clothing clothing4 = factory.getClothing("XS", "pants", true, true);
        Clothing clothing5 = factory.getClothing("XS", "t-shirt", true, true);
        Clothing clothing6 = factory.getClothing("XS", "underwear", true, true);

        assertEquals("pants", clothing1.getType());
        assertEquals("t-shirt", clothing2.getType());
        assertEquals("underwear", clothing3.getType());
        assertEquals("pants", clothing4.getType());
        assertEquals("t-shirt", clothing5.getType());
        assertEquals("underwear", clothing6.getType());

        assertEquals(clothing1, clothing4);
        assertEquals(clothing2, clothing5);
        assertEquals(clothing3, clothing6);

    }

    @Test
    void getClothing() {

        Clothing clothing1 = factory.getClothing("XS", "pants", true, true);
        Clothing clothing2 = factory.getClothing("S", "pants", true, true);
        Clothing clothing3 = factory.getClothing("M", "pants", true, false);
        Clothing clothing4 = factory.getClothing("XS", "pants", true, true); // repetido
        Clothing clothing5 = factory.getClothing("M", "t-shirt", false, false);
        Clothing clothing6 = factory.getClothing("S", "t-shirt", false, false);
        Clothing clothing7 = factory.getClothing("XS", "t-shirt", true, true);
        Clothing clothing8 = factory.getClothing("XS", "t-shirt", true, true); // repetido
        Clothing clothing9 = factory.getClothing("M", "t-shirt", true, true); // pode não ser repetido
        Clothing clothing10 = factory.getClothing("XS", "hat", true, true);
        Clothing clothing11 = factory.getClothing("XS", "socks", true, true);
        Clothing clothing12 = factory.getClothing("M", "socks", false, false);
        Clothing clothing13 = factory.getClothing("XS", "underwear", false, false);

        pedidos.add(clothing1);
        pedidos.add(clothing2);
        pedidos.add(clothing3);
        pedidos.add(clothing4);
        pedidos.add(clothing5);
        pedidos.add(clothing6);
        pedidos.add(clothing7);
        pedidos.add(clothing8);
        pedidos.add(clothing9);
        pedidos.add(clothing10);
        pedidos.add(clothing11);
        pedidos.add(clothing12);
        pedidos.add(clothing13);

        assertEquals(pedidos.size(), 13);

        int sizeOfFactory = factory.CLOTHING_MAP.size();
        assertEquals(sizeOfFactory,11);
    }

    @Test
    void testClothing() {

        Clothing clothing1 = factory.getClothing("XS", "pants", true, true);
        Clothing clothing2 = factory.getClothing("XS", "pants", true, true); // repetido
        Clothing clothing3 = factory.getClothing("XS", "pants", true, true); // repetido
        Clothing clothing4 = factory.getClothing("XS", "pants", true, true); // repetido
        Clothing clothing5 = factory.getClothing("M", "pants", false, false);
        Clothing clothing6 = factory.getClothing("S", "t-shirt", true, true);
        Clothing clothing7 = factory.getClothing("S", "t-shirt", true, true); // repetido
        Clothing clothing8 = factory.getClothing("S", "t-shirt", true, true); // repetido
        Clothing clothing9 = factory.getClothing("S", "t-shirt", true, true); // repetido
        Clothing clothing10 = factory.getClothing("S", "t-shirt", true, true); // repetido

        pedidos.add(clothing1);
        pedidos.add(clothing2);
        pedidos.add(clothing3);
        pedidos.add(clothing4);
        pedidos.add(clothing5);
        pedidos.add(clothing6);
        pedidos.add(clothing7);
        pedidos.add(clothing8);
        pedidos.add(clothing9);
        pedidos.add(clothing10);

        assertEquals(pedidos.size(), 10);
        assertEquals(factory.CLOTHING_MAP.size(), 3);
    }
}
