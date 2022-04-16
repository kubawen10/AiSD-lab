package lab7Hashing;

import java.util.Comparator;

public class OpenAdressingHashTable<T> extends HashTable<T> {
    private int collisions = 0;
    private int insertComparisons = 0;
    private int lookUpComparisons = 0;
    private int hashFunctionEvaluations = 0;

    private T[] table = (T[]) new Object[10];
    private HashFunction<T> hashFunction;
    private IncrementalFunction<T> incrementalFunction;

    protected OpenAdressingHashTable(double maxLoadFactor, Comparator<? super T> comparator,
                                     HashFunction<T> hashFunction, IncrementalFunction<T> incrementalFunction) {
        super(maxLoadFactor, comparator);
        this.hashFunction = hashFunction;
        this.incrementalFunction = incrementalFunction;
    }

    @Override
    public int capacity() {
        return table.length;
    }

    @Override
    public int size() {
        int sum = 0;

        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                sum += 1;
            }
        }

        return sum;
    }

    @Override
    public void insert(T object) {
        if (object == null) throw new NullPointerException();

        if (loadFactor() >= maxLoadFactor) {
            enlargeTable();
        }

        insertValue(object, table);
    }

    private void enlargeTable() {
        T[] newTable = (T[]) new Object[table.length * 2];

        for (int i = 0; i < table.length; i++) {
            insertValue(table[i], newTable);
        }

        table = newTable;
    }

    private int calculateHash(T val, int trial) {
        hashFunctionEvaluations += 1;
        return hashFunction.hashCode(val) + incrementalFunction.shift(val, trial);
    }

    private void insertValue(T val, T[] tab) {
        int index = calculateHash(val,0) % tab.length;

        //bo zawsze sprawdzam czy null
        insertComparisons += 1;

        //jezeli nie null mamy kolizje i trzeba szukac kolejne miejsce
        if (tab[index] != null) {
            collisions += 1;

            int i = 0;
            while (tab[index] != null) {
                insertComparisons += 1;

                i++;
                index = calculateHash(val, i) % tab.length;
            }
        }

        tab[index] = val;
    }

    @Override
    public boolean lookUp(T object) {
        int index = calculateHash(object, 0) % table.length;

        int i = 0;
        while(table[index] != null){
            lookUpComparisons+=1;
            if(comparator.compare(object, table[index]) ==  0){
                return true;
            }
            i++;

            index = calculateHash(object, i) % table.length;
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
}