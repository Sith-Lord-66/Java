public class TestArrays {
    public static void main(String[] args) {
        int[] data1 = {1,2,3,4,5};
        int[] data2 = copy(data1);

        System.out.println("A small change to data1:");
        data1[0] = 0;
        System.out.print("Data1 :");
        display(data1);

        System.out.println("Notice that data 2 is unchanged.");
        System.out.print("Data2 :");
        display(data2);
    }

    public static int[] copy(int[] data) {
        if ( data == null ) {
            return null;
        }
        int[] result = new int[data.length];
        for(int index=0;index<data.length;index++) {
            result[index] = data[index];
        }
        return result;
    }

    public static void display(int[] data) {
        String result = "";
        if ( data == null ) {
            result += "No array - null";
        }
        else {
            result = "[";
            for(int index=0;index<data.length;index++) {
                result += data[index];
                if ( index < data.length-1 ) {
                    result += ", ";
                }
            }
            result += "]";
        }
        System.out.println(result);
    }
}
