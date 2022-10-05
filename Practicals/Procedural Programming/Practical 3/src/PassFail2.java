public class PassFail2 {

    public static void main(String[] args) {

        int examMark = 49;

        System.out.println("The mark is " + examMark);


        if (examMark > 69) {
            System.out.println("Distinction");
        }
        else if (examMark > 59 && examMark < 70) {
            System.out.println("Commendation");
        }
        else if (examMark > 49 && examMark < 60) {
            System.out.println("PASS");
        }
        else {
            System.out.println("FAIL");
        }
    }
}
