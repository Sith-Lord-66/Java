import java.util.Scanner;

public class DIY9 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Do you want to leave a tip? Enter y(yes) or n (no)");
        String choice = input.nextLine();
        double bill, tip;

        if (choice.equals("y")) {
            System.out.println("Please enter your bill total");
            bill = input.nextDouble();

            if (bill >= 20) {
                System.out.println("Your bill is more than or equal to £20. A 20% tip is appropriate");
                tip = bill * 0.2;
                System.out.printf("the tip is: %.2f", tip);
                bill = bill + tip;
                System.out.printf("\nYou total bill including tip is: £%.2f", bill);
            }
            else {
                System.out.println("Your bill under £20. A 10% tip is appropriate");
                tip = bill * 0.1;
                System.out.printf("the tip is: %.2f", tip);
                bill = bill + tip;
                System.out.printf("\nYour total bill including tip is: £%.2f", bill);
            }
        }
        else {
            System.out.println("You do not wish to calculate a tip");
        }
    }
}