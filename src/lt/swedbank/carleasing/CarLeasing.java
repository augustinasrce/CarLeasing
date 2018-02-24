package lt.swedbank.carleasing;

public class CarLeasing {

    private static double AGREEMENT_FEE = 150;

    public static void main(String[] args) {
        double carPriceIncludingVat = Double.parseDouble(args[0]);
        int downPaymentPercentage = Integer.parseInt(args[1]);
        System.out.println("Car carPriceIncludingVat including VAT: " + carPriceIncludingVat + " EUR");
        System.out.println("Down payment size : " + downPaymentPercentage + "%");
        boolean isValidParameters = false;
        try {
            isValidParameters = validateCarPrice(carPriceIncludingVat);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            isValidParameters = isValidParameters || validateDownPaymentPercentages(downPaymentPercentage);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        if (isValidParameters) {
            System.out.println("Leasing parameters are valid");
            System.out.println();
            double downPayment = calculateDownPayment(carPriceIncludingVat, downPaymentPercentage);
            System.out.println("Down payment: " + downPayment + " EUR");
            double loanSize = calculateLoanSize(carPriceIncludingVat, downPayment);
            System.out.println("Loan size: " + loanSize + " EUR");
            System.out.println();

            System.out.println("Agreement fee: " + AGREEMENT_FEE + " EUR");
            double initialInstallment = calculateInitialInstallment(downPayment);
            System.out.println("Initial installment: " + initialInstallment + " EUR");
        } else {
            System.out.println("Leasing parameters are invalid");
        }
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

    private static boolean validateCarPrice(double price) throws IllegalArgumentException {
        if (price < 0) {
            throw new IllegalArgumentException("Car price " + price + " is invalid: it cannot be negative");
        } else if (price == 0) {
            throw new IllegalArgumentException("Car price " + price + " is invalid: it cannot be zero");
        }
        return true;
    }

    private static boolean validateDownPaymentPercentages(int percentage) throws IllegalArgumentException {
        if (!(percentage > 0 && percentage < 100)) {
            throw new IllegalArgumentException("Down payment size " + percentage + " is invalid: it must be between 0 and 100");
        }
        return true;
    }
}
