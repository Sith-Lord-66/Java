import java.util.Scanner;

public class Titanic {

    public static void main(String[] args) {

        double totalPrice = 0;
        int age1;
        int age2;
        int age3;
        int age4;


        Scanner input = new Scanner(System.in);

        System.out.println("Please provide the age of the first person: ");
        age1 = input.nextInt();

        System.out.println("Please provide the age of the second person: ");
        age2 = input.nextInt();

        System.out.println("Please provide the age of the third person: ");
        age3 = input.nextInt();

        System.out.println("Please provide the age of the fourth person: ");
        age4 = input.nextInt();

        input.close();

        totalPrice = totalPrice + Price(age1);
        totalPrice = totalPrice + Price(age2);
        totalPrice = totalPrice + Price(age3);
        totalPrice = totalPrice + Price(age4);

        System.out.printf("The total price is: %.2f", totalPrice);

    }

    public static double Price(int age) {

        final int ADULT_PRICE = 19;
        final double CHILD_PRICE = 8.5;
        final int UNDER_5 = 0;
        double price = 0;

        if (age > 18) {
            price = ADULT_PRICE;
        }
        else if (age > 5) {
            price = CHILD_PRICE;
        }
        else if (age < 0) {
            price = UNDER_5;
        }
        else {
            System.out.println("Invalid response");
        }

        return price;
    }
}
