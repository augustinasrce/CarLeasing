package lt.swedbank.carleasing;

public class CarLeasing {

    private static double AGREEMENT_FEE = 150;

    public static void main(String[] args) {
        double carPriceIncludingVat = Double.parseDouble(args[0]);
        System.out.println("Car carPriceIncludingVat including VAT: " + carPriceIncludingVat + " EUR");

        int downPaymentPercentage = Integer.parseInt(args[1]);
        System.out.println("Down payment size : " + downPaymentPercentage + "%");
        System.out.println();

        double downPayment = calculateDownPayment(carPriceIncludingVat, downPaymentPercentage);
        System.out.println("Down payment: " + downPayment + " EUR");
        double loanSize = calculateLoanSize(carPriceIncludingVat, downPayment);
        System.out.println("Loan size: " + loanSize + " EUR");
        System.out.println();

        System.out.println("Agreement fee: " + AGREEMENT_FEE + " EUR");
        double initialInstallment = calculateInitialInstallment(downPayment);
        System.out.println("Initial installment: " + initialInstallment + " EUR");
    }

    private static double calculateDownPayment(double price, double percentage) {
        return price * percentage / 100;
    }

    private static double calculateLoanSize(double price, double downPayment) {
        return price - downPayment;
    }

    private static double calculateInitialInstallment(double downPayment) {
        return AGREEMENT_FEE + downPayment;
    }
}
