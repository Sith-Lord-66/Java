public class Q1 {

    public static void main(String[] args) {

        String movieName;
        double adultTicketPrice;
        double childTicketPrice;

        movieName = "The Matrix";
        adultTicketPrice = 8.5;
        childTicketPrice = 6;
        int noOfAdultTicketsSold = 112;
        int noOfChildTicketsSold = 5;

        double grossAmount = adultTicketPrice * noOfAdultTicketsSold + childTicketPrice * noOfChildTicketsSold;

        double amountDonated = grossAmount * 0.11;

        if (grossAmount >= 1000) {
            amountDonated = grossAmount * 0.15;
        }

        double netSalesAmount = grossAmount - amountDonated;
        System.out.println("Movie Name: " + movieName + ", Net Sales: " + netSalesAmount);
    }
}
