package qub.team33.controller;

import qub.team33.product.Product;
import qub.team33.utils.ConfigUtils;
import qub.team33.utils.FileUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a utility class used to manage stored inventory.
 *
 * @author Adam Thompson (40333846)
 */
public class InventoryController {

    /**
     * Get a product by its location in machine otherwise
     * if it doesn't exist return null.
     *
     * @param location product location
     */
    public Product getProduct(String location) {
        Product result = null;

        for (Product product : getProducts()) {
            if (location.equals(product.getLocation())) {
                result = product;
            }
        }

        return result;
    }

    /**
     * This is used to get all products stored & return a list
     * of {@link Product} objects.
     */
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        try {
            List<String> data = FileUtils.getLines(ConfigUtils.INVENTORY_LOCATION);
            // Description variable added by - Evan McCullough
            for (String line : data) {
                String[] parts = line.split(",");
                String location = parts[0].trim();
                String name = parts[1].trim();
                String description = parts[2].trim();
                double price = Double.parseDouble(parts[3].trim());
                int quantity = Integer.parseInt(parts[4].trim());

                products.add(new Product(location, name, description, price, quantity));
            }
        } catch (FileNotFoundException exception) {
            System.out.println(ConfigUtils.ERROR);
            exception.printStackTrace();
        }

        return products;
    }

    /**
     * This will search all stored products & update the product
     * passed in as parameter based on its location.
     *
     * @param product to remove from inventory.
     */
    public void updateProduct(Product product) {
        try {
            List<String> data = FileUtils.getLines(ConfigUtils.INVENTORY_LOCATION);

            for (int i = 0; i < data.size(); i++) {
                String[] parts = data.get(i).split(",");

                if (parts[0].equals(product.getLocation())) {
                    String value = product.getLocation() + "," + product.getName() + "," + product.getDescription() + "," + product.getPrice() + "," + product.getQuantity();
                    data.set(i, value);
                    break;
                }
            }

            FileUtils.overwrite(ConfigUtils.INVENTORY_LOCATION, data);
        } catch (FileNotFoundException exception) {
            System.out.println(ConfigUtils.ERROR);
            exception.printStackTrace();
        }
    }
}
