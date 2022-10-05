import java.util.Scanner;
public class ReversePrintArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] values = new int[20];
        int sum = 0;
        int currentSize = 0;
        int nextValue;
        System.out.println("Enter a list of integers (press q to quit):");
        while (sc.hasNextInt() && currentSize < values.length) {
            nextValue = sc.nextInt();
            values[currentSize] = nextValue;
            currentSize++;
            sum += nextValue;
        }
        System.out.println("The sum of the numbers = " + sum);
        System.out.println("The numbers in reverse order are:  ");
        for (int i = currentSize - 1; i >= 0; i--) {
            System.out.print(values[i] + " ");
        }
    }
}