public class Factorial {

    public static void main(String[] args) {
        System.out.print(calcFactorial(2));
    }

    public static int calcFactorial(int number){
        if (number ==0) return 1;

        int total = number;
        for (int count = number-1; count>0; count--){
            total = total*count;
        }
        return total;
    }

}
