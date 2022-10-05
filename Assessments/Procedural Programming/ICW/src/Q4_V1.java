import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Q4_V1 {

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

        String fileText = "";

        //Reads the file into the String fileText
        try {

            fileText = new String((Files.readAllBytes((Paths.get(fname)))));
        }
        catch (IOException e) {

            System.out.println("Failed to read a file");
        }

        int fileLength = fileText.length();
        int index = 0;

        //loops for each character of the String textFile
        while (index < fileLength) {

            char character = fileText.charAt(index);
            char nextCharacter = ' ';
            if (index < fileLength - 1) nextCharacter = fileText.charAt(index + 1);

            //Will execute when the next two characters are two slashes (//) indicating a single line comment
            if (character == '/' && nextCharacter == '/') {

                //Skips characters contained within the comment
                while (!isLineBreak(character)) {
                    character = fileText.charAt(index);
                    index++;
                }
                //This loop removes spaces after the comment and ensures correct indentation
                while (isWhiteSpace(character)) {
                    index++;
                    character = fileText.charAt(index);
                }
                continue;
            }
            //Will execute when the next two characters are a slash then a star (/*) indicating a multi line comment
            else if (character == '/' && nextCharacter == '*') {

                index++;
                character = fileText.charAt(index);

                //Skips all characters contained within the comment
                while (character != '/') {

                    character = fileText.charAt(index);
                    index++;
                }
                //This loop removes spaces after the comment and ensures correct indentation
                while (isWhiteSpace(character) || (!isLetter(character) && getSymbol(character) == null)) {
                    index++;
                    character = fileText.charAt(index);
                }
            }
            //Prints out the characters that are not skipped
            System.out.print(fileText.charAt(index));
            index++;
        }
    }
    /**
     * To return a Token Type if a String is within Quotation marks
     * @param s the String
     * @return the Token Type or null value
     */
    public static TokenType isString(String s) {

        if(s.charAt(0) == '"' && s.charAt(s.length()-1) == '"') {

            return TokenType.STRING;

        } else return null;
    }

    /**
     * To take the String created in scan and convert each element of it into its Token Type
     *
     * @param fname the String containing the directory of file
     * @return the String of Token Types contained within the file
     */
   public static String indexer(String fname) {

        int fileLength;
        int index = 0;
        char character;
        char nextCharacter;
        String word = "";
        String quotes = "";
        String twoCharacters = "";
        StringBuilder tokens = new StringBuilder();


       String fileContents = "";

       //Reads the file into the String fileContents
       try {

           fileContents = new String((Files.readAllBytes((Paths.get(fname)))));
       }
       catch (IOException e) {

           System.out.println("Failed to read a file");
       }
        //Uses scan method to get String of the file content
        fileLength = fileContents.length();

        //loops for every character index within the file
        while (index<fileLength) {

            character = fileContents.charAt(index);

            //Ensures correct indexing range
            if (index == fileLength - 1) {

                nextCharacter = 0;

            } else {

                nextCharacter = fileContents.charAt(index + 1);
            }

            //Checks if the character and next character are of Token Type Symbol
            twoCharacters = twoCharacters + character + nextCharacter;
            TokenType operatorTwo = getOp(twoCharacters);

            //Adds the Token Type to a String of all Token Types (tokens)
            if (operatorTwo != null) {

                tokens.append(operatorTwo).append(",");
                index++;
            }
            twoCharacters = "";

            //Joins all characters within "" together into a String (quotes)
            if (character =='"') {

                boolean sentence = true;

                while (sentence) {

                    quotes = quotes + character;
                    index++;
                    character = fileContents.charAt(index);

                    //The if statement will execute once the closing quotation mark is equal to the character
                    if (character == '"') {

                        quotes = quotes + character;
                        //Compares the string quotes against the Token Type String
                        TokenType stringQuote = isString(quotes);

                        //Adds the Token Type of the String to the String tokens
                        if ( stringQuote != null) tokens.append(stringQuote).append(",");
                        sentence = false;
                    }
                }
            }
            //Joins multiple characters together into a String (word)
            else if (isLetter(character) || isDigit(character)) {

                word = word + character;

                if (!Character.isLetterOrDigit(nextCharacter)){

                    //Compares the contents of word against the Token Types Hobbits and Keywords
                    TokenType hobbit = getHobbits(word);
                    TokenType keyword = getKeyword(word);

                    //Adds the Token Types of each to the String tokens
                    if (hobbit != null) tokens.append(hobbit).append(",");
                    if (keyword != null) tokens.append(keyword).append(",");

                    word = "";
                }
            }
            //Adds any spaces into the String tokens
            else if (isWhiteSpace(character)) tokens.append(character);

            //Adds any line breaks into the String tokens
            else if (isLineBreak(character)) tokens.append(character);

            //Compares every remaining character against the Token Types Operator and Symbol
            else if (operatorTwo == null){

                TokenType operatorOne = getOp(character);
                TokenType symbol = getSymbol(character);

                //Adds the Token Types of each Character to the String tokens
                if (operatorOne != null) tokens.append(operatorOne).append(",");
                if (symbol != null) tokens.append(symbol).append(",");
            }
            index++;
        }
        return tokens.toString();
    }
}


