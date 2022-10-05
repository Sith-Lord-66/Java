public class DIY7 {

    public static void main(String[] args) {

        numbers(1);
        numbers(10);
        numbers(100);
        numbers(1000);
    }

    public static void numbers(int n) {

        int sumOfProduct = 0;

        for (int count = 1; count <= n; count++) {

            sumOfProduct += count * n;
        }

        System.out.println(sumOfProduct);
    }
}
