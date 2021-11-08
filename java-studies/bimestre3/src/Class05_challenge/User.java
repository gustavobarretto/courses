package Class05_challenge;

public class User implements ICloudAccessDocument {

    private String userName;
    private String userEmail;

    public User(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public void authorization(String userEmail, String documentURL) {

    }
}
