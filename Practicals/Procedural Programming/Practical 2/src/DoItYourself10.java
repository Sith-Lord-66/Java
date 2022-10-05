import java.util.Scanner;

public class DoItYourself10 {

    public static void main(String[] args) {

        final double INCH_CONVERT = 39.37;
        final double YARD_CONVERT = 1.094;
        final double FEET_CONVERT = 3.28;

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a measurement in meters: ");
        double measure = input.nextDouble();
        input.close();

        double measureInInch = measure * INCH_CONVERT;
        double measureInYard = measure * YARD_CONVERT;
        double measureInFeet = measure * FEET_CONVERT;

        String str = String.format("%.2fm is equal to:", measure)
                + String.format("\n%.2f Inches", measureInInch)
                + String.format("\n%.2f Yards", measureInYard)
                + String.format("\n%.2f Feet", measureInFeet);

        System.out.println(str);


    }
}
