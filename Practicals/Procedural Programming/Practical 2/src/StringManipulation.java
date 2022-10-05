public class StringManipulation {

    public static void main(String[] args) {

        String myString = "You are never too old to set another goal or to dream a new dream. C.S.Lewis";
        System.out.println("The number of characters in my string is: " + myString.length());
        System.out.println("Characters 1 to 7: " + myString.substring(1,7));
        System.out.println("Characters 11 to 47: " + myString.substring(11,47));
        System.out.println("Characters at position 23: " + myString.charAt(23));
        System.out.println("The first occurence of a in my string: " + myString.indexOf('a'));
        System.out.println("The first occurence of a in my string starting from position 23: " + myString.indexOf('a',23));
        System.out.println("The   first   occurence   of   re   in   my   string:   "   + myString.indexOf("re"));
        System.out.println("Convert my string to lower case: " + myString.toLowerCase());
        System.out.println("Convert my string to upper case: " + myString.toUpperCase());

    }
}
