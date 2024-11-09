//Contador de Números Pares

public class Exercise2 {
    public static void main(String[] args) {

        int evenCount = 0;

        for (int x=1;x<=100;x++) {
            if (x % 2 == 0) {
                evenCount++;
            }       
        }
         System.out.println("La cantidad de números pares entre 1 y 100 es de: " + evenCount);
        }
    
}