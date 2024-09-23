//Operaciones básicas

import java.util.Scanner;

public class Main2
{
    public static void main(String[] args) {
       
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingresa el primer número");
            double number1 = scanner.nextDouble();
            
            System.out.println("Ingresa el segundo número");
            double number2 = scanner.nextDouble();
            
            double suma = number1 + number2;
            double resta = number1 - number2;
            double multiplicacion = number1 * number2;
            double division = number1 / number2;
            double modulo = number1 % number2;
            
            System.out.println("Resultado suma = " + suma);
            System.out.println("Resultado resta = " + resta);
            System.out.println("Resultado multiplicación = " + multiplicacion);
            System.out.println("Resultado división = " + division);
            System.out.println("Resultado módulo = " + modulo);
        }
   }
    }
