public class DIY4 {

    public static void main(String[] args) {

        int number = 1;

        while (number < 101) {

            if (number % 4 == 0 && number % 5 != 0) {

                System.out.println(number);
            }

            number ++;
        }
    }
}
