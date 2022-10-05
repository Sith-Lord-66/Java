public class Temperature {

    public static void main(String[] args) {
        System.out.println("The Fahrenheit equivalent of 20 degrees Celsius is:"
                + String.format("%.2f",converter(20)));
    }
    public static double converter(double temp){
        return (9f/5f * temp)+32;
    }
}
