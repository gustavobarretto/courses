package Class04_challenge;

public class AccessPresident extends Access {
    @Override
    public void checkingAccess(Document document) {
        System.out.println("Access granted to the President");
    }
}
