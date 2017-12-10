package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        Matcher m = new And(new HasAtLeast(10, "goals"),
                new HasAtLeast(10, "assists"),
                new PlaysIn("PHI")
        );

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
        System.out.println("------");
        Matcher m2 = new Not(new HasAtLeast(1, "goals"));

        for (Player player : stats.matches(m2)) {
            System.out.println(player);
        }

        System.out.println("------");
        Matcher m3 = new Or(new HasAtLeast(40, "goals"),
                new HasAtLeast(60, "assists"),
                new HasAtLeast(85, "points")
        );

        for (Player player : stats.matches(m3)) {
            System.out.println(player);
        }

        System.out.println("------");
        Matcher m4 = new HasFewerThan(1, "goals");
        for (Player player : stats.matches(m4)) {
            System.out.println(player);
        }
        
        System.out.println("------");
        QueryBuilder query = new QueryBuilder();
        Matcher m5 = query.playsIn("NYR")
                .hasAtLeast(10, "goals")
                .hasFewerThan(25, "assists").build();

        for (Player player : stats.matches(m5)) {
            System.out.println(player);
        }
        
        System.out.println("------");
        
        Matcher m6 = query.playsIn("PHI")
                .hasAtLeast(10, "goals")
                .hasFewerThan(20, "assists").build();

        Matcher m7 = query.playsIn("EDM")
                .hasAtLeast(60, "points").build();

        Matcher m8 = query.oneOf(m6, m7).build();
        
        for (Player player : stats.matches(m8)) {
            System.out.println(player);
        }
    }
}
