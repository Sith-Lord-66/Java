package qub.team33.product;

/**
 * Represents a product.
 *
 * @author Adam Thompson (40333846)
 */
public class Product {

    /**
     * Location in vending machine of product
     */
    private final String location;

    /**
     * Name of product
     */
    private String name;

    /**
     * Description of product
     */
    private String description;

    /**
     * Price of product
     */
    private double price;

    /**
     * Quantity of product
     */
    private int quantity;

    /**
     * Constructor for a product object that's called when instantiated and will
     * initialise the attributes.
     *
     * @param location    product location
     * @param name        product name
     * @param description product description
     * @param price       product price
     * @param quantity    product quantity
     */
    public Product(String location, String name, String description, double price, int quantity) {
        this.location = location;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Get the product location.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Get the product name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the product name.
     *
     * @param name product name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the product description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the product description.
     *
     * @param description product description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the product price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the product price.
     *
     * @param price product price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Get the product quantity in stock.
     *
     * @return int value of quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the product quantity.
     *
     * @param quantity product quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns a boolean whether if the product is in stock.
     */
    public boolean inStock() {
        return quantity > 0;
    }

    /**
     * This product purchases a product, it will check if the product
     * is in stock before decrementing the available quantity.
     *
     * @return boolean value whether the product was purchased.
     */
    public boolean purchase() {
        if (!inStock()) {
            return false;
        }

        quantity -= quantity > 0 ? 1 : 0;
        return true;
    }

    @Override
    public String toString() {
        return "Product{" +
                "location='" + location + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

