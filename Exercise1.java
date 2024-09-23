//Determinar el Mayor de Tres Números

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        
    try (Scanner scan = new Scanner(System.in)) {
    
        System.out.println("Ingresa el primer número");
        int number1 = scan.nextInt();

        System.out.println("Ingresa el segundo número");
        int number2 = scan.nextInt();

        System.out.println("Ingresa el tercer número");
        int number3 = scan.nextInt();

        int major;

        if ((number1 > number2) && (number1 > number3)) {
            major = number1;
        }
        else if ((number2 > number1) && (number2 > number3)) {
            major = number2;
        }
        else {
            major = number3;
        }
        System.out.println("El número mayor es: " + major);
    }
    }
}