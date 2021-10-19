package pl.pjatk.tdd.arrays;

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
        return 0;
    }

    public static double avg(int[] numbers){
        return 0;
    }

    public static int sum(int[] numbers){
        return 0;
    }
}
