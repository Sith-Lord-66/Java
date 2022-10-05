public class CalcVat {

    public static void main(String[] args) {

        // declare the VAT rate as a final
        final double VATRATE = 20;
        // declare the purchase price
        double price = 70;
        // declare a variable to hold the VAT to be paid double vat;
        double vatPrice;

        //Do the calculation
        vatPrice = price/100 * VATRATE;
        // output the answer
        System.out.printf("The VAT price is £%.2f", vatPrice);
    }
}
