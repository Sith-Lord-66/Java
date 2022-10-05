import java.util.Scanner;

public class FactorialTest {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int number = 0;

        System.out.println("Enter -1 to exit\n");
        while (number != -1){
            System.out.print("Please enter a value: ");
            number = input.nextInt();

            System.out.println(Factorial.calcFactorial(number));
        }
    }
}
