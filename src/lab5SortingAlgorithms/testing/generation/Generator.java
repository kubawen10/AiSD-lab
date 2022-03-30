package lab5SortingAlgorithms.testing.generation;

import java.util.List;

public interface Generator<T> {
	List<T> generate(int size);
}
