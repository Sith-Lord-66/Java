import java.util.Scanner;

public class DIY6 {

        public static void main(String[] args) {

            Scanner inp = new Scanner(System.in);

            System.out.println("How many items do you wish to scan?");
            int numOfItems = inp.nextInt();

            double sumOfItems = 0;
            for (int count = 1; count <= numOfItems; count++){
                System.out.println("Please enter amount of item");
                double itemCost = inp.nextDouble();
                sumOfItems += itemCost;
            }

            double bill = sumOfItems;

            System.out.println("Does the customer have a loyalty card? Enter y for yes, n for no");
            String temp = inp.next();

            if (temp.equals("y")) {
                bill = bill *0.9;
            }

            System.out.println("Does the customer have a voucher they would like to use? Enter y for yes, n for no");
            temp = inp.next();

            if (temp.equals("y")) {
                System.out.println("Please enter 5 if they would like to use a £5 voucher or 10 if they would like to use a £10 voucher.");
                temp = inp.next();

                if (temp.equals("5")) {
                    bill = bill - 5;
                }
                else if (temp.equals("10")){
                    bill = bill - 10;
                }
            }

            System.out.printf("\nThe total bill including discounts is £%.2f", bill);

            inp.close();



        }
    }


