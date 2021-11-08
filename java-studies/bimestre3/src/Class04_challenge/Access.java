package Class04_challenge;

public abstract class Access {

    protected Access nextAccess;

    public Access getNextAccess() {
        return nextAccess;
    }

    public void setNextAccess(Access nextAccess) {
        this.nextAccess = nextAccess;
    }

    public abstract void checkingAccess(Document document);
}
