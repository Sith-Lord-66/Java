public class q1TesterKeywords {

    public static void main(String[] args) {

        System.out.println("Test Case 1");
        getKeywords_Null();
        System.out.println();

        System.out.println("Test Case 2");
        getKeywords_if();
        System.out.println();

        System.out.println("Test Case 3");
        getKeywords_else();
        System.out.println();

        System.out.println("Test Case 4");
        getKeywords_int();
        System.out.println();

        System.out.println("Test Case 5");
        getKeywords_String();
        System.out.println();

        System.out.println("Test Case 6");
        getKeywords_public();
        System.out.println();

        System.out.println("Test Case 7");
        getKeywords_class();
        System.out.println();

        System.out.println("Test Case 8");
        getKeywords_void();
        System.out.println();

        System.out.println("Test Case 9");
        getKeywords_static();
        System.out.println();
    }

    public static void getKeywords_Null() {

        System.out.println(Q1.getKeyword("abc"));
        System.out.println("Expected: " + null);
    }

    public static void getKeywords_if() {

        System.out.println(Q1.getKeyword("if"));
        System.out.println("Expected: " + TokenType.KEYWORD_IF);
    }

    public static void getKeywords_else() {

        System.out.println(Q1.getKeyword("else"));
        System.out.println("Expected: " + TokenType.KEYWORD_ELSE);
    }

    public static void getKeywords_int() {

        System.out.println(Q1.getKeyword("int"));
        System.out.println("Expected: " + TokenType.KEYWORD_INT);
    }

    public static void getKeywords_String() {

        System.out.println(Q1.getKeyword("String"));
        System.out.println("Expected: " + TokenType.KEYWORD_STRING);
    }

    public static void getKeywords_public() {

        System.out.println(Q1.getKeyword("public"));
        System.out.println("Expected: " + TokenType.KEYWORD_PUBLIC);
    }

    public static void getKeywords_class() {

        System.out.println(Q1.getKeyword("class"));
        System.out.println("Expected: " + TokenType.KEYWORD_CLASS);
    }

    public static void getKeywords_void() {

        System.out.println(Q1.getKeyword("void"));
        System.out.println("Expected: " + TokenType.KEYWORD_VOID);
    }

    public static void getKeywords_static() {

        System.out.println(Q1.getKeyword("static"));
        System.out.println("Expected: " + TokenType.KEYWORD_STATIC);
    }
}
