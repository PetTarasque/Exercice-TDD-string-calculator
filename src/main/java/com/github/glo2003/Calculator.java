package com.github.glo2003;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
            List<Integer> numbersList = stringListToInt(stringNumberList);

            isNumberNegative(numbersList);
            numbersList = trimNumberAbove1000(numbersList);
            sum = numbersList.stream()
                    .reduce(0, Integer::sum);
            //sum = sumListOfInteger(numbersList);
        } catch (NumberFormatException e) {
            throw new InvalidNumberFormatException();
        }

        return sum;
    }

    public void isNumberNegative(List<Integer> numbersList) {
        if(numbersList.stream()
                .anyMatch(number -> number <0)) {
            throw new NegativeArraySizeException();
        }
    }

    public List<Integer> trimNumberAbove1000(List<Integer> numbersList){
        return numbersList.stream()
                .filter(num -> num <= 1000)
                .collect(Collectors.toList());
    }

    public List<Integer> stringListToInt(List<String> stringNumberList){
        return stringNumberList.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Integer sumListOfInteger(List<Integer> numbers){
        return numbers.stream()
                .reduce(0, Integer::sum);
    }
}
