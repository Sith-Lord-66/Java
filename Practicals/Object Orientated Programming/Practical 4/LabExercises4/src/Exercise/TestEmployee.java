package Exercise;

public class TestEmployee {

    public static void main(String[] args) {
        SalariedEmployee james = new SalariedEmployee("James","BT666AA", 500000);
        Employee harry = new Employee("Harry","BT666AA");
        System.out.println(james);
        System.out.println(james.PayCheck());
        System.out.println(harry);

    }
}
