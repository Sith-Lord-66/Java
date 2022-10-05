public class DIY5 {

    public static void main(String[] args) {

        for (int number = 1; number < 101; number++) {

            if (number % 4 == 0 && number % 5 != 0) {

                System.out.println(number);
            }
        }
    }
}
