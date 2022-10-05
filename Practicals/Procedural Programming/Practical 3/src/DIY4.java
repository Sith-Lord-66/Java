import java.util.Scanner;

public class DIY4 {

    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);

        System.out.println("Please enter what number the month is: ");
        int month = inp.nextInt();

        inp.close();

        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            System.out.println("There are 31 days in that month");
        }
        else if (month == 4 || month == 6 || month == 9 || month == 11) {
            System.out.println("There are 30 days in that month");
        }
        else if (month == 2) {
            System.out.println(" There are 28 days in a common year and 29 days on a leap year in this month");
        }
        else {
            System.out.println("Invalid Input");
            inp.close();
        }
    }
}
