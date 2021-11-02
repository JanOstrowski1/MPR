package pl.pjatk.tdd.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ilo elementową tablicę chcesz utworzyć ?");
        int size = scanner.nextInt();
        int[] numbers = new int[size];

        for (int i=0; i<numbers.length; i++){
            System.out.printf("Podaj %d element tablicy\n", i);
            numbers[i] = scanner.nextInt();
        }

        System.out.printf("Wprowadzona tablica : %s\n", Arrays.toString(numbers));
        System.out.printf("Maksymalna wartość : %d\n", ArraysStatistics.max(numbers));
        System.out.printf("Minimalna wartość : %d\n", ArraysStatistics.min(numbers));
        System.out.printf("Suma wprowadzonych liczb : %d\n", ArraysStatistics.sum(numbers));
        System.out.printf("Wartość średnia: %.2f\n", ArraysStatistics.avg(numbers));
    }
}
