import java.util.Scanner;

public class DIY6 {

    public static void main(String[] args) {

        double mass = 2;
        double rope = 3;

        Scanner inp = new Scanner(System.in);

        inp.close();

        System.out.println("Please enter Speed: ");
        double v = inp.nextDouble();

        double tension = (mass*(v*v))/rope;

        if (tension <= 60) {
            System.out.println("Rope is okay");
        }
        else {
            System.out.println("Rope is broke");
        }
    }
}
