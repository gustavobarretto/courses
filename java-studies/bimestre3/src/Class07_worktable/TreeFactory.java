package Class07_worktable;

import java.util.HashMap;
import java.util.Map;

public class TreeFactory {

    private static Map<String, Tree> TREES = new HashMap<>();

    public Tree getTreeType(String treeType, int height, int width, String color) {
        String keyTree = treeType+":"+height+":"+width+":"+color;

        if(!TREES.containsKey(keyTree)) {

            TREES.put(keyTree, new Tree(treeType, height, width, color));
//            System.out.println("Nova árvore criada com a key: " + keyTree);
            return TREES.get(keyTree);
        }
//        System.out.println("Resgatando árvore existente de key " + keyTree);
        return TREES.get(keyTree);
    }


}
