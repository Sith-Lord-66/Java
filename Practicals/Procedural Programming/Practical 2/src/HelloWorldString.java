public class HelloWorldString {

    public static void main (String[] args) {

        String phrase = "Hello World";
        String phrase2 = phrase.substring(0,5);
        String phrase3 = "What is the time?";
        String phrase4 = phrase3.substring(12,16);
        System.out.println(phrase2 + " " + phrase4);

    }
}
