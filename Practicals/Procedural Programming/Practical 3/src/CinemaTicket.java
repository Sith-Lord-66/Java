import java.util.Scanner;

public class CinemaTicket {

    public static void main(String[] args) {

        final double CHILD_TICKET = 4.00;
        final double STUDENT_TICKET = 6.00;
        final double ADULT_TICKET = 8.00;
        final double MATINEE_DISCOUNT = 2.00;
        double ticketPrice;

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter your age: ");
        int age = input.nextInt();

        System.out.println("Please enter 'y' if you are a student and 'n' if you are not: ");
        String student = input.next();

        System.out.println("Please enter the time your movie is at in 24 hour time: ");
        int time = input.nextInt();

        input.close();

        if (age < 16) {
            ticketPrice = CHILD_TICKET;
        }
        else if (student.equals("y")) {
            ticketPrice = STUDENT_TICKET;
        }
        else {
            ticketPrice = ADULT_TICKET;
        }

        if (time < 1700) {
            ticketPrice = ticketPrice - MATINEE_DISCOUNT;
        }

        System.out.printf("Your ticket price is: %.2f", ticketPrice);

    }
}
