public class SumAndAverageWhile {

    public static void main(String[] args) {
        int sum = 0;
        double average;
        int upperbound = 100;
        int number = 1;
        while (number <= upperbound) {
            sum += number;
            number ++;
        }

        average = (double) number /2f;
        System.out.println("The sum of all numbers between 1 and 100 is " + sum
                +"\nThe Average of all numbers between 1 and 100 is " + average);
    }
}
