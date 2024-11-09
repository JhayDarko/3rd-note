//Promedio y suma con arrays

import java.util.Scanner;

public class Main9 {
    public static void main(String[] args) {

        try (Scanner scan = new Scanner(System.in)) {

            int[] numbers = new int[5];
            double average;
            int sum = 0;

            for (int i : numbers) {
                System.out.println("Ingresa un número");
                numbers[i] = scan.nextInt();
                sum += numbers[i];
            }
            average = (double)sum / numbers.length;

            System.out.println("La suma es: " + sum);
            System.out.println("El promedio es: " + average);
        }
    }
}