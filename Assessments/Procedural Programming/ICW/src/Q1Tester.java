
public class Q1Tester {

    public static void main(String[] args) {

        System.out.println("Test Case 1");
        getOpChar_Null();
        System.out.println();

        System.out.println("Test Case 2");
        getOpChar_NotNull();
        System.out.println();

        System.out.println("Test Case 3");
        getOpString_Null();
        System.out.println();

        System.out.println("Test Case 4");
        getOpString_NotNull();
        System.out.println();

        System.out.println("Test Case 5");
        getSymbol_Null();
        System.out.println();

        System.out.println("Test Case 6");
        getSymbol_NotNull();
        System.out.println();

        System.out.println("Test Case 7");
        getHobbits_Null();
        System.out.println();

        System.out.println("Test Case 8");
        getHobbits_NotNull();
        System.out.println();

        System.out.println("Test Case 9");
        isLetter_True();
        System.out.println();

        System.out.println("Test Case 10");
        isLetter_False();
        System.out.println();

        System.out.println("Test Case 11");
        isDigit_True();
        System.out.println();

        System.out.println("Test Case 12");
        isDigit_False();
        System.out.println();

        System.out.println("Test Case 13");
        isWhiteSpace_True();
        System.out.println();

        System.out.println("Test Case 14");
        isWhiteSpace_False();
        System.out.println();

        System.out.println("Test Case 15");
        isLineBreak_True();
        System.out.println();

        System.out.println("Test Case 16");
        isLineBreak_False();
        System.out.println();
    }

    public static void getOpChar_Null() {

        System.out.println(Q1.getOp('a'));
        System.out.println("Expected: " + null);
    }

    public static void getOpChar_NotNull() {

        System.out.println(Q1.getOp('='));
        System.out.println("Expected: " + TokenType.OP_ASSIGN);
    }

    public static void getOpString_Null() {

        System.out.println(Q1.getOp("ab"));
        System.out.println("Expected: " + null);
    }

    public static void getOpString_NotNull() {

        System.out.println(Q1.getOp("=="));
        System.out.println("Expected: " + TokenType.OP_EQUAL);
    }

    public static void getSymbol_Null() {

        System.out.println(Q1.getSymbol('a'));
        System.out.println("Expected: " + null);
    }

    public static void getSymbol_NotNull() {

        System.out.println(Q1.getSymbol('('));
        System.out.println("Expected: " + TokenType.LEFT_PAREN);
    }

    public static void getHobbits_Null() {

        System.out.println(Q1.getHobbits("abc"));
        System.out.println("Expected: " + null);
    }

    public static void getHobbits_NotNull() {

        System.out.println(Q1.getHobbits("HobbitsSay"));
        System.out.println("Expected: " + TokenType.HOBBITS_SAY);
    }

    public static void isLetter_True() {
        System.out.println(Q1.isLetter('a'));
        System.out.println("Expected: " + true);
    }

    public static void isLetter_False() {
        System.out.println(Q1.isLetter('1'));
        System.out.println("Expected: " + false);
    }

    public static void isDigit_True() {
        System.out.println(Q1.isDigit('1'));
        System.out.println("Expected: " + true);
    }

    public static void isDigit_False() {
        System.out.println(Q1.isDigit('a'));
        System.out.println("Expected: " + false);
    }

    public static void isWhiteSpace_True() {
        System.out.println(Q1.isWhiteSpace(' '));
        System.out.println("Expected: " + true);
    }

    public static void isWhiteSpace_False() {
        System.out.println(Q1.isWhiteSpace('a'));
        System.out.println("Expected: " + false);
    }

    public static void isLineBreak_True() {
        System.out.println(Q1.isLineBreak('\n'));
        System.out.println("Expected: " + true);
    }

    public static void isLineBreak_False() {
        System.out.println(Q1.isLineBreak('a'));
        System.out.println("Expected: " + false);
    }
}
