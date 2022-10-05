public class Q4 {

    public static void main(String[] args) {
        printEPCBand(0);
        printEPCBand(1);
        printEPCBand(21);
        printEPCBand(39);
        printEPCBand(55);
        printEPCBand(69);
        printEPCBand(81);
        printEPCBand(92);
        printEPCBand(101);

    }

    public static void printEPCBand(int rating) {

        if (rating >=92 && rating <= 100) {
            System.out.println(rating + ": EPC rating band A");
        }
        else if (rating >= 81 && rating <= 100) {
            System.out.println(rating + ": EPC rating band B");
        }
        else if (rating >= 69 && rating <= 100) {
            System.out.println(rating + ": EPC rating band C");
        }
        else if (rating >= 55 && rating <= 100) {
            System.out.println(rating + ": EPC rating band D");
        }
        else if (rating >= 39 && rating <= 100) {
            System.out.println(rating + ": EPC rating band E");
        }
        else if (rating >= 21 && rating <= 100) {
            System.out.println(rating + ": EPC rating band F");
        }
        else if (rating >= 1 && rating <= 100) {
            System.out.println(rating + ": EPC rating band G");
        }
        else {
            System.out.println(rating + ": Invalid EPC rating");
        }


    }

}
