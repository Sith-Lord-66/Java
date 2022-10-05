public class TestCalc {

    public static void main(String[] args) {
        int number1 = 98;
        int number2 = 5;
        int sum, difference, product, quotient;

        // Perform arithmetic Operations and print results
        sum = number1 + number2;
        difference = number1 - number2;
        product = number1 * number2;
        quotient = number1 / number2;
        System.out.println("The sum, difference, product and quotient of " + number1 + " and " + number2
                + " are : " + sum + ", " + difference + ", " + ", " + product + ", and " + quotient);
        // Increment the value stored in the variable "number1" by 1
        number1++;
        // Decrement the value stored in the variable "number2" by 1
        number2--;
        System.out.println("number1 after increment is " + number1
            +"\nnumber2 after decrement is " + number2);
        quotient = number1 / number2;
        System.out.println("The  quotient  of  " + number1 + "  and  " + number2 + "  is  " + quotient);
    }
}
