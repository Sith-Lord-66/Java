public class DIY3 {

    public static void main(String[] args) {

        String sentence = "This is a sentence";
        boolean condition = true;
        int x = 0;
        int spaceCount = 0;
        int vowelCount = 0;

        while (condition) {

            switch (sentence.charAt(x)) {
                case 'a':
                case 'e':
                case 'i':
                case 'u':
                case 'o':
                    vowelCount += 1;
                    break;
                default:
                    break;
            }

            if (Character.isWhitespace(sentence.charAt(x))) {
                spaceCount += 1;
                x += 1;

            } else if (Character.isUpperCase(sentence.charAt(x))) {
                System.out.println(sentence.charAt(x));
                x += 1;

            } else if (x == sentence.length() - 1) {
                System.out.println("There are " + (sentence.length() - spaceCount) + " letters in the sentence: " + sentence
                        + "\nThe number of vowels in the sentence are: " + vowelCount);
                condition = false;

            } else {
                x += 1;
            }
        }
    }
}

