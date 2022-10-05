public class PayRoll {

    public static void main(String[] args) {
        final double PAY_PER_HOUR = 6.50;
        int hours = 8;
        int days = 5;
        int weeks = 10;
        double finalPay = PAY_PER_HOUR * hours * days * weeks;
        System.out.printf("Pay: £%.2f", finalPay);

    }
}
