public class Q3 {
    public static void main(String[] args) {

        double x1 = 3.1;
        double y1 = 5.2;
        double x2 = 6.3;
        double y2 = 10.5;

        double squaredDistance = Math.pow(x1-x2,2) + Math.pow(y1-y2,2);
        double distance = Math.sqrt(squaredDistance);

        double absX = Math.abs(x1) - Math.abs(x2);
        double absY = Math.abs(y1) - Math.abs(y2);
        double chebDistance = Math.max(absX, absY);

        System.out.printf("The Euclidean distance is: %.2f", distance);
        System.out.printf("\nThe Chebyshev distance is: %.2f", chebDistance);

    }
}
