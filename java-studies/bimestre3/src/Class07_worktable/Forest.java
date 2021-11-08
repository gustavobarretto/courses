package Class07_worktable;

import java.util.ArrayList;
import java.util.List;

public class Forest {

    private List<Tree> forest = new ArrayList<>();

    public void creatingForest(Tree tree) {
        forest.add(tree);
    }

    public List<Tree> getForest() {
        return forest;
    }
}
