package lab7Hashing;

import lab7Hashing.HashFunctions.HashFunction;

import java.util.Comparator;
import java.util.LinkedList;

public class SeparateChainingHashTable<T> extends HashTable<T> {
    private int collisions = 0;
    private int insertComparisons = 0;
    private int lookUpComparisons = 0;
    private int hashFunctionEvaluations = 0;


    private LinkedList<T>[] table = new LinkedList[10];
    private HashFunction<T> hashFunction;

    public SeparateChainingHashTable(double maxLoadFactor, Comparator<? super T> comparator,
                                        HashFunction<T> hashFunction) {
        super(maxLoadFactor, comparator);
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>();
        }
        this.hashFunction = hashFunction;
    }

    @Override
    public int capacity() {
        return table.length;
    }

    @Override
    public int size() {
        int sum = 0;
        for (int i = 0; i < table.length; i++) {
            sum += table[i].size();
        }

        return sum;
    }

    @Override
    public void insert(T object) {
        if(object==null) throw new NullPointerException();

        if (loadFactor() >= maxLoadFactor) {
            enlargeTable();
        }

        insertValue(object, table);
    }

    private void enlargeTable() {
        LinkedList<T>[] newTable = new LinkedList[table.length * 2];

        for (int i = 0; i < newTable.length; i++) {
            newTable[i] = new LinkedList<>();
        }

        for (int i = 0; i < table.length; i++) {
            for (T val : table[i]) {
                insertValue(val, newTable);
            }
        }

        table = newTable;
    }

    private int calculateHash(T val) {
        hashFunctionEvaluations += 1;
        return hashFunction.hashCode(val);
    }

    private void insertValue(T val, LinkedList<T>[] tab) {
        int index = calculateHash(val) % tab.length;
        System.out.println(index);

        if(index<0){
            index+=tab.length;
        }

        if (tab[index].size() != 0) {
            collisions += 1;
        }

        tab[index].addLast(val);
    }

    @Override
    public boolean lookUp(T object) {
        int index = calculateHash(object) % table.length;

        for (T val : table[index]) {
            lookUpComparisons += 1;
            if (comparator.compare(val, object) == 0) return true;
        }
        return false;
    }

    @Override
    public int collisions() {
        return collisions;
    }

    @Override
    public int insertComparisons() {
        return insertComparisons;
    }

    @Override
    public int lookUpComparisons() {
        return lookUpComparisons;
    }

    @Override
    public int hashFunctionEvaluations() {
        return hashFunctionEvaluations;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder("[");
        boolean appended = false;
        for (int i = 0; i < table.length; i++) {
            for(T val: table[i]){
                s.append(val).append(", ");
                appended=true;
            }

            if(appended){
                s.setLength(s.length()-2);
                appended=false;
            }

            s.append(" |");
        }

        s.setLength(s.length()-1);

        s.append("]");
        return s.toString();
    }
}
