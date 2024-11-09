public class PassByValue {

    public static double modifyNumber(int num) {
        return Math.sqrt(num);
    }
    public static void main(String[] args) {
        int number = 5;
        System.out.printf("Número original: %s. Paso por valor: %s" ,number, modifyNumber(number));
    }
}
