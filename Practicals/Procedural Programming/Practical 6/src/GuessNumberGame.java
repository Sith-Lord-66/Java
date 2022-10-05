import java.util.Scanner;

public class GuessNumberGame {

    public static void main(String[] args) {

        boolean win = false;
        int guessOne;
        int guessTwo;
        int number = 5;

        Scanner input = new Scanner(System.in);

        while (!win) {

            System.out.println("Player 1: Please enter a guess: ");
            guessOne = input.nextInt();

            if (guessOne == number) {

                System.out.println("Player 1: you have guessed correctly, Well done!");
                win = true;

            } else if (guessOne <= 10 && guessOne >= 1 ) {

                System.out.println("You have guessed incorrectly");
            }else System.out.println("Not a Valid Entry");


        System.out.println("Player 2: Please enter a guess: ");
            guessTwo = input.nextInt();

            if (guessTwo == number) {

                System.out.println("Player 2: you have guessed correctly, Well done!");
                win = true;
            } else if (guessTwo <= 10 && guessTwo >= 1 ) {

                System.out.println("You have guessed incorrectly");
            } else System.out.println("Not a Valid Entry");
        }


    }
}