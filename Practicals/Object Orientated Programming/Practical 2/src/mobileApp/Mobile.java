package mobileApp;
/**
 * This class models a mobile phone account, also defining some the functions
 * @author James
 */
public class Mobile {

    private String accType, device, number;
    private double balance;
    final private double CALL_COST = 0.245;
    final private double TEXT_COST = 0.078;
    final private double MB_COST = 0.50;

    /**
     * This is the constructor method for the mobile phone object.
     * It sets up the account type, device type, unique mobile number
     * and a balance of zero.
     * @param accType - the account type
     * @param device - the device type
     * @param number - the unique mobile number
     */
    public Mobile (String accType, String device, String number) {
        this.accType = accType;
        this.device = device;
        this.number = number;
        this.balance = 0.0;
    }
    /**
     * This method sets new information into the account type instance variable
     * of the Mobile object
     * @param accType - the new account type
     */
    public void setAccType(String accType) {
        this.accType = accType;
    }
    /**
     * This method sets new information into the device type instance variable
     * of the Mobile object
     * @param device - the new device type
     */
    public void setDevice(String device) {
        this.device = device;
    }
    /**
     * This method sets new information into the number instance variable
     * of the Mobile object
     * @param number - the new mobile number
     */
    public void setNumber(String number) {
        this.number = number;
    }
    /**
     * This method sets new information into the balance instance variable
     * of the Mobile object
     * @param balance - the new balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
    /**
     * This method returns the account type e.g. PAYG or monthly
     * @return - the account type
     */
    public String getAccType() {
        return accType;
    }
    /**
     * This method returns the device type
     * @return - the device type
     */
    public String getDevice() {
        return device;
    }
    /**
     * This method returns the unique mobile number assigned to the account
     * @return - the unique mobile number
     */
    public String getNumber() {
        return number;
    }
    /**
     * This method returns the balance of the account
     * @return - the balance of the account
     */
    public double getBalance() {
        return balance;
    }
    /**
     * This method adds the amount of credit, passed as a variable
     * to this method, to the current balance of the account
     * @param amount - the amount to top the account up by
     */
    public void addCredit(double amount) {
        balance += amount;
    }
    /**
     * This method calculates the cost of a call, by multiplying the minutes
     * (which are passed as a variable to this method) by the call cost per
     * minute (which is a constant of this class), and deducting it from the
     * current balance of the account
     * @param minutes - the number of minutes spent on the call
     */
    public void makeCall (int minutes) {
        balance -= minutes * CALL_COST;
    }
    /**
     * This method calculates the cost of a text, by multiplying the number of
     * texts (which are passed as a variable to this method) by the cost per
     * text (which is a constant of this class), and deducting it from the
     * current balance of the account
     * @param numOfText - the number of text sent
     */
    public void sendText (int numOfText) {
        balance -= numOfText * TEXT_COST;
    }

    public void useData (int numOfMB) {
        balance -= numOfMB * MB_COST;
    }
}

