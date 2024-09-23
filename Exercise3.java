//Menú Interactivo

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        
        try (Scanner scan = new Scanner(System.in)) {

            System.out.println("Ingresa el número correspondiente a la operación que deseas realizar");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");

            int option = scan.nextInt();

            if ((option < 1) || (option > 4)) {
                System.out.println("La opción seleccionada es inválida");
            }
            else {
                
            System.out.println("Ingresa el primer número a operar");
            int number1 = scan.nextInt();

            System.out.println("Ingresa el segundo número a operar");
            int number2 = scan.nextInt();

            switch (option) {

                case 1 -> System.out.println("El resultado es: " + (number1 + number2));

                case 2 -> System.out.println("El resultado es: " + (number1 - number2));

                case 3 -> System.out.println("El resultado es: " + (number1 * number2));

                case 4 -> {
                    if (number2 == 0) {
                        System.out.println("Es imposible dividir entre '0'");
                    }
                    else {
                        System.out.println("El resultado es: " + ((double)number1 / number2));
                    }   }
            }
            }

        }
    }
}  
