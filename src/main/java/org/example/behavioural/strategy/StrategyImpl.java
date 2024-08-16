package org.example.behavioural.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrategyImpl {
    public static void main(String[] args) {
        SortContext sortContext = new SortContext(new BubbleClassSortStrategy());
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
       sortContext.sort(numbers);
    }
}
