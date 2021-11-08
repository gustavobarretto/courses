package Class07_worktable;

public class Tree {
    private String treeType;
    private int height;
    private int width;
    private String color;

    public Tree(String treeType, int height, int width, String color) {
        this.treeType = treeType;
        this.height = height;
        this.width = width;
        this.color = color;
    }

    public String getTreeType() {
        return treeType;
    }

    public void setTreeType(String treeType) {
        this.treeType = treeType;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "treeType='" + treeType + '\'' +
                ", height=" + height +
                ", width=" + width +
                ", color='" + color + '\'' +
                '}';
    }
}
