import java.util.Scanner;

public class DIY3 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the number of items: ");
        int items = input.nextInt();

        System.out.println("How long does it take to heat one item in mins: ");
        float time = input.nextFloat();

        input.close();

        switch (items) {
            case (1): System.out.printf("\nThe heating time is: %.2f", time); break;
            case (2): System.out.printf("\nThe heating time is: %.2f", (time * 1.5)); break;
            case (3): System.out.printf("\nThe heating time is: %.2f", (time * 2)); break;
            default: System.out.println("We do not recommend heating this many items"); break;
        }

    }
}
