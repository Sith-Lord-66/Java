package Shop;

import java.util.Scanner;

public class TestRegister {
    public static void main(String[] args) {
        SalesRegister Sales = new SalesRegister();

        String title = "\nSales Register";
        String[] items = {"Cash Sales", "Card Sales", "Display Transactions", "Quit"};

        Scanner inputChoice = new Scanner(System.in);
        Scanner inputItem = new Scanner(System.in);
        Scanner inputPrice = new Scanner(System.in);

        int choice = 0;

        while (choice != 4){
            Display(title,items);
            choice = getUserChoice(inputChoice);


            if (choice == 1) {
                System.out.print("Enter item: ");
                while (!inputItem.hasNextLine()) {
                    inputItem.next();
                    System.out.print("Sorry, please enter a String");
                }
                String item = inputItem.nextLine();

                System.out.print("Enter item price: ");
                while (!inputPrice.hasNextDouble()) {
                    inputPrice.next();
                    System.out.print("Sorry, please enter a numeric value e.g. 1,2,3 etc: ");
                }
                double price = inputPrice.nextDouble();
                Sales.cashSale(item, price);
            }
            else if (choice == 2){
                System.out.print("Enter item: ");
                while (!inputItem.hasNextLine()) {
                    inputItem.next();
                    System.out.print("Sorry, please enter a String");
                }
                String item = inputItem.nextLine();

                System.out.print("Enter item price: ");
                while (!inputPrice.hasNextDouble()) {
                    inputPrice.next();
                    System.out.print("Sorry, please enter a numeric value e.g. 1,2,3 etc: ");
                }
                double price = inputPrice.nextDouble();
                Sales.cardSale(item, price);
            }
            else if (choice == 3){
                System.out.println("Total Sales Value:\t" + Sales.getTotalValue());
                System.out.println("Total Cash Sales:\t" + Sales.getNumCashSales());
                System.out.println("Total Card Sales:\t" + Sales.getNumCardSales());
                System.out.println("\n" + Sales.listTransactions());
            }
            else if (choice == 4){
                System.out.println("Finished - Goodbye!");
            }
        }
    }
    public static void Display(String title,String[] items){
        System.out.println(title);
        for (int i = 0; i < title.length(); i++) {
            System.out.print("+");
        }
        System.out.println();
        for (int opt = 1; opt <= items.length; opt++) {
            System.out.println(opt + ". " + items[opt-1]);
        }
        System.out.println();
    }
    public static int getUserChoice(Scanner input) {
        System.out.print("Enter Selection: ");
        boolean condition = true;
        int num = 0;

        while(condition) {
            while (!input.hasNextInt()) {
                input.next();
                System.out.print("Sorry, please enter a numeric value e.g. 1,2,3 etc: ");
            }
            num = input.nextInt();
            if (num<5 && num>0) {
                condition = false;
            }
        }
        return num;
    }
}
