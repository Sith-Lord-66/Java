package School;

public class StudentTester {

    public static void main(String[] args) {

        Student james = new Student("James",3,280);
        System.out.println("Name:\t\t" + james.getName());
        System.out.println("Number of Exams:\t" + james.getNoOfExams());
        System.out.println("Total Marks:\t\t" + james.getTotalMark());
        System.out.println("Average Marks:\t\t" + james.getAverageMarks());
        james.addMark(80);
        System.out.println("Total Marks:\t\t" + james.getTotalMark());
        System.out.println("Average Marks:\t\t" + james.getAverageMarks());
        System.out.println("Number of Exams:\t" + james.getNoOfExams());
        james.removeMark(80);
        System.out.println("Total Marks:\t\t" + james.getTotalMark());
        System.out.println("Average Marks:\t\t" + james.getAverageMarks());
        System.out.println("Number of Exams:\t" + james.getNoOfExams());
    }
}
