import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Q3_V1 {

    /**
     * Uses the file directories to locate and read the files using the scan method
     *
     * @param args the main method
     */
    public static void main(String[] args) {

        System.out.println("## Q3example1:");
        scan("src/Q3Example1.txt");

        System.out.println("\n## Q3example2:");
        scan("src/Q3Example2.txt");
    }

    /**
     * To return the Token Type for Weejava Operators of type character
     *
     * @param ch the character
     * @return the Token Type or null value
     */
    public static TokenType getOp(char ch) {

        if (ch == '+') {

            return TokenType.OP_ADD;

        } else if (ch == '-') {

            return TokenType.OP_SUBTRACT;

        } else if (ch == '*') {

            return TokenType.OP_MULTIPLY;

        } else if (ch == '/') {

            return TokenType.OP_DIVIDE;

        } else if (ch == '%') {

            return TokenType.OP_MOD;

        } else if (ch == '=') {

            return TokenType.OP_ASSIGN;

        } else if (ch == '>') {

            return TokenType.OP_GREATER;

        } else if (ch == '<') {

            return TokenType.OP_LESS;

        } else {

            return null;
        }
    }

    /**
     * To return the Token Type for WeeJava operators of type String
     *
     * @param s the string
     * @return the Token Type or null value
     */
    public static TokenType getOp(String s) {

        switch (s) {
            case "==": return TokenType.OP_EQUAL;
            case ">=": return TokenType.OP_GREATEREQUAL;
            case "<=": return TokenType.OP_LESSEQUAL;
            case "!=": return TokenType.OP_NOTEQUAL;
            default: return null;
        }
    }

    /**
     * To return the Token Type for WeeJava symbols of type character
     *
     * @param ch the character
     * @return the Token Type or null value
     */
    public static TokenType getSymbol(char ch) {

        if (ch == '(') {

            return TokenType.LEFT_PAREN;

        } else if (ch == ')') {

            return TokenType.RIGHT_PAREN;

        } else if (ch == '{') {

            return TokenType.LEFT_BRACE;

        } else if (ch == '}') {

            return TokenType.RIGHT_BRACE;

        } else if (ch == '[') {

            return TokenType.LEFT_BRACKET;

        } else if (ch == ']') {

            return TokenType.RIGHT_BRACKET;

        } else if (ch == ';') {

            return TokenType.SEMICOLON;

        } else if (ch == ',') {

            return TokenType.COMMA;

        } else {

            return null;
        }
    }

    /**
     * To return the Token Type for WeeJava Keywords of type String
     *
     * @param s the string
     * @return the Token Type or null value
     */
    public static TokenType getKeyword(String s) {

        switch (s) {
            case "if": return TokenType.KEYWORD_IF;
            case "else": return TokenType.KEYWORD_ELSE;
            case "int": return TokenType.KEYWORD_INT;
            case "String": return TokenType.KEYWORD_STRING;
            case "public": return TokenType.KEYWORD_PUBLIC;
            case "class": return TokenType.KEYWORD_CLASS;
            case "void": return TokenType.KEYWORD_VOID;
            case "static": return TokenType.KEYWORD_STATIC;
            default: return null;
        }
    }

    /**
     * To return the Token Type for WeeJava Hobbits of type String
     *
     * @param s the string
     * @return the Token Type or null value
     */
    public static TokenType getHobbits(String s) {

        if (s.equals("HobbitsSay")) {

            return TokenType.HOBBITS_SAY;

        } else if (s.equals("HobbitsDo")) {

            return TokenType.HOBBITS_DO;

        } else {

            return null;
        }
    }

    /**
     * To return a true value if a character is a letter
     *
     * @param ch the character
     * @return the true or false value
     */
    public static boolean isLetter(char ch) {

        return Character.isLetter(ch);
    }

    /**
     * To return a true value if a character is a digit
     *
     * @param ch the character
     * @return the true or false value
     */
    public static boolean isDigit(char ch) {

        return Character.isDigit(ch);
    }

    /**
     * To return a true value if a character is a space
     *
     * @param ch the character
     * @return the true or false value
     */
    public static boolean isWhiteSpace(char ch) {

        return Character.isWhitespace(ch);
    }

    /**
     * To return a true value if a character is a new line
     *
     * @param ch the character
     * @return the true or false value
     */
    public static boolean isLineBreak(char ch) {

        return ch == '\n';
    }

    /**
     * To read the content of a file into String, then takes out the comments contained within and prints the result
     *
     * @param fname the String containing directory of file
     */
    public static void scan(String fname) {

        int fileLength;
        char character;
        int index;
        char nextCharacter;
        char characterAfterNext;
        char previousCharacter;
        boolean multipleLine = true;
        boolean noTab = false;
        String fileText = null;
        StringBuilder noComments = new StringBuilder();

        //Reads the file into the String fileText
        try {
            fileText = new String((Files.readAllBytes((Paths.get(fname)))));
        } catch (IOException e) {
            System.out.println("Failed to read a file");
        }

        if (fileText == null) System.out.println("Unable to read the file and cannot remove comments code");
        else {

            fileLength = fileText.length();
            index = 0;

            //loops for each character of the String textFile
            while (index < fileLength) {

                character = fileText.charAt(index);

                //Defines the index for every character and ensures correct index range
                if (index == 0) {

                    previousCharacter = 0;
                    nextCharacter = fileText.charAt(index + 1);
                    characterAfterNext = fileText.charAt(index + 2);

                } else if (index < fileLength - 2) {

                    nextCharacter = fileText.charAt(index + 1);
                    characterAfterNext = fileText.charAt(index + 2);
                    previousCharacter = fileText.charAt(index - 1);

                } else if (index > fileLength - 2) {

                    nextCharacter = 0;
                    characterAfterNext = 0;
                    previousCharacter = fileText.charAt(index - 1);

                } else {

                    nextCharacter = 0;
                    characterAfterNext = 0;
                    previousCharacter = 0;
                }

                //Will execute when the characters are the start of a single line comment
                if (character == '/' && nextCharacter == '/') {

                    //Skips characters contained within the comment
                    while (!isLineBreak(character)) {

                        character = fileText.charAt(index);
                        index++;
                    }
                    noTab = true;
                }

                //Will execute when the characters are the start of a multi line comment
                else if (character == '/' && nextCharacter == '*') {

                    //Skips characters contained within the comment
                    while (multipleLine) {

                        int count = 0;

                        if (character == '/') count++;
                        if (previousCharacter == '*') count++;
                        if (count == 2) multipleLine = false;

                        character = fileText.charAt(index);
                        previousCharacter = fileText.charAt(index - 1);
                        index++;
                    }
                    noTab = true;
                }
                //Removes multiple blank lines
                if (isLineBreak(character) && isLineBreak(nextCharacter)) index++;

                //Adds a line break to a String where there are two braces directly beside each other
                if (previousCharacter == '}' && characterAfterNext == '}') noComments.append("\n");

                //Adds a tab after a comment so that there is proper indentation
                if (noTab && character == 'p') {

                    noComments.append("\t");
                    noTab = false;
                }

                //Adds the characters that are not skipped to a String
                noComments.append(character);
                index++;
            }
            System.out.println(noComments);
        }
    }
}

