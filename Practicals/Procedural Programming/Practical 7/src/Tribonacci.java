public class Tribonacci {

    public static void main(String[] args) {
        int n = 4;
        int Tn;
        int TnMinus1 = 2;
        int TnMinus2 = 1;
        int TnMinus3 = 1;
        int nMax = 20;
        int sum = TnMinus1 + TnMinus2 + TnMinus3;
        double average;
        System.out.println("The first " + nMax + " Tribonacci numbers are:");
        System.out.print(TnMinus1 + "\t" + TnMinus2 +"\t" + TnMinus2);

        while (n <= nMax) {
            Tn= TnMinus1 + TnMinus2 + TnMinus3;
            System.out.print("\t" + Tn);
            sum += Tn;
            TnMinus3 = TnMinus2;
            TnMinus2 = TnMinus1;
            TnMinus1 = Tn;
            n++;
        }
        average = (float) sum/(float) nMax;
        System.out.println("\nAverage: " + average);
        // Compute and display the average (=sum/nMax)
    }
}
