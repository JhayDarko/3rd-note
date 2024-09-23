//Factorial y sumatorio de un Número

import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {
        
        try (Scanner scan = new Scanner(System.in)) {

            long factorial = 1;
            int sumatory = 0;
            
            System.out.println("Ingresa un número para conocer su factorial y su sumatorio");
            int number = scan.nextInt();
            int baseNumber = number;

            if (baseNumber < 0) {
                System.out.println("Los números negativos no tienen factorial");

                while (baseNumber < 0) {
                    sumatory += baseNumber;
                    baseNumber--;
                }
                System.out.println("El sumatorio de " + number + " es igual a: " + sumatory);
            }
            else if (baseNumber == 0) {
                System.out.println("El factorial de 0 es 1");
                System.out.println("El sumatorio de 0 es 0");
            }
            else {
                while (baseNumber > 0) {
                    factorial *= baseNumber;
                    sumatory += baseNumber;
                    baseNumber--;
                }
                System.out.println("El factorial de " + number + " es igual a: " + factorial);
                System.out.println("El sumatorio de " + number + " es igual a: " + sumatory);
            }
        }
    }
}