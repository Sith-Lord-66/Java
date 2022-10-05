package School;

public class Student {

    private String name;
    private int noOfExams;
    private double totalMark;

    public Student (String name, int exams, double mark){
        this.name = name;
        this.noOfExams = exams;
        this.totalMark = mark;
    }
    public String getName() {
        return name;
    }
    public double getTotalMark() {
        return totalMark;
    }
    public int getNoOfExams() {
        return noOfExams;
    }
    public void addMark (double marks){
        this.totalMark += marks;
        this.noOfExams += 1;
    }
    public double getAverageMarks(){
        return totalMark/noOfExams;
    }
    public void removeMark(int mark){
        this.totalMark -= mark;
        this.noOfExams -= 1;
    }
}
