package lt.swedbank.carleasing;

public class CarLeasing {

    private static double AGREEMENT_FEE = 150;

    public static void main(String[] args) {
        double carPriceIncludingVat = Double.parseDouble(args[0]);
        System.out.println("Car carPriceIncludingVat including VAT: " + carPriceIncludingVat + " EUR");

        int downPaymentPercentage = Integer.parseInt(args[1]);
        System.out.println("Down payment size : " + downPaymentPercentage + "%");
        System.out.println();

        double downPaymentAmount = carPriceIncludingVat * downPaymentPercentage / 100;
        System.out.println("Down payment: " + downPaymentAmount + " EUR");
        double loanSizeAmount = carPriceIncludingVat - downPaymentAmount;
        System.out.println("Loan size: " + loanSizeAmount + " EUR");
        System.out.println();

        System.out.println("Agreement fee: " + AGREEMENT_FEE + " EUR");
        double initialInstallmentAmount = downPaymentAmount + AGREEMENT_FEE;
        System.out.println("Initial installment: " + initialInstallmentAmount + " EUR");
    }
}
