package Class05_challenge;

import java.util.List;

public class VerificationAccess implements ICloudAccessDocument {

    private Document document;
    private List<String> userAuthorized;

    public VerificationAccess(Document document, List<String> userAuthorized) {
        this.document = document;
        this.userAuthorized = userAuthorized;
    }

    @Override
    public void authorization(String userEmail, String documentURL) {
        if(document.getDocumentURL().equals(documentURL)) {
            if (!this.userAuthorized.contains(userEmail)) {
                System.out.println("User not authorized");
            } else {
                System.out.println("Access granted. Content:\n");
                System.out.println(document.getContent());
            }
        } else {
            System.out.println("Document not found");
        }
    }
}
