package Class04_challenge;

public class AccessCheck {

    private Access firstCheck;

    public AccessCheck() {
        this.firstCheck = new AccessDeputy();
        Access secondCheck_MINISTER = new AccessMinister();
        Access lastCheck_PRESIDENT = new AccessPresident();

        firstCheck.setNextAccess(secondCheck_MINISTER);
        secondCheck_MINISTER.setNextAccess(lastCheck_PRESIDENT);
    }

    public void checkingAccess(Document document) {
        System.out.println("Verifying access in the system for the document named " + document.getContent() + "...");
        firstCheck.checkingAccess(document);
    };
}
