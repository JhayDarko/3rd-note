//Calcular precio de prendas

public class Main3 {

    public static void main(String[] args) {
        
        double shirtPrice = 25;
        double pantPrice = 30;
        
        double generalDiscount = 0.15;
        double aditionalShirtDiscount = 0.05;

        double discountedShirtPrice = shirtPrice * (1-generalDiscount);
        double discountedPantPrice = pantPrice * (1-generalDiscount);
        double secondShirtPrice = discountedShirtPrice * (1-aditionalShirtDiscount);

        double totalPrice = discountedShirtPrice + discountedPantPrice;

        System.out.println("El precio de las dos prendas es de: $" + totalPrice);
        System.out.println("El precio incluyendo una segunda camiseta es de: $" + (totalPrice+secondShirtPrice));

    }
}