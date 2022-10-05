package part01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * An Application class executing a menu to manage warehouse and product classes
 *
 * @author James Ross - 40328644
 *
 */
public class WarehouseApp {

    //Declare static variables
    private static final String title = "Warehouse";
    private static final String[] options ={"Add A Product", "Delete A Product",
            "List Products For Department", "List All Products", "Add Stock To Item",
            "Sales Report", "Record Purchase","Exit"};
    public static final String INPUT = "---->";

    //Declare objects used
    public static Warehouse ware = new Warehouse("Tesco");
    public static Scanner input = new Scanner(System.in);


    /**
     * This method runs the menu.java class and then prints the options available
     * @param args main method
     */
    public static void main(String[] args) {
        //calls a method to add products to the warehouse
        addWarehouse();

        //creates a menu object
        Menu menu = new Menu(title,options);
        int choice;
        do {
            //gets the user choice by calling a menu method
            choice = menu.getUserChoice();
            //checks that user choice is valid
            if (choice >8 || choice<1) System.out.print("Invalid menu option - try again!\n");
            //calls a method to run the selected function
            process(choice);
        }while (true);
    }

    /**
     * This method runs a switch that calls methods based on user selection
     * @param choice the int value the user entered
     */
    public static void process(int choice){
        //switch statement to call functions
        switch (choice) {
            case 1 -> addProduct();
            case 2 -> removeProduct();
            case 3 -> listProductDept();
            case 4 -> listProduct();
            case 5 -> addStockToProduct();
            case 6 -> salesReport();
            case 7 -> recordPurchases();
            case 8 -> exit();
            default -> {
            }
        }
    }

    /**
     * This method adds a product to the warehouse
     */
    public static void addProduct(){
        do {
            String title = "Add A Product";
            //Prints the Option name and asks user to enter make
            System.out.print("\n" + title + "\n" + plus(title) + "\n\nPlease enter the make:\n" + INPUT);
            //calls a method to gather user input
            String make = getLine();

            //prompts the user to enter model
            System.out.print("\nPlease enter the model:\n" + INPUT);
            //calls a method to gather user input
            String model = getLine();

            double price;
            do {
                //prompts the user to enter price
                System.out.print("\nPlease enter the price of the product:\n" + INPUT);
                //Calls a method to gather a user entered double
                price = getDouble();
                //validation to ensure value is acceptable
                if (price <= 0) System.out.print("\nPlease enter a price above £0");
            } while (price <= 0);

            String dept;
            Department department;
            input.nextLine();
            label:
            do {
                //Prompts the user to enter a department
                System.out.print("\nPlease Enter a Department from the following:" +
                        "\nElectrical\nPhotographic\nComputing\nBooks\nMusic\nFashion\nOther\n" + INPUT);
                dept = getLine();

                //switch converts input into a Department type
                switch (dept) {
                    case "Electrical":
                        department = Department.ELECTRICAL;
                        break label;
                    case "Photographic":
                        department = Department.PHOTOGRAPHIC;
                        break label;
                    case "Computing":
                        department = Department.COMPUTING;
                        break label;
                    case "Books":
                        department = Department.BOOKS;
                        break label;
                    case "Music":
                        department = Department.MUSIC;
                        break label;
                    case "Fashion":
                        department = Department.FASHION;
                        break label;
                    case "Other":
                        department = Department.OTHER;
                        break label;
                    default:
                        System.out.print("\nNot a valid department");
                        break;
                }
            } while (true);

            System.out.print("\nEntering Quantity - Optional");
            //asks the user if they wish to enter a quantity
            if (changeValue()) {
                int quantity;
                do {
                    //Prompts user to enter quantity
                    System.out.print("\nPlease enter a quantity:\n" + INPUT);
                    //calls a method to gather user entered int
                    quantity = getInt();
                    //validation to check entered value is acceptable
                    if (quantity <= 0) System.out.print("\nPleas enter a quantity greater than 0");
                } while (quantity <= 0);
                //adds a product with quantity to the warehouse and prints it out
                if (ware.addProduct(make, model, price, department, quantity).equals("OK")) {
                    System.out.print("\nProduct has been successfully added\n\n");
                    System.out.print(ware.search(make,model));
                } else System.out.print("\nAn Error has occurred and the product was not added please try again");
            } else {
                //adds a product to the warehouse and prints it out
                if (ware.addProduct(make, model, price, department).equals("OK")) {
                    System.out.print("\nProduct has been successfully added\n");
                    System.out.print(ware.search(make,model));
                } else System.out.print("\nAn Error has occurred and the product was not added please try again");
            }
            System.out.print("\n\nAdd Another Product?");
            //asks if user wishes to add another product
            if (changeValue()){
                input.nextLine();
            } else break;
        } while (true);
        System.out.println();
        input.nextLine();
    }

