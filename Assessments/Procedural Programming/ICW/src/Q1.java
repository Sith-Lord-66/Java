public class Q1 {

    /**
     * Enters values for each method and prints the Token Type or Boolean value for each
     *
     * @param args the main method
     */
    public static void main(String[] args) {
        TokenType op1 = getOp('+');
        System.out.println("op1: " + op1);

        TokenType op2 = getOp("==");
        System.out.println("op2: " + op2);

        TokenType sym = getSymbol('{');
        System.out.println("symbol: " + sym);

        TokenType keyword = getKeyword("int");
        System.out.println("keyword: " + keyword);

        TokenType hobbits = getHobbits("HobbitsSay");
        System.out.println("hobbits: " + hobbits);

        boolean letter = isLetter('a');
        System.out.println("letter: " + letter);

        boolean digit = isDigit('0');
        System.out.println("digit: " + digit);

        boolean whiteSpace = isWhiteSpace(' ');
        System.out.println("whiteSpace: " + whiteSpace);

        boolean newline = isLineBreak('\n');
        System.out.println("newline: " + newline);
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
}
