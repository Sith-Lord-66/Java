public class DIY1 {

    public static void main(String[] args) {

        int product = 5;
        int a = 1;
        int b = 2;
        int c = 0;
        int sum = 2;

        while (c <= 5) {
            product = product * 5;
            c += 1;
        }

        while (a != b) {
            sum += a;
            b += 2;
        }

        int x = 1;
        int total = 1;
        while (x <= 10) {
            total += x;
            x += 1;
        }

        int y = 0;
        while (y < 10) {
            System.out.println("y: " + y);
            y += 1;
        }

        int z = 10;
        while (z > 0) {
            z -= 1;
            System.out.println("z: " + z);
        }
    }
}
