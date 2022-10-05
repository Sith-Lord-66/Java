package EmployeeSalary;

public class Employee {

    private String name;
    private double salary;

    public Employee(String employeeName, double currentSalary){
        this.name = employeeName;
        this.salary = currentSalary;
    }

    public String getName(){
        return name;
    }
    public double getSalary() {
        return salary;
    }
    public void raiseSalary() {
        this.salary = salary * 1.5;
    }
}
