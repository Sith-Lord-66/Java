import java.util.Scanner;

public class DIY2 {

    public static void main(String[] args) {

        //Asks for user input
        String name = askUser();

        //Prints a line of stars
        printStarLines(name);

        //Prints name
        System.out.print("\n* " + name + " *\n");

        //Prints a line of stars
        printStarLines(name);

    }

    //Prints a line of stars
    public static void printStarLines(String name) {

        int nameLength = name.length();

        //Prints a line the length of the name with two stars either side
        for (int count = 1; count <= nameLength + 4; count++) {
            System.out.print("*");
        }
    }

    //Asks user for input of type String
    public static String askUser() {

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your name: ");

        return input.nextLine();
    }
}
