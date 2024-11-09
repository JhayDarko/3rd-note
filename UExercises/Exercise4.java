//Factorial de un Número

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        
        try (Scanner scan = new Scanner(System.in)) {

            long factorial = 1;
            
            System.out.println("Ingresa un número para conocer su factorial");
            int number = scan.nextInt();
            int baseNumber = number;

            if (baseNumber < 0) {
                System.out.println("Los números negativos no tienen factorial");
            }
            else if (baseNumber == 0) {
                System.out.println("El factorial de 0 es 1");
            }
            else {
                while (baseNumber > 1) {
                    factorial *= baseNumber;
                    baseNumber--;
                }
                System.out.println("El factorial de " + number + " es igual a: " + factorial);
            }
        }
    }
}