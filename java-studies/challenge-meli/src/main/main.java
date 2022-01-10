package main;

import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {
        // Integer maxDigit = 1;
        Integer maxSum = 21;

        List<Integer> numbers = new ArrayList<>();

        Integer maxNumber = maxDigit * 1111;

        for (Integer index = 1000; index <= maxNumber; index++) {
            String indexStr = index.toString();
            List<Integer> arr = new ArrayList<>();

            for (Integer word = 0; word <= 3; word++) {
                if(Integer.parseInt(String.valueOf(indexStr.charAt(word))) <= maxDigit) {
                    arr.add(Integer.parseInt(String.valueOf(indexStr.charAt(word))));
                }
            }
            int result = arr.stream().reduce(0, (subtotal, element) -> subtotal + element);
            if( result == 21) {
                numbers.add(index);
            }
        }
        // return numbers.isEmpty() ? null : numbers;
        System.out.println(numbers);
    }
}