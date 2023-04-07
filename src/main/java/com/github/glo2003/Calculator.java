package com.github.glo2003;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        List<String> stringNumberList = new ArrayList<>();
        String regex = ",+";
        stringNumberList.addAll(Arrays.asList(numbers.split(regex)));
        int sum;

        try {
            sum = stringNumberList.stream()
                    .map(stringNumer -> Integer.parseInt(stringNumer))
                    .reduce(0, Integer::sum);
        } catch (NumberFormatException e) {
            throw new InvalidNumberFormatException();
        }

        return sum;
    }
}
