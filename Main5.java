//Promedio de tres números

import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) {
        
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingresa el primer número");
            double number1 = scanner.nextDouble();

            System.out.println("Ingresa el segundo número");
            double number2 = scanner.nextDouble();

            System.out.println("Ingresa el tercer número");
            double number3 = scanner.nextDouble();

            double average = (number1+number2+number3) / 3;

            System.out.println("El promedio de los tres números es de: " + average);
        }
    }
    
}
