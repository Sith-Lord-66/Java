import java.util.Scanner;

public class DIY7 {

    public static void main(String[] args) {

        System.out.println("Please enter the % you got in the exam:");

        Scanner inp = new Scanner(System.in);
        int percent = inp.nextInt();

        inp.close();


        if (percent >= 60){
            System.out.println("Passed");
        }

        if (percent >= 0 && percent <= 100) {
            if (percent >= 90 ) {
                System.out.println("Grade is : A*");
            }
            else if (percent >= 80) {
                System.out.println("Grade is : A");
            }
            else if (percent >= 70) {
                System.out.println("Grade is : B");
            }
            else if (percent >= 60) {
                System.out.println("Grade is : C");
            }
            else if (percent >= 50) {
                System.out.println("Grade is : D");
            }
            else if (percent >= 40) {
                System.out.println("Grade is : E");
            }
            else {
                System.out.println("Grade is : U");
            }
        }
        else {
            System.out.println("Invalid % entered.");
        }
    }
}
