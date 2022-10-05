import java.util.Scanner;

public class Vowels {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a letter: ");
        String str = input.nextLine(); // read a line of text
        char letter = str.charAt(0);   // extract the 1st character

        // test to see if char is a vowel
        // or consonant

        if ( letter == 'a' || letter == 'e' || letter == 'i' ||
                letter == 'o' || letter == 'u') {
            System.out.println("Letter is a vowel: " + letter);
        }
        else {
            System.out.println("Letter is not a vowel: " + letter);
        }
    }
}
