import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Q3_V4 {

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

        if (ch == '+') return TokenType.OP_ADD;
        else if (ch == '-') return TokenType.OP_SUBTRACT;
        else if (ch == '*') return TokenType.OP_MULTIPLY;
        else if (ch == '/') return TokenType.OP_DIVIDE;
        else if (ch == '%') return TokenType.OP_MOD;
        else if (ch == '=') return TokenType.OP_ASSIGN;
        else if (ch == '>') return TokenType.OP_GREATER;
        else if (ch == '<') return TokenType.OP_LESS;
        else return null;
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

        if (ch == '(') return TokenType.LEFT_PAREN;
        else if (ch == ')') return TokenType.RIGHT_PAREN;
        else if (ch == '{') return TokenType.LEFT_BRACE;
        else if (ch == '}') return TokenType.RIGHT_BRACE;
        else if (ch == '[') return TokenType.LEFT_BRACKET;
        else if (ch == ']') return TokenType.RIGHT_BRACKET;
        else if (ch == ';') return TokenType.SEMICOLON;
        else if (ch == ',') return TokenType.COMMA;
        else return null;
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

        if (s.equals("HobbitsSay")) return TokenType.HOBBITS_SAY;
        else if (s.equals("HobbitsDo")) return TokenType.HOBBITS_DO;
        else return null;
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

        if (ch == ' ') return true;
        else return ch == '\t';
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
     * To Read a file and place its contents into an a String
     * @param fname The location of the file as a String
     * @return the String containing the text from the file
     */
    public static String readFileToString(String fname) {

        String fileContents = "";

        //Reads the file into the String fileContents
        try {

            fileContents = new String((Files.readAllBytes((Paths.get(fname)))));
        }
        catch (IOException e) {

            System.out.println("Failed to read a file");
        }
        return fileContents;
    }

    /**
     * To read the content of a file into String, then takes out the comments contained within and prints the result
     *
     * @param fname the String containing directory of file
     */
    public static void scan(String fname) {

        //Reads file using the readFileToString method
        String fileContents = readFileToString(fname);
        int fileLength = fileContents.length();
        int index = 0;

        int lineIndex = 0;
        //loops for each character of the String textFile
        while (index < fileLength) {

            char character = fileContents.charAt(index);
            char nextCharacter = ' ';
            if (index < fileLength - 1) nextCharacter = fileContents.charAt(index + 1);

            //Will execute when the next two characters are two slashes (//) indicating a single line comment
            if (character == '/' && nextCharacter == '/') {

                //Skips characters until the end of the comment (\n)
                while (character != '\n') {
                    character = fileContents.charAt(index);
                    index++;
                }

                character = fileContents.charAt(index);

                //Remove spaces that remain after getting rid of comment
                while (isWhiteSpace(character)) {
                    index++;
                    character = fileContents.charAt(index);
                }
                continue;
            }
            //Will execute when the next two characters are a slash then a star (/*) indicating a multi line comment
            else if (character == '/' && nextCharacter == '*') {

                index++;
                character = fileContents.charAt(index);

                //Skips all characters until the end of the comment (/)
                while (character != '/') {

                    character = fileContents.charAt(index);
                    index++;
                }

                character = fileContents.charAt(index);

                //Remove spaces that remain after getting rid of comment
                while (isWhiteSpace(character) || isLineBreak(character)) {

                    index++;
                    character = fileContents.charAt(index);
                }
                continue;
            }
            //Prints out the characters that are not skipped
            System.out.print(fileContents.charAt(index));
            index++;
        }
    }
}
