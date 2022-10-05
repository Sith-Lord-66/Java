public class Q5 {

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
            EPCBand epcBand = EPCBand.A;
        }
        else if (rating >= 81) {
            EPCBand epcBand = EPCBand.B;
        }
        else if (rating >= 69) {
            EPCBand epcBand = EPCBand.C;
        }
        else if (rating >= 55) {
            EPCBand epcBand = EPCBand.D;
        }
        else if (rating >= 39) {
            EPCBand epcBand = EPCBand.E;
        }
        else if (rating >= 21) {
            EPCBand epcBand = EPCBand.F;
        }
        else if (rating >= 1) {
            EPCBand epcBand = EPCBand.G;
        }
        else {
            EPCBand epcBand = EPCBand.Invalid;
        }

        
    }

}

