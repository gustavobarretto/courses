package main;

public class Player {
    private int total_points;
    private boolean spare;
    private int strike;

    Player () {
        this.total_points = 0;
        this.spare = false;
        this.strike = 0;
    }

    public int getTotal_points() {
        return total_points;
    }

    public void setTotal_points(int total_points) {
        this.total_points = total_points;
    }

    public boolean isSpare() {
        return spare;
    }

    public void setSpare(boolean spare) {
        this.spare = spare;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }
}