    /**
     * This method removes a product from the warehouse
     */
    public static void removeProduct(){
        do {
            String title = "Remove A Product";
            //prints the option name
            System.out.print("\n" + title + "\n" + plus(title) + "\n\n");
            //calls a method to get the code from user
            Product product = getProduct();
            //prints the product selected
            System.out.print("\nSelected Product:\n" + product);
            //asks user if they wish to continue
            if (changeValue()) {
                //deletes the product from warehouse by calling a method from warehouse
                if (ware.deleteProduct(product.getCode())) {
                    System.out.print("\nThe product has successfully been removed");
                } else System.out.print("\nAn Error has occurred and the product was not deleted please try again");
            }
            System.out.print("\n\nRemove Another Product?");
            //asks the user if they wish to remove another product
            if (changeValue()){
                input.nextLine();
            } else break;
        } while (true);

        System.out.println();
        input.nextLine();
    }

    /**
     * This method lists all the products in a certain department
     */
    public static void listProductDept(){
       do {
           String title = "List Products For Department";
           //Prints option name and asks user for input
           System.out.print("\n" + title + "\n" + plus(title) + "\n\nPlease Enter a Department from the following:\n" +
                   "1. Electrical\n2. Photographic\n3. Computing\n4. Books\n5. Music\n6. Fashion\n7. Other\n" + INPUT);
           int dept;
           do {
               //calls a method to gather a user entered int
               dept = getInt();
               //validation to ensure value is acceptable
               if (dept < 0 || dept >= 8)
                   System.out.print("That is not a valid choice please enter a number between 1-7\n" + INPUT);
           } while (dept < 0 || dept >= 8);

           //Creates an Arraylist of products
           ArrayList<Product> department = new ArrayList<>();
           //switch statement that if int matches a certain number it will search warehouse by dept
           //then print out dept name
           if(ware.toString().equals("\nNo Products in Warehouse")) System.out.print(ware);
           else {
               switch (dept) {
                   case 1 -> {
                       department = ware.search(Department.ELECTRICAL);
                       System.out.print("\n'Electrical'");
                   }
                   case 2 -> {
                       department = ware.search(Department.PHOTOGRAPHIC);
                       System.out.print("\n'Photographic'");
                   }
                   case 3 -> {
                       department = ware.search(Department.COMPUTING);
                       System.out.print("'\nComputing'");
                   }
                   case 4 -> {
                       department = ware.search(Department.BOOKS);
                       System.out.print("\n'Books'");
                   }
                   case 5 -> {
                       department = ware.search(Department.MUSIC);
                       System.out.print("\n'Music'");
                   }
                   case 6 -> {
                       department = ware.search(Department.FASHION);
                       System.out.print("\n'Fashion'");
                   }
                   case 7 -> {
                       department = ware.search(Department.OTHER);
                       System.out.print("\n'Other'");
                   }
                   default -> {
                   }
               }
                //prints each product that is in the ArrayList department
               for (Product prod : department) {
                   System.out.print("\n" + prod);
               }
           }
           System.out.print("\n\nSearch By Another Department?");
           //asks the user if they wish to search by another department
           if (changeValue()){
               input.nextLine();
           } else break;
       } while (true);

       System.out.println();
       input.nextLine();
    }

    /**
     * This method lists all products that are in the warehouse
     */
    public static void listProduct(){
        do {
            //Prints out all products
            String title = "List All Products";
            System.out.print("\n" + title + "\n" + plus(title));
            System.out.println(ware);
            System.out.print("\n\nReturn To Menu?");
        }while (!changeValue());
        System.out.println();
        input.nextLine();
    }

