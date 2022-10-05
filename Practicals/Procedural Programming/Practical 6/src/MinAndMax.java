import java.util.Scanner;

public class MinAndMax {

    public static void main(String[] args) {

        int userInput;
        int min;
        int max;

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter an integer number: ");
        userInput = input.nextInt();
        min = userInput;
        max = userInput;

        for (int count = 1; count <10; count++) {

            System.out.println("Please enter an integer number: ");
            userInput = input.nextInt();

            if (userInput < min) min = userInput;
            else if (userInput > max) max = userInput;
        }

        System.out.print("\nMin: " + min + "\nMax: " + max);
    }
}
