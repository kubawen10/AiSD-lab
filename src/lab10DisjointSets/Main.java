package lab10DisjointSets;

import lab10DisjointSets.ForestDisjointSet.ForestDisjointSet;
import lab10DisjointSets.ListDisjointSet.ListDisjointSet;

import java.time.Duration;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        System.out.println("LDS test");
        DisjointSet lds = new ListDisjointSet();
        testSet(lds);

        System.out.println("\nFDS test");
        DisjointSet fds = new ForestDisjointSet();
        testSet(fds);
    }

    public static void testSet(DisjointSet set){
        SetElement s1 = set.makeSet();
        SetElement s2 = set.makeSet();


        System.out.println("Start adding and union with s1");
        //making set of n elements: n*O(1)

        for (int i = 0; i < 10000000; i++) {
            if (i == 4567) {
                s2 = set.makeSet();
                set.union(s1, s2);
            }
            set.union(s1, set.makeSet());
        }
        System.out.println("Stop adding");

        //s1 and s2 are in same set, s1 is representative of this set
        System.out.println("s1 and s2 are same set (should be true) test: " + (set.findSet(s1) == set.findSet(s2)));

        //making another set of 10000 elements
        SetElement s3 = set.makeSet();
        System.out.println("Create new set s3");
        for (int i = 0; i < 10000001; i++) {
            set.union(s3, set.makeSet());
        }

        //both sets arnt united
        System.out.println("s1 and s3 united? (should be false): " + (set.findSet(s3) == set.findSet(s1)));


        System.out.println("Start union");
        Instant start = Instant.now();
        set.union(s1, s3);
        Instant end = Instant.now();
        System.out.println("End union");
        System.out.println("Union time: " + Duration.between(start, end).toMillis());
        System.out.println("s1 and s3 united? (should be true): " + (set.findSet(s3) == set.findSet(s1)));
    }
}
