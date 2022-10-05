import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Q5 {

    /**
     * Enters values for each method and prints the Token Type or Boolean value for each
     *
     * @param args the main method
     */
    public static void main(String[] args) {

        System.out.println("## Q5Example1:");
        scan("src/Q5Example1.txt");

        System.out.println("\n## Q5Example2:");
        scan("src/Q5Example2.txt");

        System.out.println("\n## Q5Example3:");
        scan("src/Q5Example3.txt");
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
     * To Read a file and place its contents into a String
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
     * To find Syntax errors contained within a String and skip everything else
     * @param fname The location of the file as a String - used in the method ReadFileToString
     */
    public static void scan(String fname) {

        //Reads the contents of the file into a string
        String fileContents = readFileToString(fname);
        int fileLength = fileContents.length();
        int index = 0;
        int lineNumber = 1;
        int methodCount = 0;
        int braceError = 0;
        TokenType lastSymbol = null;

        //Repeats for each character index of the string
        while (index < fileLength) {

            char character = fileContents.charAt(index);
            boolean whiteSpace = isWhiteSpace(character);
            boolean newLine = isLineBreak(character);
            boolean letter = isLetter(character);
            boolean digit = isDigit(character);
            TokenType symbol = getSymbol(character);
            TokenType operator = getOp(character);

            //Checks for presence of a '{' to ensure correct syntax
            if (character == '{') methodCount++;
            if (character == '}') methodCount--;

            //Skips the spaces and tabs
            if (whiteSpace) {

                index++;
            }
            //Skips the line break and increments the line number
            else if (newLine) {

                lineNumber+=1;
                index++;
            }
            //Skips any symbols present and stores the most recent one
            else if (symbol != null) {

                lastSymbol = symbol;
                index++;
            }
            //Skips any operators present
            else if (operator != null || character == '!') {

                index ++;
                character = fileContents.charAt(index);

                //checks for any single character operators present
                if (getOp(character) == null) {

                    index--;
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

                    //Stops adding to the word once there is no longer a letter or number
                    if (isLetter(character)|| isDigit(character)) {

                        word += character;
                        index++;
                    }
                    else break;
                }
                TokenType keyword = getKeyword(word);

                // Checks to see if there was a closing brace before a keyword public and prints an error
                if (keyword == TokenType.KEYWORD_PUBLIC  && lastSymbol != TokenType.RIGHT_BRACE && methodCount>1) {

                    braceError ++;
                    System.out.println("Syntax Error, insert \"}\" to complete class body\nAt line " + (lineNumber-1));
                }
            }
            //Checks for the presence of a digit
            else  if (digit) {

                index++;

                while (index < fileLength) {

                    character = fileContents.charAt(index);

                    if (isDigit(character)) {

                        index++;
                    }
                    //If a letter is present an error message will print
                    else if (isLetter(character)) {

                        System.out.println("Syntax Error on token \"" + fileContents.charAt(index-1)
                                + "\", delete this token\nAt line " + lineNumber);
                        break;
                    }
                    else break;
                }
            }
              /*Takes a String contained within quotation marks
            Then skips it.
            */
            else if (character == '\"') {

                index++;

                while (index < fileLength) {

                    character = fileContents.charAt(index);
                    index++;

                    //Checks for incorrect closing of a String and prints an error
                    if(character == ')' || character == ';') {

                        System.out.println("String literal is not properly closed by a double-quote"
                                + "\nAt line "+ lineNumber);
                        break;
                    }
                    if (character == '\"') break;
                }
            }
            //Prints a statement when a character is not able to be parsed to a token type correctly
            else {

                System.out.println("Encountered something not expected:" + character);
                index ++;
            }
        }
        methodCount = methodCount - braceError;
        //Prints an error if the class is not closed off with a brace correctly
        if (methodCount != 0) {

            System.out.println("Syntax Error, insert \"}\" to complete class body\nAt line " + lineNumber);
        }
    }
}

