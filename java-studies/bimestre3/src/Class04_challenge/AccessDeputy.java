package Class04_challenge;

public class AccessDeputy extends Access {
    @Override
    public void checkingAccess(Document document) {
        if(document.getAccess().equals("1")) {
            System.out.println("Access granted to the Deputy");
        }
        else {
            System.out.println("Access denied to the Deputy");
            this.getNextAccess().checkingAccess(document);
        }
    }
}
