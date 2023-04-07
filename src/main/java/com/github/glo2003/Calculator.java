package com.github.glo2003;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    public int add(String numbers){
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",";

        if (numbers.startsWith("//")) {
            delimiter = numbers.substring(2, 3);
            numbers = numbers.substring(4);
        }

        List<String> stringNumberList = new ArrayList<>();
        String regex = "\\n|" + delimiter + "+";
        stringNumberList.addAll(Arrays.asList(numbers.split(regex)));


        int sum;
        try {
            if(stringNumberList.stream()
                    .map(Integer::parseInt)
                    .anyMatch(number -> number <0)) {
                throw new NegativeArraySizeException();
            }
            sum = stringNumberList.stream()
                    .map(stringNumer -> Integer.parseInt(stringNumer))
                    .reduce(0, Integer::sum);
        } catch (NumberFormatException e) {
            throw new InvalidNumberFormatException();
        }

        return sum;
    }
}
