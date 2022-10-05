package Pets;

public enum Gender {
    /*  list of possible values
  when assigned - the associated constructor is called with
  its integer equivalent. This is used when toString() is called
  for an Enum value - used to index an associated String
 */
    MALE(0), FEMALE(1), UNASSIGNED(2);

    private int gNum;
    private String names[] = {"Male", "Female", "Unknown"};

    private Gender(int num) {
        gNum = num;
    }
    public String toString() {
        return names[gNum];
    }
}
