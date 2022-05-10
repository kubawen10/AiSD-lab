package lab9HeapyBST.Core;

public  interface  BSTInterface<T> {
    T find(T value);
    void insert(T value);
    void delete(T value);
    void clear();
}
