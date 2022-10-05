import java.util.Arrays;

public class DIY3 {

    public static void main(String[] args) {

        int[] data = {1, 2, 3};
        int[] data1 = {1, 2, 3};
        int[] data2 = {1, 2, 3};

        System.out.print(totalValues(data));
        System.out.print("\n" + equals(data1, data2));
        System.out.println();
        display(toBinary(11));
    }

    //adds together all values within an array
    public static int totalValues(int[] data) {
        if (data == null) {
            return -1;
        }
        //adds together all values within an array
        int sum = 0;
        for (int i : data) {
            sum += i;
        }
        return sum;
    }

    //checks that two arrays are equal
    public static boolean equals(int[] data1, int[] data2) {

        //checks that two arrays are equal
        return Arrays.equals(data1, data2);
    }

    //Displays array
    public static void display(int[] data) {
        String result = "";
        if (data == null) {
            result += "No array - null";
        } else {
            result = "[";
            for (int index = 0; index < data.length; index++) {
                result += data[index];
                if (index < data.length - 1) {
                    result += ", ";
                }
            }
            result += "]";
        }
        System.out.println(result);
    }

    //converts to binary
    public static int[] toBinary(int b) {
        int[] number = {0, 0, 0, 0, 0, 0, 0, 0};

        //If the number is larger than the binary values then it assigns the value one
        if (b >= 128) {
            number[0] = 1;
            b -= 128;
        }
        if (b >= 64) {
            number[1] = 1;
            b -= 64;
        }
        if (b >= 32) {
            number[2] = 1;
            b -= 32;
        }
        if (b >= 16) {
            number[3] = 1;
            b -= 16;
        }
        if (b >= 8) {
            number[4] = 1;
            b -= 8;
        }
        if (b >= 4) {
            number[5] = 1;
            b -= 4;
        }
        if (b >= 2) {
            number[6] = 1;
            b -= 2;
        }
        if (b >= 1) {
            number[7] = 1;
        }
        return number;
    }
}