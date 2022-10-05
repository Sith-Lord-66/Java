public class DIY6 {

    public static void main(String[] args) {
       numbers(5);
    }

    public static void numbers(int n) {

        int counter = 0;
        int starCounter = 0;

        while (counter < n) {

            while (starCounter < n) {
                System.out.print("*");
                starCounter++;
            }

            System.out.print("\n");
            starCounter = 0;
            counter++;
        }
    }
}
    