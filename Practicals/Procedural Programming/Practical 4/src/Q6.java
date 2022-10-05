public class Q6 {

    public static void main(String[] args) {

        PrintChange(5);
        PrintChange(10);
        PrintChange(20);
        PrintChange(50);
        PrintChange(1024);


    }

    public static void PrintChange (int money) {

        double change = money;
        change = change * 100;
        double EachChange = change/4;


        double pound = EachChange / 100;
        int intpound = (int)pound;
        change = change - (intpound*100);

        double fifty = EachChange / 50;
        int intfifty = (int)fifty;
        change = change - (intfifty*50);

        double twenty = EachChange / 20;
        int inttwenty = (int)twenty;
        change = change - (inttwenty*20);

        double ten = EachChange / 10;
        int intten = (int)ten;
        change = change - (intten*10);


        System.out.println("Your Change: ");
        System.out.printf("\nPounds: %d", intpound);
        System.out.printf("\nFifty Pences: %d", intfifty);
        System.out.printf("\nTwenty Pences: %d", inttwenty);
        System.out.printf("\nTen Pences: %d", intten);

    }
}
