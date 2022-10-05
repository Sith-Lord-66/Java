import java.util.Scanner;

public class CharityMovie {

    public static void main(String [] args) {

        String movieName, outputStr;
        double adultTicketPrice, childTicketPrice;
        int noOfAdultTicketsSold, noOfChildTicketsSold;
        double percentageDonation, grossAmount, amountDonated, netSaleAmount;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the movie name: ");
        movieName = input.nextLine();
        System.out.println("Enter the price of an adult ticket: ");
        adultTicketPrice = input.nextDouble();
        System.out.println("Enter the price of an child ticket: ");
        childTicketPrice = input.nextDouble();
        System.out.println("Enter the number of adult tickets sold: ");
        noOfAdultTicketsSold = input.nextInt();
        System.out.println("Enter the number of child tickets sold: ");
        noOfChildTicketsSold = input.nextInt();
        System.out.println("Enter the percentage of the donation: ");
        percentageDonation = input.nextDouble();

        grossAmount  =  adultTicketPrice  *  noOfAdultTicketsSold  +  childTicketPrice  * noOfChildTicketsSold;
        amountDonated = grossAmount * percentageDonation / 100;
        netSaleAmount = grossAmount - amountDonated;

        outputStr = String.format("Movie Name: %s", movieName)
                + String.format("\nNumber of tickets sold: %d",(noOfAdultTicketsSold + noOfChildTicketsSold))
                + String.format("\nGross Amount: %.2f", grossAmount)
                + String.format("\nPercentage of the gross amount donated: %.2f%%", percentageDonation)
                + String.format("\nAmount Donated: %.2f", amountDonated)
                + String.format("\nNet Sales: %.2f", netSaleAmount);

        System.out.println("Cinema Sales Data\n\n" + outputStr);
        input.close();

        }
    }

