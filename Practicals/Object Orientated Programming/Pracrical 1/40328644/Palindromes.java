import java.util.Scanner;

public class Palindromes {

    public static void main(String[] args) {

        String word = askUser();

        String newWord = reverseWord(word);

        printPalindrome(word, newWord);
    }

    public static String askUser() {

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a word: ");

        return input.nextLine();
    }

    public static String reverseWord(String word){
        String newWord = "";
        int wordLength = word.length();

        for (int count = wordLength-1; count>=0; count--){
            newWord += word.charAt(count);
        }
        return newWord;
    }

    public static void printPalindrome(String word, String newWord){

        if (word.equals(newWord)){
            System.out.println(word + " is a palindrome");
        }
        else System.out.println(word + " is not a palindrome");
    }
}
