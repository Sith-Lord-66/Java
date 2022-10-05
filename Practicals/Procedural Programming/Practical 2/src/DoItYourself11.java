public class DoItYourself11 {

    public static void main(String[] args) {

        int first = 3;
        int second = 4;
        int temp;
        System.out.println("First variable: " + first + " Second variable: " + second);
        temp = first;
        first = second;
        second = temp;
        System.out.println("First variable: " + first + " Second variable: " + second);
    }
}
