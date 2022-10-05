import java.util.Scanner;

public class CalcVat2 {

    public static void main(String[] args) {

        // declare the VAT rate as a final
        final double VATRATE = 20;
        // declare the purchase price
        double price;
        // declare a variable to hold the VAT to be paid double vat;
        double vatPrice;

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the cost of this purchase: ");
        price = input.nextDouble();
        input.close();


        //Do the calculation
        vatPrice = price * VATRATE/100;
        // output the answer
        System.out.printf("The VAT price is £%.2f", vatPrice);
    }
}


