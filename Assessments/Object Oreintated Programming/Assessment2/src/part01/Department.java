package part01;

/**
 * An Enum class defining different departs
 *
 * @author James Ross - 40328644
 *
 */
public enum Department {
    ELECTRICAL("Electrical", 'E'),
    PHOTOGRAPHIC("Photographic",'P'),
    COMPUTING("Computing",'C'),
    BOOKS("Books",'B'),
    MUSIC("Music",'M'),
    FASHION("Fashion",'F'),
    OTHER("Other", 'O');

    //Declare Variables
    private String value;
    private char letter;

    /**
     * This method gives the string and letter of the enum type
     * @param str the string containing the name of the department
     * @param character the letter of department used in creation of the code
     */
    Department(String str, char character){
        value = str;
        letter = character;
    }

    /**
     * The getter for the character letter
     * @return character letter
     */
    public char getLetter(){
        return letter;
    }

    /**
     * The toString that returns the name of the department
     * @return the name of type String
     */
    @Override
    public String toString() {
        return "'"+ value + "'";
    }
}
