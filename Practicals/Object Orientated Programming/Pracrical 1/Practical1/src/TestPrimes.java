import java.util.Scanner;

public class TestPrimes {

    public static void main(String[] args) {

        int userNumber = askUser();
        int prime = 1;
        int number = 3;

        if (userNumber >= 1) {
            System.out.println("First " + userNumber + " prime numbers are:");
            System.out.println(2);
        }

        for (int count = 2; count <= userNumber; ) {
            for (int primeCheck = 2; primeCheck <= Math.sqrt(number); primeCheck++) {
                if (number % primeCheck == 0) {
                    prime = 0;
                    break;
                }
            }
            if (prime != 0) {
                System.out.println(number);
                count++;
            }
            prime = 1;
            number++;
        }
    }

    public static int askUser() {

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a number: ");

        return input.nextInt();
    }
}
