package lt.swedbank.carleasing;

public class CarLeasing {

    public static void main(String[] args) {
        System.out.println("Car carPriceIncludingVat including VAT: " + Double.parseDouble(args[0]) + " EUR");
        System.out.println("Down payment size : " + args[1] + "%");
    }
}