    /**
     * This method adds stock to a product
     */
    public static void addStockToProduct(){
       do {
           String title = "Add Stock To A Product";
           //prints option title
           System.out.print(title + "\n" + plus(title) + "\n\n");
           //calls a method to get user entered code
           Product product = getProduct();
           //prints the selected product
           System.out.print("\nSelected Product:\n" + product);
           //asks the user if they wish to continue
           if (changeValue()) {
               int quantity;
               do {
                   System.out.print("\nPlease enter the quantity you would like to add to the product\n" + INPUT);
                   //prompts the user to enter an int
                   quantity = getInt();
                   //validation to check it is acceptable
                   if (quantity <= 0) System.out.print("\nPleas enter a quantity greater than 0");
               } while (quantity <= 0);
               //adds the quantity and prints new quantity
               if (ware.restock(product.getCode(), quantity)) {
                   System.out.print("\nThe quantity has successfully been added to the product" +
                           "\nThe new quantity is: " + product.getQuantity());
               } else System.out.print("\nAn Error has occurred and the quantity was not added please try again");
           }
           System.out.print("\n\nAdd Stock To Another Product?");
           //asks the user if they wish to enter a new quantity
           if (changeValue()){
               input.nextLine();
           } else break;
       } while (true);

       System.out.println();
       input.nextLine();
    }

    /**
     * This method prints the products in order of no of products
     */
    public static void salesReport(){
        do {
            String title = "Sales Report";
            //prints option name
            System.out.print("\n" + title + "\n" + plus(title) + "\n");
            if(ware.toString().equals("\nNo Products in Warehouse")) System.out.print(ware);
            else {
                //creates an array of products
                Product[] sortData = ware.getAllProducts();
                int swaps;
                //sorts the array by No. of purchases
                do {
                    swaps = 0;
                    for (int index = 0; index < sortData.length - 1; index++) {
                        if (comparePurchase(sortData, index) < comparePurchase(sortData, index + 1)) {
                            Product temp = sortData[index];
                            sortData[index] = sortData[index + 1];
                            sortData[index + 1] = temp;
                            swaps++;
                        }
                    }
                } while (swaps > 0);

                //prints each product in the array
                for (Product prod : sortData) {
                    System.out.print("\n" + prod);
                }
            }
            System.out.print("\n\nReturn To Menu?");
            //asks the user if they wish to return to menu
        }while (!changeValue());
        System.out.println();
        input.nextLine();
    }

    /**
     * This method records a number of purchases made
     */
    public static void recordPurchases(){
        do {
            String title = "Record Purchases";
            //prints the option name
            System.out.print("\n" + title + "\n" + plus(title) + "\n\n");
            //calls a method to get a user entered int
            Product product = getProduct();
            //prints the product selected
            System.out.print("\nSelected Product:\n" + product);
            //asks the user if they wish to continue
            if (changeValue()) {
                int quantity;
                do {
                    System.out.print("\nPlease enter the number of purchases made:\n" + INPUT);
                    //calls a method to get a user entered int
                    quantity = getInt();
                    if (quantity > product.getQuantity()) System.out.print("\nNot enough products to make purchase");
                } while (quantity <= 0 || quantity > product.getQuantity());

                boolean purchases = false;
                //adds the no of purchases
                for (int count = 0; count < quantity; count++) {
                    purchases = product.recordPurchase();

                }
                if (purchases) {
                    System.out.print("\nThe product has been successfully purchased" +
                            "\nThe new quantity is: " + product.getQuantity());
                } else {
                    System.out.print("\nThis item is out of stock and the purchase could not be made");
                }
            }
            System.out.print("\n\nRecord Another Purchase?");
            //asks the user if they wish to record another purchase
            if (changeValue()){
                input.nextLine();
            } else break;
        } while (true);

        System.out.println();
        input.nextLine();
    }

