package lab7Hashing.Testing;

import lab56SortingAlgorithms.testing.comparators.IntegerComparator;
import lab7Hashing.HashFunctions.HashFunction;
import lab7Hashing.HashFunctions.IntegerHashFunction;
import lab7Hashing.HashTable;
import lab7Hashing.IncrementalFunctions.IncrementalFunction;
import lab7Hashing.IncrementalFunctions.LinearIncrementalFunction;
import lab7Hashing.IncrementalFunctions.QuadraticIncrementalFunction;
import lab7Hashing.OpenAdressingHashTable;
import lab7Hashing.SeparateChainingHashTable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Tester {
    private final int N;
    private final double[] alpha = {0.1, 0.2, 0.5, 0.9};
    private final Comparator<Integer> comparator;
    private final HashFunction<Integer> hashFunction;
    private final Random r;
    private final SaveToTxt saveToTxt;

    public Tester(int N) {
        this.N = N;
        this.comparator = new IntegerComparator();
        this.hashFunction = new IntegerHashFunction();
        r = new Random();
        saveToTxt = new SaveToTxt();
    }

    public void run(){
        //testSeparateChaining();
        //testOpenAdressing(new LinearIncrementalFunction<Integer>(), "OpenAdressingLinear");
        testOpenAdressing(new QuadraticIncrementalFunction<Integer>(), "OpenAdressingQuadratic");
    }

    private void testSeparateChaining() {
        ArrayList<ArrayList<Double>> loadFactor = new ArrayList<>();
        ArrayList<ArrayList<Integer>> collisions = new ArrayList<>();
        ArrayList<ArrayList<Integer>> hashFunctionEvaluations = new ArrayList<>();
        ArrayList<ArrayList<Integer>> insertComparisons = new ArrayList<>();
        HashTable<Integer> s;

        for (int i = 0; i < alpha.length; i++) {
            s = new SeparateChainingHashTable<>(alpha[i], comparator, hashFunction);

            loadFactor.add(new ArrayList<>());
            collisions.add(new ArrayList<>());
            hashFunctionEvaluations.add(new ArrayList<>());
            insertComparisons.add(new ArrayList<>());

            for (int j = 0; j < N; j++) {
                loadFactor.get(i).add(s.loadFactor());
                collisions.get(i).add(s.collisions());
                hashFunctionEvaluations.get(i).add(s.hashFunctionEvaluations());
                insertComparisons.get(i).add(s.insertComparisons());

                s.insert(r.nextInt(100));
            }

            saveToTxt.save("separateChaining", loadFactor, collisions, hashFunctionEvaluations, insertComparisons);


        }
    }

    private void testOpenAdressing(IncrementalFunction<Integer> incrementalFunction, String filename){
        ArrayList<ArrayList<Double>> loadFactor = new ArrayList<>();
        ArrayList<ArrayList<Integer>> collisions = new ArrayList<>();
        ArrayList<ArrayList<Integer>> hashFunctionEvaluations = new ArrayList<>();
        ArrayList<ArrayList<Integer>> insertComparisons = new ArrayList<>();
        HashTable<Integer> s;

        for (int i = 0; i < alpha.length; i++) {
            s = new OpenAdressingHashTable<>(alpha[i], comparator, hashFunction, incrementalFunction);

            loadFactor.add(new ArrayList<>());
            collisions.add(new ArrayList<>());
            hashFunctionEvaluations.add(new ArrayList<>());
            insertComparisons.add(new ArrayList<>());

            for (int j = 0; j < N; j++) {
                loadFactor.get(i).add(s.loadFactor());
                collisions.get(i).add(s.collisions());
                hashFunctionEvaluations.get(i).add(s.hashFunctionEvaluations());
                insertComparisons.get(i).add(s.insertComparisons());

                s.insert(r.nextInt(100));
            }

            saveToTxt.save(filename, loadFactor, collisions, hashFunctionEvaluations, insertComparisons);
        }
    }


}
