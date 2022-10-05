import java.util.Scanner;

public class DIY11 {

    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);

        System.out.println("Please enter price in £");
        double price = inp.nextDouble();

        System.out.println("Please enter money input in £");
        double cust = inp.nextDouble();

        double change = cust - price;
        change = change * 100;

        double pound = change / 100;
        int intpound = (int)pound;
        change = change - (intpound*100);

        double fifty = change / 50;
        int intfifty = (int)fifty;
        change = change - (intfifty*50);

        double twenty = change / 20;
        int inttwenty = (int)twenty;
        change = change - (inttwenty*20);

        double ten = change / 10;
        int intten = (int)ten;
        change = change - (intten*10);

        double five = change / 5;
        int intfive = (int)five;
        change = change - (intfive*5);

        System.out.println("Your change is :");
        System.out.printf("\nPounds: %d", intpound);
        System.out.printf("\nFifty Pences: %d", intfifty);
        System.out.printf("\nTwenty Pences: %d", inttwenty);
        System.out.printf("\nTen Pences: %d", intten);
        System.out.printf("\nFive Pences: %d", intfive);
    }
}
