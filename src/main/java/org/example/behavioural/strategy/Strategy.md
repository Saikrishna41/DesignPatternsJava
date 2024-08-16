The **Strategy Design Pattern** is a behavioral design pattern that allows you to define a family of algorithms, encapsulate each one as a separate class, and make them interchangeable. The strategy pattern lets the algorithm vary independently from the clients that use it.

### Key Concepts:
1. **Strategy Interface**: Defines the interface for the algorithm that the concrete strategies will implement.
2. **Concrete Strategy**: Implements the algorithm defined in the strategy interface.
3. **Context**: Uses a `Strategy` object to execute the algorithm. The context is not concerned with which concrete strategy is being used but delegates the responsibility of the algorithm execution to the strategy.

### Example in Java 8:

Let's consider an example where we need to perform different sorting strategies on a list of integers.

#### Step 1: Define the Strategy Interface
```java
@FunctionalInterface
public interface SortStrategy {
    void sort(List<Integer> numbers);
}
```

#### Step 2: Implement Concrete Strategies
```java
public class BubbleSortStrategy implements SortStrategy {
    @Override
    public void sort(List<Integer> numbers) {
        System.out.println("Sorting using Bubble Sort");
        // Implementation of Bubble Sort
        int n = numbers.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (numbers.get(j) > numbers.get(j+1)) {
                    // Swap arr[j+1] and arr[j]
                    int temp = numbers.get(j);
                    numbers.set(j, numbers.get(j+1));
                    numbers.set(j+1, temp);
                }
            }
        }
    }
}

public class QuickSortStrategy implements SortStrategy {
    @Override
    public void sort(List<Integer> numbers) {
        System.out.println("Sorting using Quick Sort");
        // Implementation of Quick Sort
        quickSort(numbers, 0, numbers.size() - 1);
    }

    private void quickSort(List<Integer> numbers, int low, int high) {
        if (low < high) {
            int pi = partition(numbers, low, high);
            quickSort(numbers, low, pi-1);
            quickSort(numbers, pi+1, high);
        }
    }

    private int partition(List<Integer> numbers, int low, int high) {
        int pivot = numbers.get(high);
        int i = (low-1);
        for (int j = low; j < high; j++) {
            if (numbers.get(j) < pivot) {
                i++;
                int temp = numbers.get(i);
                numbers.set(i, numbers.get(j));
                numbers.set(j, temp);
            }
        }
        int temp = numbers.get(i+1);
        numbers.set(i+1, numbers.get(high));
        numbers.set(high, temp);
        return i+1;
    }
}
```

#### Step 3: Implement the Context
```java
public class SortContext {
    private SortStrategy strategy;

    // Constructor that accepts a strategy
    public SortContext(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(List<Integer> numbers) {
        strategy.sort(numbers);
    }
}
```

#### Step 4: Usage Example with Java 8 Lambdas
With Java 8, you can leverage lambdas to make the strategy pattern more concise, especially when the strategies are simple.

```java
import java.util.Arrays;
import java.util.List;

public class StrategyPatternExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 5, 6);

        // Using Bubble Sort Strategy
        SortContext context = new SortContext(new BubbleSortStrategy());
        context.sort(numbers);
        System.out.println("Sorted list: " + numbers);

        // Using Quick Sort Strategy
        context.setStrategy(new QuickSortStrategy());
        context.sort(numbers);
        System.out.println("Sorted list: " + numbers);

        // Using Java 8 Lambda expressions for a custom sorting strategy
        context.setStrategy(nums -> {
            System.out.println("Sorting using a custom lambda strategy (reverse order)");
            nums.sort((a, b) -> b - a);
        });
        context.sort(numbers);
        System.out.println("Sorted list: " + numbers);
    }
}
```

### Explanation:
- **SortStrategy**: This is the strategy interface with a single `sort` method.
- **BubbleSortStrategy** and **QuickSortStrategy**: These are concrete strategies implementing different sorting algorithms.
- **SortContext**: This class maintains a reference to a `SortStrategy` object and uses it to perform the sorting.

In Java 8, we can also pass a lambda expression directly as the strategy, allowing for even greater flexibility and reducing boilerplate code.

### Output:
```
Sorting using Bubble Sort
Sorted list: [1, 2, 5, 5, 6, 9]
Sorting using Quick Sort
Sorted list: [1, 2, 5, 5, 6, 9]
Sorting using a custom lambda strategy (reverse order)
Sorted list: [9, 6, 5, 5, 2, 1]
```

This example demonstrates the Strategy Pattern in action, allowing the sorting algorithm to be changed at runtime.
