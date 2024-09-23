//Retiro de cuenta bancaria

public class Main4 {
    
    public static void main(String[] args) {
        
        int countMoney = 1000;
        int withdrawedMoney = 200;
        int weeks = 4;

        int finalMoney = countMoney - (withdrawedMoney*weeks);

        System.out.println("El dinero en su cuenta a final de mes será: $" + finalMoney);
    }
}
