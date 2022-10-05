package EmployeeSalary;

public class EmployeeTester {

    public static void main(String[] args) {
        Employee james = new Employee("James", 7.5);
        System.out.println("EmployeeSalary.Employee Name:\t\t" + james.getName());
        System.out.println("EmployeeSalary.Employee Salary:\t" + james.getSalary());
        james.raiseSalary();
        System.out.println("New Salary:\t\t\t" + james.getSalary());
    }
}
