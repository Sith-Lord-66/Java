package qub.team33.verification;

/**
 * @author 40328644 - James Ross
 */
public class Verification {

    //Declare Code variable
    private final int code;

    /**
     * The constructor for the Verification object
     * @param code the code used to verify card payments.
     */
    public Verification(int code) {
        this.code = code;
    }

    /**
     * This method checks that any other method of verification such as face ID is successful
     * @param correct the boolean value indicating successful verification
     * @return the true or false value
     */
    public boolean runVerification(boolean correct) {
        if (correct) {
            System.out.println("Verification complete");
            return correct;
        } else {
            System.out.println("Verification failed");
            return false;
        }
    }

    /**
     * This method is used to check if an entered code matches the verification code
     * @param code the user entered code
     * @return a true or false value depending on if the code matches
     */
    public boolean verifyCode(int code) {
        return code == this.code;
    }
}