    /**
     * This method adds products to warehouse
     */
    public static void addWarehouse(){
        ware.addProduct("Dell","XPS13",999,Department.COMPUTING,10);
        ware.addProduct("Harry Potter","Chamber Of Secrets",9.99,Department.BOOKS);
        ware.addProduct("SuperDry","T-Shirt",15,Department.FASHION,20);
        ware.addProduct("TechRUs","4-Way Adapter",5.99,Department.ELECTRICAL,2);
        ware.addProduct("CocaCola","Diet Coke",1.95,Department.OTHER);
        ware.addProduct("Sony","HDMI Cable",4,Department.ELECTRICAL,4);
        ware.addProduct("Cannon","Camera",300,Department.PHOTOGRAPHIC,30);
        ware.addProduct("HP","Spectre",1999.99,Department.COMPUTING);
        ware.addProduct("Star Wars","Tarkin",12,Department.BOOKS,1);
        ware.addProduct("Cadbury","Dairy Milk",0.65,Department.OTHER,6);
        ware.addProduct("Jeans","Next",22,Department.FASHION,12);
        ware.addProduct("LG","Lenses",10,Department.PHOTOGRAPHIC,100);
        ware.addProduct("Sony","HTRT3",10,Department.MUSIC);
        ware.addProduct("Samsung","Soundbar",10,Department.MUSIC,5);

    }

    /**
     * This method is used to sort the products in the salesReport method
     * @param getPurchase the array of purchases
     * @param index the index of array
     * @return the no of purchases
     */
    public static int comparePurchase(Product[] getPurchase, int index){
        return getPurchase[index].getPurchases();
    }

    /**
     * This method prompts the user to enter if this wish to continue or go back
     * @return Boolean value where true is continue and false is go back
     */
    public static boolean changeValue() {
        //Prompts the user to enter either A or B with validation
        System.out.print("\n\nWould you like to continue? Y-Yes, N-No\n" + INPUT);
        while (!input.hasNext("[YNyn]")) {
            input.next();
            System.out.print("That is not a valid choice please enter Y or N\n" + INPUT);
        }
        String choice = input.next();
        return choice.equals("Y");
    }

    /**
     * This method prompts the user to enter an integer number
     * Uses validation to confirm the entry is of type int
     * @return The integer number entered
     */
    public static int getInt() {
        //Prompts the user to enter an integer with validation
        while (!input.hasNextInt()) {
            input.next();
            System.out.print("That is not a valid choice please enter a number\n" + INPUT);
        }
        return input.nextInt();
    }

    /**
     * This method prompts the user to enter a double number
     * Uses validation to confirm the entry is of type double
     * @return The double number entered
     */
    public static double getDouble() {
        //Prompts the user to enter a double with validation
        while (!input.hasNextDouble()) {
            input.next();
            System.out.print("That is not a valid choice please enter a number\n" + INPUT);
        }
        return input.nextDouble();
    }

    /**
     * This method prompts the user to enter a String
     * Uses validation to confirm the entry is of type String
     * @return The String entered
     */
    public static String getLine() {
        //Prompts the user to enter a String with validation
        while (!input.hasNextLine()) {
            input.next();
            System.out.print("That is not a valid choice\n" + INPUT);
        }
        return input.nextLine();
    }

    /**
     * This method prompts the user to enter a product code and finds the selected product
     * @return the specified product
     */
    public static Product getProduct(){
        System.out.print("Please Enter the Product Code:\n"+INPUT);
        String code;
        Product product;
        do {
            code = getLine();
            product = ware.search(code);
            if(product == null){
                System.out.print("\nA product with that code does not exist, Or the code is invalid"+
                        "\nPlease enter a valid code:\n" + INPUT);
            }else return product;
        }while(true);
    }

    /**
     * creates a string of pluses for display under titles
     * @param word the string title
     * @return the string of pluses
     */
    public static String plus(String word){
        String result = "";
        for(int count = 1; count<=word.length(); count++){
            result += "+";
        }
        return result;
    }

    /**
     * This method ends the program
     */
    public static void exit(){
        String title = "Exit The System";
        System.out.print("\n" + title + "\n" + plus(title));
        if(changeValue()) {
            System.exit(0);
        }
        System.out.println();
    }


}
