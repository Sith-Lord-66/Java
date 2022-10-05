import java.util.Scanner;

public class NumberToWordSwitch {

    public static void main (String[] args) {

        System.out.println("Enter the number (as an integer): ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        switch (number) {
            case 1 :  System.out.println("ONE"); break;
            case 2 :  System.out.println("TWO"); break;
            case 3 :   System.out.println("THREE"); break;
            case 4 :   System.out.println("FOUR"); break;
            case 5 :   System.out.println("FIVE"); break;
            case 6 :   System.out.println("SIX"); break;
            case 7 :   System.out.println("SEVEN"); break;
            case 8 :   System.out.println("EIGHT"); break;
            case 9 :   System.out.println("NINE"); break;
            default :  System.out.println("ERROR: you must enter an integer between 1 and 9.");
        }

    }
}