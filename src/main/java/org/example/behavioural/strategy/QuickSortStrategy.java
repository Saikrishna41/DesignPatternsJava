package org.example.behavioural.strategy;

import java.util.List;

public class QuickSortStrategy implements  SortStrategy {

    @Override
    public void sort(List<Integer> numbers) {
        System.out.println("using quick sort");

    }

}
