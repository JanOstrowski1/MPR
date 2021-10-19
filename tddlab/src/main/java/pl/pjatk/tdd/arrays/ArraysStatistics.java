package pl.pjatk.tdd.arrays;

import java.util.Arrays;

public class ArraysStatistics {
    public static int max(int[] numbers){
        int max =numbers[0];
        for (int i = 0; i <numbers.length ; i++) {
            if(numbers[i]>max){
                max =numbers[i];
            }
        }
        return max;
    }

    public static int min(int[] numbers){
        int min =numbers[0];
        for (int i = 0; i <numbers.length ; i++) {
            if(numbers[i]<min){
                min =numbers[i];
            }
        }
        return min;
    }

    public static double avg(int[] numbers){
        double sum= ArraysStatistics.sum(numbers);
        return sum/numbers.length;
    }

    public static int sum(int[] numbers){
        return Arrays.stream(numbers).sum();
    }


}
