package lt.swedbank.carleasing;

public class CarLeasing {

    private static final double AGREEMENT_FEE = 150.00;

    public static void main(String[] args) {
        boolean isArgumentTypesValid = isAgumentDataTypesValid(args[0], args[1]);
        if (!isArgumentTypesValid) {
            System.out.println("Terminating the program");
            return;
        }

        double carPriceIncludingVAT = Double.parseDouble(args[0]);
        int downPaymentSize = Integer.parseInt(args[1]);

        System.out.println("Car price including VAT: " + carPriceIncludingVAT + " EUR");
        System.out.println("Down payment size: " + downPaymentSize + "%");

        boolean isCarPriceIncludingVATValid = isCarPriceIncludingVATValid(carPriceIncludingVAT);
        boolean isDownPaymentSize = isDownPaymentSizeValid(downPaymentSize);
        if (!isCarPriceIncludingVATValid || !isDownPaymentSize) {
            System.out.println("Leasing parameters are invalid");
        } else {
            System.out.println("Leasing parameters are valid");

            System.out.println();

            double downPayment = calculateDownPayment(carPriceIncludingVAT, downPaymentSize);
            System.out.println("Down payment: " + downPayment + "  EUR");

            double loanSize = calculateLoanSize(carPriceIncludingVAT, downPayment);
            System.out.println("Loan size: " + loanSize + "EUR");

            System.out.println();

            System.out.println("Agreement fee: " + AGREEMENT_FEE + "  EUR");

            double initialInstallment = calculateInitialInstallment(downPayment);
            System.out.println("Initial installment: " + initialInstallment + "  EUR");
        }
    }

    private static boolean isAgumentDataTypesValid(String carPriceIncludingVATString, String downPaymentSizeString) {
        boolean isDataTypesValid = true;
        try {
            Double.parseDouble(carPriceIncludingVATString);
        } catch (NumberFormatException exception) {
            System.out.println("Car price including VAT is not valid " + exception.getMessage());
            isDataTypesValid = false;
        }

        try {
            Integer.parseInt(downPaymentSizeString);
        } catch (NumberFormatException exception) {
            System.out.println("Down payment size is not valid " + exception.getMessage());
            isDataTypesValid = false;
        }
        return isDataTypesValid;
    }

    private static boolean isCarPriceIncludingVATValid(double carPriceIncludingVAT) {
        boolean isValid = true;
        if (carPriceIncludingVAT < 0) {
            System.out.println("Car price " + carPriceIncludingVAT + " is invalid: it cannot be negative");
            isValid = false;
        } else if (carPriceIncludingVAT == 0) {
            System.out.println("Car price " + carPriceIncludingVAT + " is invalid: it cannot be zero");
            isValid = false;
        }
        return isValid;
    }

    private static boolean isDownPaymentSizeValid(int downPaymentSize) {
        boolean isValid = true;
        if (downPaymentSize <= 0 || downPaymentSize >= 100) {
            System.out.println("Down payment size " + downPaymentSize + " is invalid: it must be between 0 and 100");
        }
        return isValid;
    }

    private static double calculateInitialInstallment(double downPayment) {
        return AGREEMENT_FEE + downPayment;
    }

    private static double calculateLoanSize(double carPriceIncludingVAT, double downPayment) {
        return carPriceIncludingVAT - downPayment;
    }


    private static double calculateDownPayment(double carPriceIncludingVAT, int downPaymentSize) {
        return carPriceIncludingVAT * downPaymentSize / 100;
    }
}