import java.util.Scanner;

public class FibonacciUser {

    public static void main(String[] args) {

        System.out.println("Please enter the nth term");
        Scanner input = new Scanner(System.in);
        // the index n for F(n), starting from n=3
        int n = 3;
        // F(n) to be computed
        int Fn;
        // F(n-1) is initialised to F(2)
        int FnMinus1 = 1;
        // F(n-2) is initialised to F(1)
        int FnMinus2 = 1;
        int nMax = input.nextInt();
        input.close();
        int sum = FnMinus1 + FnMinus2;
        double average;
        System.out.println("The first " + nMax + " Fibonacci numbers are:");
        System.out.print(FnMinus1 + "\t" + FnMinus2 +"\t");

        while (n <= nMax) {
            Fn = FnMinus1 + FnMinus2;
            System.out.print(" " + Fn);
            sum += Fn;
            FnMinus2 = FnMinus1;
            FnMinus1 = Fn;
            n++;
        }
        average = (float) sum/(float) nMax;
        System.out.println("\nAverage: " + average);
        // Compute and display the average (=sum/nMax)
    }
}
