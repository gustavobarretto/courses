package Class09_integrator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClothingFactory {

    public static final Map<String, Clothing> CLOTHING_MAP = new HashMap<>();
    public static final Map<String, List<Clothing>> LIST_MAP = new HashMap<>();

    public ClothingFactory() {
        LIST_MAP.put("XS", new ArrayList<>());
        LIST_MAP.put("S", new ArrayList<>());
        LIST_MAP.put("M", new ArrayList<>());
        LIST_MAP.put("Imported", new ArrayList<>());
        LIST_MAP.put("Bad Conditions", new ArrayList<>());
    }

    public  static Clothing getClothing(String size, String type, boolean isNew, boolean isImported) {
        String clothingKey = size+":"+type+":"+":"+isNew+":"+":"+isImported;
        Clothing clothing = CLOTHING_MAP.get(clothingKey);
        if(clothing == null) {
            clothing = new Clothing(size, type, isNew, isImported);
            CLOTHING_MAP.put(clothingKey, clothing);
            creatingClothingTypeList(clothing);
        }

        sizeVerification(clothing);
        isNewAndIsImportedVerification(clothing);

        return clothing;
    }

    private static void sizeVerification (Clothing clothing) {
        LIST_MAP.get(clothing.getSize()).add(clothing);
    }

    private static void isNewAndIsImportedVerification (Clothing clothing) {

        if(clothing.isImported()) {
            LIST_MAP.get("Imported").add(clothing);
        }
        if(!clothing.isNew()) {
            LIST_MAP.get("Bad Conditions").add(clothing);
        }
    }

    public void getList(String key) {
        for(Clothing clothing : LIST_MAP.get(key)) {
            System.out.println(clothing.toString());
        }

    }

    public static void creatingClothingTypeList(Clothing clothing) {
        List listTypeCategory = LIST_MAP.get(clothing.getType());
        if(listTypeCategory == null) {
            LIST_MAP.put(clothing.getType(), new ArrayList<>());
            LIST_MAP.get(clothing.getType()).add(clothing);
        } else {
            LIST_MAP.get(clothing.getType()).add(clothing);
        }
    }

}
