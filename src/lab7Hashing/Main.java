package lab7Hashing;

import lab7Hashing.Comparators.IntegerComparator;
import lab7Hashing.HashFunctions.IntegerHashFunction;
import lab7Hashing.IncrementalFunctions.IncrementalFunction;
import lab7Hashing.IncrementalFunctions.LinearIncrementalFunction;
import lab7Hashing.Testing.Tester;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Tester t = new Tester(20);
        t.run();
    }
}
