import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Q4_V2 {

    /**
     * Enters values for each method and prints the Token Type or Boolean value for each
     *
     * @param args the main method
     */
    public static void main(String[] args) {

        scan("src/WeeJavaExample.txt");
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

    public static void scan(String fname) {

        String fileContents = readFileToString(fname);
        int fileLength = fileContents.length();
        int index = 0;
        int lineNumber = 1;

        while (index < fileLength) {

            char character = fileContents.charAt(index);

            boolean whiteSpace = isWhiteSpace(character);
            boolean newLine = isLineBreak(character);
            boolean letter = isLetter(character);
            boolean digit = isDigit(character);
            TokenType symbol = getSymbol(character);
            TokenType operator = getOp(character);

            if (whiteSpace) {

                index++;
            }
            else if (newLine) {
                lineNumber+=1;
                index++;
            }
            else if (symbol != null) {

                System.out.println(lineNumber + ", " + symbol + ", " + character);
                index++;
            }
            else if (operator != null || character == '!') {

                String twoCharacters = "";
                twoCharacters += character;
                index ++;
                character = fileContents.charAt(index);

                if (getOp(character) != null) {

                    twoCharacters += character;
                    operator = getOp(twoCharacters);
                    System.out.println(lineNumber + ", " + operator + ", " + twoCharacters);
                }
                else {
                    index--;
                    character = fileContents.charAt(index);
                    System.out.println(lineNumber + ", " + operator + ", " + character);
                }

                index++;
            }

            //Joins multiple characters together into a String (word)
            else if (letter) {

                String word = "";
                word += character;
                index++;

                while (index < fileLength) {

                    character = fileContents.charAt(index);

                    if (isLetter(character)) {

                        word += character;
                        index++;
                    }
                    else break;
                }
                TokenType hobbit = getHobbits(word);
                TokenType keyword = getKeyword(word);

                if (keyword != null) System.out.println(lineNumber + ", " + keyword + ", " + word);
                else if (hobbit != null) System.out.println(lineNumber + ", " + hobbit + ", " + word);
                else System.out.println(lineNumber + ", " + TokenType.IDENTIFIER + ", " + word);

            }
            else  if (digit) {

                String number = "";
                number += character;
                index++;

                while (index < fileLength) {

                    character = fileContents.charAt(index);

                    if (isDigit(character)) {

                        number += character;
                        index++;
                    } else break;
                }
                System.out.println(lineNumber + ", " + TokenType.INTEGER + ", " + number);
            }
            else if (character == '\"') {

                String str = "";
                str += character;
                index++;

                while (index < fileLength) {

                    character = fileContents.charAt(index);
                    str += character;
                    index++;

                    if (character == '\"') break;
                }
                System.out.println(lineNumber + ", " + TokenType.STRING + ", " + str);
            }
            else {
                System.out.println("Encountered something not expected:" + character);
                index ++;
            }
        }
    }
}

