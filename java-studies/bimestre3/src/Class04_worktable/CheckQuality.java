package Class04_worktable;

public abstract class CheckQuality {

    protected CheckQuality nextQualityVerification;

    public CheckQuality getNextQualityVerification() {
        return nextQualityVerification;
    }

    public void setNextQualityVerification(CheckQuality nextQualityVerification) {
        this.nextQualityVerification = nextQualityVerification;
    }

    public abstract void checkProductQuality(Product product);

}
