public class Swap {
    public static void main(String[] args) {
        int first = 3;
        int second = 4;
        int temp;
        System.out.println("First variable: "+first+" Second variable: "+second);
        temp = second;
        second = first;
        first = temp;
        System.out.println("First variable: "+first+" Second variable: " + second);
    }
}