package Class05_worktable;

public class SpotfyUser {
    private int ID;
    private String userType;

    public SpotfyUser(int ID, String userType) {
        this.ID = ID;
        this.userType = userType;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
