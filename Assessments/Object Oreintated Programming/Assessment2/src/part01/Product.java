package part01;
/**
 * A Object class defining a Product object
 *
 * @author James Ross - 40328644
 *
 */
public class Product implements iPro{

    //Defining object attributes
    private String code;
    private String make;
    private String model;
    private double price;
    private int quantity;
    private int purchases;
    private Department dept;
    private static int codeNumber = 1;

    /**
     * Constructor for the Product object with an int Quantity value
     * @param make a String containing the make of the Product
     * @param model a String containing the model of the Product
     * @param price a double containing the price of the Product
     * @param dept a Department containing the enum for department type
     * @param quantity an int Quantity containing the quantity of a Product
     */
    public Product(String make, String model, double price, Department dept, int quantity){
        if (make == null) this.make = "unknown make";
        else this.make = make;
        if (model == null) this.model = "unknown model";
        else this.model = model;
        if (price <= 0) this.price = 1.00;
        else this.price = price;
        this.dept = dept;
        if (quantity <= 0) this.quantity = 0;
        else this.quantity = quantity;
        setCode();

    }

    /**
     * Constructor for the Product object
     * @param make a String containing the make of the Product
     * @param model a String containing the model of the Product
     * @param price a double containing the price of the Product
     * @param dept a Department containing the enum for department type
     */
    public Product(String make, String model, double price, Department dept){
        if (make == null) this.make = "unknown make";
        else this.make = make;
        if (model == null) this.model = "unknown model";
        else this.model = model;
        if (price <= 0) this.price = 1.00;
        else this.price = price;
        this.dept = dept;
        this.quantity = 0;
        setCode();
    }

    /**
     * The method used to assign the code to a Product, this increments after ever product
     */
    private void setCode(){
        this.code = dept.getLetter() + String.format("%04d",codeNumber);
        codeNumber++;
    }

    /**
     * The method used to add a purchase to a Product
     * and remove one Quantity
     * @return
     */
    @Override
    public boolean recordPurchase() {
        if (quantity>0){
            purchases += 1;
            quantity -= 1;
            return true;
        }else return false;
    }

    /**
     * The method used to add a specified amount to quantity
     * @param quant the int amount to be added
     */
    @Override
    public void addToQuantity(int quant) {
        if (quant>0) quantity += quant;
    }

    /**
     * The getter for Purchases
     * @return the int purchases
     */
    @Override
    public int getPurchases() {
        return purchases;
    }

    /**
     * The getter for the code
     * @return the String code
     */
    @Override
    public String getCode() {
        return code;
    }

    /**
     * The getter for make
     * @return the String make
     */
    @Override
    public String getMake() {
        return make;
    }

    /**
     * The getter for model
     * @return the String model
     */
    @Override
    public String getModel() {
        return model;
    }

    /**
     * The getter for price
     * @return the double price
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * The getter for quantity
     * @return the int quantity
     */
    @Override
    public int getQuantity() {
        return quantity;
    }

    /**
     * The getter for Department
     * @return the Department dept
     */
    @Override
    public Department getDepartment() {
        return dept;
    }

    /**
     * The toString for Product
     * @return a String containing the Product details
     */
    @Override
    public String toString() {
        return "Product: " +
                "Code = '" + code + '\'' +
                ", Make = '" + make + '\'' +
                ", Model = '" + model + '\'' +
                ", Price = " + price +
                ", Quantity = " + quantity +
                ", Purchases = " + purchases +
                ", Dept = " + dept;
    }
}
