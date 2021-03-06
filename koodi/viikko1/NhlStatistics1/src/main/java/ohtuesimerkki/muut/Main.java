package ohtuesimerkki.muut;

import ohtuesimerkki.Statistics;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReader("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        System.out.println("Philadelphia Flyers");
        for (Player player : stats.team("EDM")) {
            System.out.println(player);
        }

        System.out.println("");

        System.out.println("Top scorers");
        for (Player player : stats.topScorers(10)) {
            System.out.println(player);
        }
    }
}
