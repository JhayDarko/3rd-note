public class ChangeValues {

    public static void changer(int x, int y) {
        int z = y;
        y = x;
        x = z;
        System.out.println("Valores dentro de la función");
        System.out.printf("a = %s - b = %s%n", x, y);
    }
    public static void main(String[] args) throws Exception {
        int a = 5; int b = 7;
        System.out.println("Valores fuera de la función antes de llamarla");
        System.out.printf("a = %s - b = %s%n", a, b);
        changer(a, b);
        System.out.println("Valores fuera de la función después de llamarla");
        System.out.printf("a = %s - b = %s%n", a, b);
    }
}
