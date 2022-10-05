public class SumAndAverage {

    public static void main(String[] args) {

        int sum = 0;
        double average;
        int upperbound = 100;

        for (int number = 1; number <= upperbound; ++number) {

            sum += number;
        }
        // Compute average in double. Beware that int/int produces int.
        average = (double)sum / (double) upperbound;

        // Print sum and average.
        System.out.println("The sum of all numbers between 1 and 100 is " + sum);
        System.out.println("The average of all numbers between 1 and 100 is " + average);
    }
}
