package Pets;

public class Dog {

    private String name;
    private String breed;
    private int age;
    private Gender gender;

    public Dog(String name, String breed, int age, Gender gender) {
        setName(name);
        setBreed(breed);
        setAge(age);
        setGender(gender);
    }
    public Dog() {
        this(null, null, -1,Gender.UNASSIGNED);
    }

    public void setName(String name) {
        if ( name != null ) {
            this.name = name;
        }
        else {
            if ( this.name == null )
                // a default value
                this.name = "Unknown";
        }
    }
    public void setGender(Gender gender){
        this.gender = gender;
    }
    public void setGender(char gender) {
        if (gender=='M')
            setGender(Gender.MALE);
        else if (gender=='F')
            setGender(Gender.FEMALE);
        else
            setGender(Gender.UNASSIGNED);
    }
    public void setBreed(String breed) {
        if ( breed != null ) {
            this.breed = breed;
        }
        else {
            if (this.breed == null)
                // a default value
                this.breed =
                        "Unknown";
        }
    }
    public void setAge(int age) {
        if ( age >= 0) {
            this.age = age;
        }
        else {
            // a default value
            this.age = -1;
        }
    }

    public String getName() {
        return this.name;
    }
    public String getBreed() {
        return this.breed;
    }
    public int getAge() {
        return this.age;
    }
    public String getGender() {
     return gender.toString();
    }

    public String getDetails() {
        String result = "Name: "+getName()+", Breed: "+getBreed()+
                ", Age: "+getAge()+", Gender: "+getGender();
        return result;
    }

    public String toString() {
        return getDetails();
    }
}