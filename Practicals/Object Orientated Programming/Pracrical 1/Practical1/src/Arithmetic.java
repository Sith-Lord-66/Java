public class Arithmetic {

    public static void main(String[] args) {
        int value1 = 5;
        int value2 = 3;
        int answer, remainder;

        answer = value1 / value2;  // integer division
        remainder = value1 % value2;   // remainder part

        System.out.println("Value1: " + value1 + "  Value2: " + value2);
        System.out.println("Answer: " + answer);
        System.out.println("Remainder: " + remainder);

        double dblValue = value1 / (double)value2;
        System.out.println("Double Value: " + dblValue);
    }

}