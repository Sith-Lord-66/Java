public class DoItYourself8 {

    public static void main(String[] args) {

        String str = "Gateway";
        int i = 3;
        int j = 4;


        String first = str.substring(0,i);
        char positionI = str.charAt(i);
        char positionJ = str.charAt(j);
        String middle = str.substring(i + 1,j);
        String last = str.substring(j + 1,7);

        String fullWord = first + positionI + positionJ + middle + last;
        System.out.println(fullWord);
    }
}
