package org.example.behavioural.strategy;

import java.util.List;

public class SortContext {
    private SortStrategy strategy;

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
