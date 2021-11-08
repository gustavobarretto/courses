package Class05_challenge;

public class Document implements ICloudAccessDocument {
    private String id;
    private String documentURL;
    private String content;

    public Document(String id, String documentURL, String content) {
        this.id = id;
        this.documentURL = documentURL;
        this.content = content;
    }

    @Override
    public void authorization(String userEmail, String documentURL) {


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocumentURL() {
        return documentURL;
    }

    public void setDocumentURL(String documentURL) {
        this.documentURL = documentURL;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
