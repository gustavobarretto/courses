package Class04_challenge;

public class AccessMinister extends Access {
    @Override
    public void checkingAccess(Document document) {
        if(document.getAccess().equals("2")) {
            System.out.println("Access granted to the Minister");
        }
        else {
            System.out.println("Access denied to the Minister");
            this.getNextAccess().checkingAccess(document);
        }
    }
}
