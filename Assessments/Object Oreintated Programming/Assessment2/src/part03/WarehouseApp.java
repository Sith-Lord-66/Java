package part03;

import part01.Department;
import part01.Product;

import java.util.ArrayList;

/**
 * An Application class executing a menu to manage warehouse and product classes
 *
 * @author James Ross - 40328644
 *
 */
public class WarehouseApp {

    //Declare static variables
    private static final String title = "Warehouse Menu";
    private static final String[] options ={"Add A Product", "Delete A Product",
            "List Products For Department", "List All Products", "Add Stock To Item",
            "Sales Report", "Record Purchase","Exit"};
    public static final String INPUT = "---->";

    //Declare objects used
    public static WarehouseDetail ware = new WarehouseDetail("Warehouse");
    public static ConsoleMenu console = new ConsoleMenu(true,title,options);


    /**
     * This method runs the menu.java class and then prints the options available
     * @param args main method
     */
    public static void main(String[] args) {
        //calls a method to add products to the warehouse
        addWarehouse();

        int choice;
        do {
            //gets the user choice by calling a ConsoleMenu method
            choice = console.getUserChoice();
            //checks that user choice is valid
            if (choice >8 || choice<1) console.print("Invalid menu option - try again!\n");
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
    public static void addProduct() {
        do {
            //Prints the Option name
            console.clear();
            String title = "Add A Product";
            //Prints the Option name and asks user to enter make
            console.print(title + "\n" + plus(title) + "\n\nPlease enter the make:\n" + INPUT);
            //gathers user input
            String make = console.readLn();

            //prompts the user to enter model
            console.print("\nPlease enter the model:\n" + INPUT);
            //gathers user input
            String model = console.readLn();

            double price;
            do {
                //prompts the user to enter price
                console.print("\nPlease enter the price of the product:\n" + INPUT);
                //Calls a method to gather a user entered double
                price = getDouble();
                //validation to ensure value is acceptable
                if (price <= 0) console.print("\nPlease enter a price above £0");
            } while (price <= 0);

            String dept;
            Department department;
            label:
            do {
                //Prompts the user to enter a department
                console.print("\nPlease Enter a Department from the following:" +
                        "\nElectrical\nPhotographic\nComputing\nBooks\nMusic\nFashion\nOther\n" + INPUT);
                dept = console.readLn();

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
                        console.print("\nNot a valid department");
                        break;
                }
            } while (true);

            console.clear();
            boolean quant = false;
            boolean detail = false;
            int quantity = 0;
            console.print(title + "\n" + plus(title) + "\n\nEntering Quantity - Optional");
            //asks the user if they wish to enter a quantity
            if (changeValue()) {
                do {
                    //Prompts user to enter quantity
                    console.print("\nPlease enter a quantity:\n" + INPUT);
                    //calls a method to gather user entered int
                    quantity = getInt();
                    //validation to check entered value is acceptable
                    if (quantity <= 0) console.print("\nPleas enter a quantity greater than 0");
                } while (quantity <= 0);
                quant = true;
            }
            String desc = "";
            String image = "";
            console.print("\nEntering Description and Image - Optional");
            //asks the user if they wish to add a description and image
            if (changeValue()) {
                console.print("\nPlease enter a description:\n" + INPUT);
                //prompts user input
                desc = console.readLn();
                console.print("\nPlease enter the location of the image file e.g. Folder\\filename.jpg:\n" + INPUT);
                //prompts user input
                image = console.readLn();
                detail = true;
            }
            console.clear();
            //adds a product with quantity, desc and image to warehouse
            if (quant && detail) {
                if (ware.addProduct(make, model, price, department, quantity, desc, image).equals("OK")) {
                    console.print("Product has been successfully added");
                } else console.print("An Error has occurred and the product was not added please try again");
            }
            //adds a product with desc and image to warehouse
            else if (!quant && detail) {
                if (ware.addProduct(make, model, price, department, desc, image).equals("OK")) {
                    console.print("Product has been successfully added");
                } else console.print("An Error has occurred and the product was not added please try again");
            }
            //adds a product with quantity to warehouse
            else if (quant) {
                if (ware.addProduct(make, model, price, department, quantity).equals("OK")) {
                    console.print("Product has been successfully added");
                } else console.print("An Error has occurred and the product was not added please try again");
            } else {
                //adds a product to warehouse
                if (ware.addProduct(make, model, price, department).equals("OK")) {
                    console.print("Product has been successfully added");
                } else console.print("An Error has occurred and the product was not added please try again");
            }
            //prints the added object
            console.print("\n\n" + ware.search(make, model));
            //calls a method to print the image
            printImage(ware.search(make, model));

            console.print("\n\nAdd Another Product?");
            //asks if user wishes to add another product
            if (!changeValue()) {
                console.clear();
                break;
            }
        }while (true);
    }

    /**
     * This method removes a product from the warehouse
     */
    public static void removeProduct(){
        do {
            console.clear();
            String title = "Remove A Product";
            //prints the option name
            console.print(title + "\n" + plus(title) + "\n\n");
            //calls a method to get the code from user
            Product product = getProduct();
            //prints the product selected
            console.print("\nSelected Product:\n" + product);
            //Calls a method to print the image
            printImage(product);
            //asks user if they wish to continue
            if (changeValue()) {
                //deletes the product from warehouse by calling a method from warehouse
                if (ware.deleteProduct(product.getCode())) {
                    console.print("\nThe product has successfully been removed");
                } else console.print("\nAn Error has occurred and the product was not deleted please try again");
            }
            console.print("\n\nRemove Another Product?");
            //asks the user if they wish to remove another product
            if (!changeValue()) {
                console.clear();
                break;
            }
        }while (true);
    }

    /**
     * This method lists all the products in a certain department
     */
    public static void listProductDept(){
        do {
            console.clear();
            String title = "List Products For Department";
            //Prints option name and asks user for input
            console.print(title + "\n" + plus(title) +
                    "\n\nPlease Enter a Department from the following:\n" +
                    "1. Electrical\n2. Photographic\n3. Computing\n4. Books\n5. Music\n6. Fashion\n7. Other\n" + INPUT);
            int dept;
            do {
                //calls a method to gather a user entered int
                dept = getInt();
                //validation to ensure value is acceptable
                if (dept < 0 || dept >= 8)
                    console.print("That is not a valid choice please enter a number between 1-6\n" + INPUT);
            } while (dept < 0 || dept >= 8);

            //Creates an Arraylist of products
            ArrayList<Product> department = new ArrayList<>();
            //switch statement that if int matches a certain number it will search warehouse by dept
            //then print out dept name
            if(ware.toString().equals("\nNo Products in Warehouse")) console.print(ware);
            else {
                switch (dept) {
                    case 1 -> {
                        department = ware.search(Department.ELECTRICAL);
                        console.print("\n'Electrical'");
                    }
                    case 2 -> {
                        department = ware.search(Department.PHOTOGRAPHIC);
                        console.print("\n'Photographic'");
                    }
                    case 3 -> {
                        department = ware.search(Department.COMPUTING);
                        console.print("\n'Computing'");
                    }
                    case 4 -> {
                        department = ware.search(Department.BOOKS);
                        console.print("\n'Books'");
                    }
                    case 5 -> {
                        department = ware.search(Department.MUSIC);
                        console.print("\n'Music'");
                    }
                    case 6 -> {
                        department = ware.search(Department.FASHION);
                        console.print("\n'Fashion'");
                    }
                    case 7 -> {
                        department = ware.search(Department.OTHER);
                        console.print("\n'Other'");
                    }
                    default -> {
                    }
                }
                //prints each product that is in the ArrayList department
                for (Product prod : department) {
                    console.print("\n" + prod);
                    printImage(prod);
                }
            }
            console.print("\n\nSearch By Another Department?");
            //asks the user if they wish to search by another department
            if (!changeValue()) {
                console.clear();
                break;
            }
        }while (true);
    }

    /**
     * This method lists all products that are in the warehouse
     */
    public static void listProduct(){
        console.clear();
        String title = "List All Products";
        console.print(title + "\n" + plus(title));
        if(ware.toString().equals("\nNo Products in Warehouse")) console.print(ware);
        else {
            //Calls a method to print each department
            printDepartment(Department.ELECTRICAL);
            printDepartment(Department.PHOTOGRAPHIC);
            printDepartment(Department.COMPUTING);
            printDepartment(Department.BOOKS);
            printDepartment(Department.MUSIC);
            printDepartment(Department.FASHION);
            printDepartment(Department.OTHER);
        }
        do {
            console.print("\n\nReturn To Menu?");
            if (changeValue()) {
                console.clear();
                break;
            }
        }while (true);
    }

    /**
     * This method adds stock to a product
     */
    public static void addStockToProduct(){
        do {
            console.clear();
            String title = "Add Stock To A Product";
            //prints option title
            console.print(title + "\n" + plus(title) + "\n\n");
            //calls a method to get user entered code
            Product product = getProduct();
            //prints the selected product
            console.print("\n\nSelected Product:\n" + product);
            //Calls a method to print the image
            printImage(product);
            //asks the user if they wish to continue
            if (changeValue()) {
                int quantity;
                do {
                    console.print("\nPlease enter the quantity you would like to add to the product\n" + INPUT);
                    //prompts the user to enter an int
                    quantity = getInt();
                    //validation to check it is acceptable
                    if (quantity <= 0) console.print("\nPleas enter a quantity greater than 0");
                } while (quantity <= 0);
                //adds the quantity and prints new quantity
                if (ware.restock(product.getCode(), quantity)) {
                    console.print("\nThe quantity has successfully been added to the product" +
                            "\nThe new quantity is: " + product.getQuantity());
                } else console.print("\nAn Error has occurred and the quantity was not added please try again");
            }
            console.print("\n\nAdd Stock To Another Product?");
            //asks the user if they wish to enter a new quantity
            if (!changeValue()) {
                console.clear();
                break;
            }
        }while (true);
    }

    /**
     * This method prints the products in order of no of products
     */
    public static void salesReport(){
        console.clear();
        String title = "Sales Report";
        //prints option name
        console.print(title + "\n" + plus(title) + "\n");
        if(ware.toString().equals("\nNo Products in Warehouse")) console.print(ware);
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
                console.print("\n" + prod);
                printImage(prod);
            }
        }
        do {
            //asks the user if they wish to return to menu
            console.print("\n\nReturn To Menu?");
            if (changeValue()) {
                console.clear();
                break;
            }
        }while (true);
    }

    /**
     * This method records a number of purchases made
     */
    public static void recordPurchases() {
        do {
            console.clear();
            String title = "Record Purchases";
            //prints the option name
            console.print(title + "\n" + plus(title) + "\n\n");
            //calls a method to get a user entered int
            Product product = getProduct();
            //prints the product selected
            console.print("\nSelected Product:\n" + product);
            //calls the method to print images
            printImage(product);
            //asks the user if they wish to continue
            if (changeValue()) {
                int quantity;
                do {
                    console.print("\nPlease enter the number of purchases made:\n" + INPUT);
                    //calls a method to get a user entered int
                    quantity = getInt();
                    if (quantity > product.getQuantity()) console.print("\nNot enough products to make purchase");
                } while (quantity <= 0 || quantity > product.getQuantity());

                boolean purchase = false;
                //adds the no of purchases
                for (int count = 0; count < quantity; count++) {
                    purchase = product.recordPurchase();
                }
                if (purchase) {
                    console.print("\nThe product has been successfully purchased" +
                            "\nThe new quantity is: " + product.getQuantity());
                } else {
                    console.print("\nThis item is out of stock and the purchase could not be made");
                }
            }
            console.print("\n\nRecord Another Purchase?");
            //asks the user if they wish to record another purchase
            if (!changeValue()) {
                console.clear();
                break;
            }
        } while (true);
    }

    /**
     * This method adds products to warehouse
     */
    public static void addWarehouse(){
        ware.addProduct("Dell","XPS13",999,Department.COMPUTING,10,"fast","Images\\XPS13.jpg");
        ware.addProduct("Harry Potter","Chamber Of Secrets",9.99,Department.BOOKS,"Second Book","Images\\Chamber of secrets.jpg");
        ware.addProduct("SuperDry","T-Shirt",15,Department.FASHION,20);
        ware.addProduct("TechRUs","4-Way Adapter",5.99,Department.ELECTRICAL,2);
        ware.addProduct("CocaCola","Diet Coke",1.95,Department.OTHER,"Taste the feeling","Images\\dietcoke.jpg");
        ware.addProduct("Sony","HDMI Cable",4,Department.ELECTRICAL,4,"Connect to tv","Images\\HDMI.jpg");
        ware.addProduct("Cannon","Camera",300,Department.PHOTOGRAPHIC,30);
        ware.addProduct("HP","Spectre",1999.99,Department.COMPUTING);
        ware.addProduct("Star Wars","Tarkin",12,Department.BOOKS,1);
        ware.addProduct("Cadbury","Dairy Milk",0.65,Department.OTHER,6,"chocolate","Images\\dairy milk.jpg");
        ware.addProduct("Jeans","Next",22,Department.FASHION,12,"mens","Images\\jeans.jpg");
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
        String choice;
        console.print("\n\nWould you like to continue? Y-Yes, N-No\n" + INPUT);
        do {
            choice = console.readLn().toUpperCase();
            if(choice.equals("Y")||choice.equals("N")){
                break;
            }
            console.print("That is not a valid choice please enter Y or N\n" + INPUT);
        }while (true);
        return choice.equals("Y");
    }

    /**
     * This method prompts the user to enter an integer number
     * Uses validation to confirm the entry is of type int
     * @return The integer number entered
     */
    public static int getInt() {
        //Prompts the user to enter an integer with validation
        String value;
        int intValue;
        do {
            try {
                value = console.readLn();
                try {
                    intValue = Integer.parseInt(value);
                    break;
                } catch (NumberFormatException e) {
                    console.print("That is not a valid choice please enter a number\n" + INPUT);
                }
            }
            catch(Exception ex) {
                console.print("That is not a valid choice please enter a number\n" + INPUT);
            }
        } while (true);
        return intValue;
    }

    /**
     * This method prompts the user to enter a double number
     * Uses validation to confirm the entry is of type double
     * @return The double number entered
     */
    public static double getDouble() {
        //Prompts the user to enter a double with validation
        String value;
        double doubleValue;
        do {
            try {
                value = console.readLn();
                try {
                    doubleValue = Double.parseDouble(value);
                    break;
                } catch (NumberFormatException e) {
                    console.print("That is not a valid choice please enter a number\n" + INPUT);
                }
            }
            catch(Exception ex) {
                console.print("That is not a valid choice please enter a number\n" + INPUT);
            }
        } while (true);
        return doubleValue;
    }

    /**
     * This method prompts the user to enter a product code and finds the selected product
     * @return the specified product
     */
    public static Product getProduct(){
        console.print("Please Enter the Product Code:\n"+INPUT);
        String code;
        Product product;
        do {
            code = console.readLn();
            product = ware.search(code);
            if(product == null){
                console.print("\nA product with that code does not exist, Or the code is invalid"+
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
        console.clear();
        String title = "Exit The System";
        console.print(title + "\n" + plus(title));
        if(changeValue()) {
            System.exit(0);
        }else console.clear();
    }

    /**
     * This method prints an image for a product if present
     * @param prod the product
     */
    public static void printImage(Product prod){
        if(prod instanceof ProductDetail){
            console.print(((ProductDetail) prod).getImage());
        }
    }

    /**
     * This method prints all products for a specified department
     * @param dept the department specified
     */
    public static void printDepartment(Department dept){
        console.print("\n\n" + dept);
        ArrayList<Product> sorted  = ware.sortedProds(dept);
        for(Product prod: sorted){
            console.print("\n" + prod);
            printImage(prod);
        }
    }

}
