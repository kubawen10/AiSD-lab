package lab7Hashing;

import lab7Hashing.Comparators.IntegerComparator;
import lab7Hashing.HashFunctions.IntegerHashFunction;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        SeparateChainingHashTable<Integer> s = new SeparateChainingHashTable<>(0.5, new IntegerComparator(), new IntegerHashFunction());
        Random r = new Random();
        System.out.println(s);
        System.out.println(s.size());
        System.out.println(s.capacity());

        for (int i = 0; i < 20; i++) {
            s.insert(r.nextInt(200));
            System.out.println(s);
        }

        System.out.println(s.capacity());
        System.out.println(s.size());
    }
}
