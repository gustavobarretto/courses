package Class09_integrator;

public class Clothing {
    private String size;
    private String type;
    private boolean isNew;
    private boolean isImported;

    public Clothing(String size, String type, boolean isNew, boolean isImported) {
        this.size = size;
        this.type = type;
        this.isNew = isNew;
        this.isImported = isImported;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public boolean isImported() {
        return isImported;
    }

    public void setImported(boolean imported) {
        isImported = imported;
    }

    @Override
    public String toString() {
        return "Clothing{" +
                "size='" + size + '\'' +
                ", type='" + type + '\'' +
                ", isNew=" + isNew +
                ", isImported=" + isImported +
                '}';
    }
}
