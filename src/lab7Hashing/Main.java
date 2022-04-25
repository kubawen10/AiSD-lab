package lab7Hashing;

import lab7Hashing.Comparators.IntegerComparator;
import lab7Hashing.Comparators.StudentComparator;
import lab7Hashing.HashFunctions.HashFunction;
import lab7Hashing.HashFunctions.IntegerHashFunction;
import lab7Hashing.HashFunctions.StudentHashFunction;
import lab7Hashing.IncrementalFunctions.IncrementalFunction;
import lab7Hashing.IncrementalFunctions.LinearIncrementalFunction;
import lab7Hashing.Testing.Tester;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        Tester t = new Tester(20);
//        t.run();

        Comparator<Student> studentComparator = new StudentComparator();
        HashFunction<Student> studentHashFunction = new StudentHashFunction();
        IncrementalFunction<Student> incrementalFunction = new LinearIncrementalFunction<>();

        //HashTable<Student> studentHashTable = new OpenAdressingHashTable<>(0.1, studentComparator, studentHashFunction, incrementalFunction);
        HashTable<Student> studentHashTable = new SeparateChainingHashTable<>(0.1, studentComparator, studentHashFunction);
        List<Integer> g1 = new ArrayList<>();
        g1.add(1);
        g1.add(2);
        g1.add(3);
        g1.add(4);

        List<Integer> g2 = new ArrayList<>();
        g2.add(1);
        g2.add(2);
        g2.add(3);
        g2.add(4);
        g2.add(5);

        Student s1 = new Student("Kubaa", "Wen", 11, g1);
        Student s2 = new Student("Kubaa", "Wengrz", 20, g1);
        Student s3 = new Student("Kubaa", "Wen", 11, g2);
        Student s4 = new Student("Kubaa", "Wen", 11, g1);

        studentHashTable.insert(s1);
        studentHashTable.insert(s2);
        studentHashTable.insert(s3);

        System.out.println(studentHashTable);

        System.out.println(studentHashTable.lookUp(s3));
    }
}
