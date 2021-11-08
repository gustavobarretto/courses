package Class04_challenge;

public class Document {
    private String content;
    private String type;
    private String access;

    public Document(String content, String type, String access) {
        this.content = content;
        this.type = type;
        this.access = access;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }
}
