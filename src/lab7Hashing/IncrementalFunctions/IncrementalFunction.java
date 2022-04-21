package lab7Hashing.IncrementalFunctions;

public interface IncrementalFunction<T> {
	int shift(T object, int trial);
}
