package Exercise;

import java.time.LocalDate;

public class Employee {
    private static int nextNumber = 1;
    private int empNumber;
    private String name;
    private String address;
    private String startDate;
    private EmpStatus status;

    public Employee(String name, String add, LocalDate start) {
        setName(name);
        setAddress(add);
        setStartDate(start);
        this.empNumber = nextEmpNumber();
        this.status = EmpStatus.FULL_TIME;
    }

    public Employee(String name, String add) {
        setName(name);
        setAddress(add);
        setStartDate(LocalDate.now());
        this.empNumber = nextEmpNumber();
        this.status = EmpStatus.FULL_TIME;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setStartDate(LocalDate str) {
        this.startDate = str.toString();
    }
    public int nextEmpNumber(){
            int num = nextNumber;
            nextNumber++;
            return num;
    }
    public void setStatus(EmpStatus status) {
        this.status = status;
    }
    public String getStatus() {
        return status.getStatus();
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getStartDate() {
        return startDate;
    }
    public int getNumber() {
        return empNumber;
    }
    public String getSummary() {
        String res = "\n";
        res += "Number: " + this.getNumber() + "\n";
        res += "Name: " + this.getName() + "\n";
        res += "Address: " + this.getAddress() + "\n";
        res += "Start Date: " + this.getStartDate() + "\n";
        res += "Status: " + getStatus() + "\n";
        return res;
    }
    public String toString(){
        return getSummary();
    }
}
