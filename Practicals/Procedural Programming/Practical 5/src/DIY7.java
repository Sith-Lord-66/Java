public class DIY7 {

    public static void main(String[] args) {
        numbers(1);
        numbers(10);
        numbers(100);
        numbers(1000);
    }

    public static void numbers(int n) {

        int count = 1;
        double calculation = 1;

        while (n >= count) {
            calculation = calculation * count;
            count ++;
        }

        System.out.println(calculation);
    }

}