import java.util.Scanner;

public class DIY2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the first number: ");
        int numberOne = input.nextInt();

        System.out.println("Please enter the second number: ");
        int numberTwo = input.nextInt();

        System.out.println("Please enter the first number: ");
        int numberThree = input.nextInt();

        input.close();

        if (numberOne < numberTwo && numberThree > numberTwo) {
            System.out.println("Increasing");
        }
        else if (numberOne > numberTwo && numberThree < numberTwo) {
            System.out.println("Decreasing");
        }
        else {
            System.out.println("Neither");
        }

    }
}

