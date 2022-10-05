package part03;

import console.Console;
import java.awt.*;

/**
 * An Object class defining a ConsoleMenu object that extends the Console class
 *
 * @author James Ross - 40328644
 *
 */
public class ConsoleMenu extends Console {

    //defining object attributes
    private String title;
    private String[] items;

    /**
     * The constructor for the ConsoleMenu object
     * @param editable the boolean value for if the user can input values
     * @param title the String title of the console
     * @param options the String[] options available in the console
     */
    public ConsoleMenu(boolean editable, String title, String[] options) {
        super(editable);
        this.title = title;
        items = options;
    }

    /**
     * This method initiates the Console window and prints options
     */
    public void display(){
        //sets size of console window
        setSize(1500,800);
        //sets console to visible
        setVisible(true);
        //sets background colour to black
        setBgColour(Color.BLACK);
        //sets font to comic sans
        setFont(new Font("Comic Sans MS",Font.BOLD,20));
        //sets colour of text to green
        setColour(Color.GREEN);
        //prints title of console
        println(title);

        //prints pluses that match in length to the title
        for (int i = 0; i < title.length(); i++) {
            print("+");
        }
        println();
        //prints each option with a number in front
        for (int opt = 1; opt <= items.length; opt++) {
            println(opt + ". " + items[opt - 1]);
        }
        println();
    }

    /**
     * This method prompts the user to enter an object selection
     * @return the int number entered by the user
     */
    public int getUserChoice() {
        //Declare variables used
        String value = "";
        int intValue = -1;
        //Calls the display method
        display();

        do {
            //prompts the user to enter a value and reads it as a string
            print("Enter Selection: ");
            value = readLn();
            try {
                //trys to convert the string to an int
                intValue = Integer.parseInt(value);
                break;
            } catch (NumberFormatException e) {
                //if not an int then will prompt the user to enter another value
                print("Invalid menu option - try again!\n");
            }
        }while (true);

        return intValue;
    }
}

