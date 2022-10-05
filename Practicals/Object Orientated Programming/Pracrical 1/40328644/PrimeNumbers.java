public class PrimeNumbers {

    public static void main(String[] args) {
        System.out.println(isPrime(13));
    }

    public static boolean isPrime(int num){

        int count = num/2;
        while(count>1){
            if (num % count == 0) return false;
            count--;
        }
        return true;
    }
}
