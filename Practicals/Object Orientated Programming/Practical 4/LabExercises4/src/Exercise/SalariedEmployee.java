package Exercise;

public class SalariedEmployee extends Employee {
    private double salary;  // annual salary
    private double bonus;  // set as a % of annual salary

    public SalariedEmployee(String name, String address, double salary) {
        super(name, address);
        setSalary(salary);
        bonus = 0.0;
    }

    public void setSalary(double salary) {
        if ( salary > 0.0 ) {
            this.salary = salary;
        }
        else {
            this.salary = 0.0;
        }
    }
    public double getSalary() {
        return salary;
    }
    public double getBonus() {
        return bonus;
    }
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double calculatePay(){
        double pay;
        if(getStatus().equals("Part Time Employment")){
            pay = this.salary * 0.5;
            pay = pay/12;
        } else pay = this.salary/12;
        return pay;
    }
    public double calculateTax(double amt) {
        return amt * 0.2;
    }
    public String PayCheck(){
        String res = "";
        double pay = calculatePay();
        double tax = calculateTax(pay);
        res += "\nGross Pay: £" + String.format("%.2f", pay) ;
        res += "\nTax Paid: £" + String.format("%.2f", tax);
        res += "\nNet Pay: £" + String.format("%.2f", (pay-tax));
        return res;
    }
    @Override
    public String getSummary() {
        String res = "Salaried Employee Summary\n";
        int num = res.length();
        for(int index=0; index<num; index++){
            res += "=";
        }
        res += "\n";
        res += super.getSummary();
       res += "Annual Salary: " + getSalary() + " Bonus (%): " + String.format("%.2f", getBonus());
       return res;
    }
}