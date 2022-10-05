
public class TestCalc {

	public static void main(String[] args) {
		int number1 = 98;
		int number2 = 5;
		int number3 = 77;
		int sum, difference, product, quotient;
		// Perform arithmetic Operations and print results
		sum = number1 + number2 + number3;
		difference = number1 -number2;
		product = number1 * number2 * number3;
		quotient = number1 / number2;
		System.out.print("The sum, difference, product and quotient of ");
		System.out.print(number1 + ", ");
		System.out.print(number2);
		System.out.print(" and ");
		System.out.print(number3);
		System.out.print(" are : ");
		System.out.print(sum);System.out.print(", ");
		System.out.print(difference);System.out.print(", ");
		System.out.print(product);System.out.print(", and ");
		System.out.println(quotient);
		// Increment the value stored in the variable "number1" by 1
		number1++;
		// Decrement the value stored in the variable "number2" by 1
		number2--;
		System.out.println("number1 after increment is " + number1);
		System.out.println("number2 after decrement is " + number2);
		quotient = number1 / number2;
		System.out.println("The quotient of " + number1 + " and " + number2 + " is " + quotient);
		int numberMultiply = number1 * 31;
		int numberAdd = number2 + 17;
		int number3Multiply = number3 * 87;
		System.out.println(number1 + " times by 31 = " + numberMultiply);
		System.out.println(number2 + " add 17 = " + numberAdd);
		System.out.println(number3 + " times by 8 7= " + number3Multiply);

	}

}
