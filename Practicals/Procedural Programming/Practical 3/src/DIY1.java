import java.util.Scanner;

public class DIY1 {

    public static void main(String[] args) {
        //A
        int x = 0;
        if (x > 0) {
            System.out.print(x);
        }

        //B
        int y = 0;
        if (1 + x > Math.pow(x, Math.sqrt(2))) {
            y = y + x;
        }


        //C
        x = 0;
        if (x == 1) {
            y++;
        }

        //D
        Scanner in = new Scanner(System.in);
        x = in.nextInt();

        //E
        int x1 = 0;
        int sum = 0;
        if (x1 >= 1 && x1 <= 10) {
            sum = sum + x;
        } else {
            System.out.println("Bad input for x");
        }

        //F
        int grade = 0;
        String letterGrade = "";

        if (grade >= 90) {
            letterGrade = "A";
        } else if (grade >= 80) {
            letterGrade = "B";
        } else if (grade >= 70) {
            letterGrade = "C";
        } else if (grade >= 60) {
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }
    }
}