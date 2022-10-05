package Pets;

import java.util.Scanner;

public class DogTester {
    // create a constant value called MAX
    static final int MAX = 10;

    // Define a constant PROMPT
    static final String PROMPT = "---->";

    // Define a constant SPACES
    static final String SPACES = "     ";

    // String array of menu options
    static final String[] options = {"Add new Dog", "Display details for a Dog",
            "Update details for a Dog", "List all Dogs", "Delete all Dogs",
            "Delete one Dog", "Quit"};

    // Define a constant QUIT
    static final int QUIT = options.length;

    // Create an array capable of managing up to MAX Dog instances
    static Dog[] pets = new Dog[MAX];

    static int count = 0; // 0 to start with

    // A menu title
    static String title = "Dog Manager";

    // Define a menu using title & options
    static Menu myMenu = new Menu(title, options);

    // Define a Scanner
    static Scanner input = new Scanner(System.in);

    // Define a value 'count' to indicate number of objects in array
    public static void main(String[] args) {
        int choice;
        do {
            myMenu.display();
            choice = myMenu.getChoice();
            if (choice != QUIT) {
                processChoice(choice);
            }
        }
        while( choice != QUIT );
        System.out.println("\nGoodbye!");
        input.close();
    }
    private static void processChoice(int choice) {
        switch(choice) {
            case 1 : addNewDog();
                break;
            case 2 : displayDogDetails();
                break;
            case 3 : updateDogDetails();
                break;
            case 4 : listAllDogs();
                break;
            case 5 : deleteAllDogs();
                break;
            case 6 : deleteOneDog();
                break;

            default: System.out.println("Option "+choice+" is invalid.");
        }
        System.out.println();
    }
    private static void addNewDog() {
        // check to see if enough space available in the array
        if ( count < MAX ) {
            System.out.println("\nOK - Add a new Dog.");
            // get info for a dog
            Dog dg = new Dog();
            System.out.print(PROMPT + "Enter name: ");
            String name = input.nextLine();
            dg.setName(name);
            System.out.print(PROMPT + "Enter breed: ");
            String breed = input.nextLine();
            dg.setBreed(breed);
            System.out.print(PROMPT + "Enter age: ");
            int age = input.nextInt();
            dg.setAge(age);

            input.nextLine(); // IMPORTANT !!!
            // after reading an integer ...
            // use input.nextLine() to clear input before
            // next string is read!

            System.out.print(PROMPT + "Enter gender (M for Male F for Female): ");
            String gen = input.nextLine();
            dg.setGender(gen.charAt(0));

            // add object to the array
            pets[count] = dg;
            // increment count
            count++;
        }
        else {
            System.out.println("No room to add and more dogs!");
        }
    }

    private static void listAllDogs() {
        System.out.println("\nOK - List all dogs.");
        if (count == 0) {
            System.out.println(PROMPT+"Sorry, there are no dogs.");
        }
        else {
            System.out.println("We have the following Dogs:");
            for(int index=0; index<count;index++) {
                System.out.println(SPACES+(index+1)+". " + pets[index].getName());
            }
        }
        System.out.println();
    }
    public static void displayDogDetails() {
        int numberOfPets = 0;
        System.out.println("We have the following Dogs:");
        for(int index=0; index<count;index++) {
            System.out.println(SPACES+(index+1)+". " + pets[index].getName());
            numberOfPets += 1;
            }
        System.out.print("Please enter a number: ");
        int choice = input.nextInt();
        if (choice <= numberOfPets){
            System.out.println(pets[choice-1].toString());
        }
        else{
            System.out.println("Not a valid number");
        }
    }
    public static void updateDogDetails(){
        int numberOfPets = 0;
        System.out.println("We have the following Dogs:");
        for(int index=0; index<count;index++) {
            System.out.println(SPACES+(index+1)+". " + pets[index].getName());
            numberOfPets += 1;
        }
        System.out.print("Please enter a number: ");
        int choice = input.nextInt();
        if (choice <= numberOfPets){
            choice-=1;

            input.nextLine();
            System.out.print(PROMPT + "Enter name: ");
            String name = input.nextLine();
            pets[choice].setName(name);
            System.out.print(PROMPT + "Enter breed: ");
            String breed = input.nextLine();
            pets[choice].setBreed(breed);
            System.out.print(PROMPT + "Enter age: ");
            int age = input.nextInt();
            pets[choice].setAge(age);

            input.nextLine(); // IMPORTANT !!!
            // after reading an integer ...
            // use input.nextLine() to clear input before
            // next string is read!

            System.out.print(PROMPT + "Enter gender (M for Male F for Female): ");
            String gen = input.nextLine();
            pets[choice].setGender(gen.charAt(0));
        }
        else{
            System.out.println("Not a valid number");
        }
    }
    public static void deleteAllDogs(){
        System.out.println("Would you like to delete all dogs? Yes or No");
        String choice = input.nextLine();
        if (choice.equals("Yes")) {
            pets = new Dog[MAX];
            count = 0;
            System.out.println("Dogs deleted");
        }
        else{
            System.out.println("No Dogs deleted");
        }
    }
    public static void deleteOneDog(){
        System.out.println("Would you like to delete all dogs? Yes or No");
        String choice = input.nextLine();
        if (choice.equals("Yes")) {
            System.out.print("Please enter a number: ");
            int number = input.nextInt();
            int index = number -1;
            for (int i = index; i < pets.length - 1; i++) {
                pets[i] = pets[i + 1];
            }
            count -= 1;
            System.out.println("Dogs deleted");
        }
        else{
            System.out.println("No Dogs deleted");
        }
    }

}
