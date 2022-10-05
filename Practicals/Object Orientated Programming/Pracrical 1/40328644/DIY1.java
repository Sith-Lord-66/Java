public class DIY1 {

    public static void main(String[] args) {

        //Prints the sum of numbers 1-10
        printSum();
    }

    public static void printSum(){
        int sum = 0;

        //adds each number together
        for (int number = 1; number <= 10; number++){
            sum += number;
        }
        System.out.print(sum);
    }
}
