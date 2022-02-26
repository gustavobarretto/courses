package main;
import java.util.Random;

public class Bowling {
    private int pines;
    private int rounds;
    private Player player;

    public Bowling(Player player) {
        this.rounds = 1;
        this.pines = 10;
        this.player = player;
    }

    public void play () {
        while(this.rounds <= 10) {
            System.out.println("ROUND: " +  this.rounds + "º");

            bowling();

            if((this.player.isSpare() || this.player.getStrike() == 2) && this.rounds == 10) {
                System.out.println("You did it! You can play one more time!");
                Random randomNumber = new Random();
                int totalPointsRound = 0;
                int lastLaunch = randomNumber.nextInt(this.pines + 1);
                int play = this.pines - lastLaunch;
                System.out.println("lastLaunch: " + lastLaunch);
                if(play == 0) {
                    System.out.println("STRIKE!");
                    totalPointsRound = lastLaunch;
                    this.player.setTotal_points(this.player.getTotal_points() + verifySpareAndStrike(totalPointsRound) );
                    this.player.setStrike(2);
                    System.out.println("You have now " + this.player.getTotal_points() + " points!");
                    this.pines = 10;
                }

                System.out.println("You throw " + lastLaunch + " pines!");
                this.player.setTotal_points((this.player.getTotal_points() + lastLaunch));
                System.out.println("You have now " + this.player.getTotal_points() + " points!");
                this.pines = 10;

            }
            this.rounds += 1;
        }
    }

    private void bowling() {
        Random randomNumber = new Random();
        int totalPointsRound = 0;

        int firstLaunch = randomNumber.nextInt(this.pines + 1);
        System.out.println("firstLaunch: " + firstLaunch);
        int firstPlay = this.pines - firstLaunch;
        if(firstPlay == 0) {
            System.out.println("STRIKE!");
            totalPointsRound = firstLaunch;
            this.player.setTotal_points(this.player.getTotal_points() + verifySpareAndStrike(totalPointsRound) );
            this.player.setStrike(2);
            System.out.println("You have now " + this.player.getTotal_points() + " points!");
            this.pines = 10;
            return;
        }

        int secondLaunch = randomNumber.nextInt(firstPlay + 1);
        System.out.println("secondLaunch: " + secondLaunch);
        int secondPlay = firstPlay - secondLaunch;
        if(secondPlay == 0) {
            System.out.println("SPARE!");
            totalPointsRound += verifySpareAndStrike(firstLaunch);
            totalPointsRound += verifySpareAndStrike(secondLaunch);
            this.player.setTotal_points(this.player.getTotal_points() + totalPointsRound);
            this.player.setSpare(true);
            System.out.println("You have now " + this.player.getTotal_points() + " points!");
            this.pines = 10;
            return;
        }

        System.out.println("You throw " + (firstLaunch + secondLaunch) + " pines!");
        totalPointsRound += verifySpareAndStrike(firstLaunch);
        totalPointsRound += verifySpareAndStrike(secondLaunch);

        this.player.setTotal_points((this.player.getTotal_points() + totalPointsRound));
        System.out.println("You have now " + this.player.getTotal_points() + " points!");
        this.pines = 10;
        return;

    }

    private int verifySpareAndStrike(int play) {
        if(this.player.isSpare()) {
            this.player.setSpare(false);
            return (play * 2);
        }
        if(this.player.getStrike() > 0) {
            this.player.setStrike(this.player.getStrike() - 1);
            return (play * 2);
        }
        return play;
    }

}
