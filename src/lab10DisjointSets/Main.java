package lab10DisjointSets;

import lab10DisjointSets.ForestDisjointSet.FDSElement;
import lab10DisjointSets.ForestDisjointSet.ForestDisjointSet;
import lab10DisjointSets.ListDisjointSet.LDSElement;
import lab10DisjointSets.ListDisjointSet.ListDisjointSet;

import java.time.Duration;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        testLDS();
        testFDS();
    }

    public static void testFDS(){
        System.out.println("FDS test");
        DisjointSet lds = new ForestDisjointSet();

        SetElement s1 = lds.makeSet();
        SetElement s2 = lds.makeSet();


        //making set of n elements: n*O(1)
        for (int i = 0; i < 10000000; i++) {
            if (i == 4567) {
                s2 = lds.makeSet();
                lds.union(s1, s2);
            }

            lds.union(s1, lds.makeSet());
        }
        //s1 and s2 are in same set, s1 is representative of this set
        System.out.println(s1 == lds.findSet(s2));

        //making another set of 10000 elements
        SetElement s3 = lds.makeSet();
        for (int i = 0; i < 10000000; i++) {
            lds.union(s3, lds.makeSet());
        }

        //both sets arnt united
        System.out.println("United? " + (lds.findSet(s3) == lds.findSet(s1)));

        Instant start = Instant.now();
        s1 = lds.union(s1, s3);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());
    }

    public static void testLDS(){
        System.out.println("LDS test");
        DisjointSet lds = new ListDisjointSet();

        SetElement s1 = lds.makeSet();
        SetElement s2 = lds.makeSet();


        //making set of n elements: n*O(1)
        for (int i = 0; i < 10000000; i++) {
            if (i == 4567) {
                s2 = lds.makeSet();
                lds.union(s1, s2);
            }

            lds.union(s1, lds.makeSet());
        }
        //s1 and s2 are in same set, s1 is representative of this set
        System.out.println("Same set? " + (s1 == lds.findSet(s2)));

        //check length of set
        System.out.println(((LDSElement) s1).getLength());

        //making another set of 10000 elements
        SetElement s3 = lds.makeSet();
        for (int i = 0; i < 10000000; i++) {
            lds.union(s3, lds.makeSet());
        }

        //both sets arnt united
        System.out.println("United? " + (lds.findSet(s3) == lds.findSet(s1)));

        Instant start = Instant.now();
        s1 = lds.union(s1, s3);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());

        System.out.println(((LDSElement) s1).getLength());
    }
}
