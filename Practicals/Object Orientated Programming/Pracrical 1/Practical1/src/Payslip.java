import java.util.Scanner;

public class Payslip {

    public static void main(String[] args) {
        // Create a Scanner for KB input
        Scanner input = new Scanner(System.in);
        String data = ""; // used to hold output
        double gross;  // used to hold an input value
        final double TAX_RATE = 0.2;  // constant for tax rate
        double net,tax;   // used to calculate tax & net pay

        // loop to process a number of gross wage payments
        // tax at 20% is calculated
        // gross wage, tax paid and net wage is displayed for each entry
        // a gross wage of 0 or less will halt the program

        // Add headings
        data = data + "Gross\t\tTax\t\tNet\n";
        data = data + "=====\t\t===\t\t===\n";

        do {
            System.out.print("Enter gross pay: ");
            gross = input.nextDouble();   // read a double

            if ( gross > 0) {
                tax = gross * TAX_RATE;
                net = gross - tax;
                data = data + gross + "\t\t" + tax + "\t\t" + net + "\n";
            }
        }
        while(gross > 0);

        System.out.println(data); // display results
        input.close();  // close the Scanner
    }
}
