import java.util.Scanner;

public class DoItYourself1 {

    public static void main(String[] args) {

        System.out.println("Please enter two numbers: ");
        Scanner input = new Scanner(System.in);
        double number1 = input.nextDouble();
        double number2 = input.nextDouble();
        double finalNumber = number1 + number2;
        System.out.printf("\nThe sum is: %.2f", finalNumber);
    }
}
